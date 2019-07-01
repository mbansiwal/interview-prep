package tree.suggest;

/*
 * Copyright 2011-2012 Nicolai Diethelm
 *
 * This software is free software. You can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * This software is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */


import java.util.Arrays;
import java.util.Random;

/**
 * A data structure for rank-based autocomplete (automatic word completion).
 * It provides O(log n) time for the {@code getBestSuggestions} method and the
 * update methods ({@code incrementScore}, {@code decrementScore}, {@code put},
 * and {@code remove}). The space requirements of the structure are O(n).
 * <p>
 * The structure is based on a compressed ternary search tree where each node
 * holds a rank-ordered array of references to the top k suggestions that start
 * with the prefix or prefixes represented by the node. Besides the suggestion
 * list, each node holds a reference to its suggestion (if a suggestion ends at
 * the node) or any of the suggestions in its subtree. The character sequence of
 * a node is read from this suggestion, only the first character and the ending
 * index of the sequence are stored explicitly.
 * <p>
 * Unlike with binary search trees, the height of unbalanced ternary search
 * trees typically stays small, even in the worst case. However, to achieve best
 * performance, this tree uses a balancing scheme derived from randomized binary
 * search trees (treaps): each suggestion in the tree is assigned a random
 * priority and the nodes are ordered as if the suggestions were inserted in
 * priority order into the tree. This way, each time we go left or right in the
 * tree, the number of suggestions in the subtree is cut approximately in half
 * on average. The expected height of the tree is thus O(log n + m), with m
 * being the length of the longest suggestion string.
 * <p>
 * Holding a precomputed suggestion list at each node may seem space consuming
 * at first glance. But because for each suggestion inserted into the tree at
 * most one new node is added and at most one existing node is split into two
 * nodes, the number of nodes in the tree is always less than 2n. And because
 * the number of nodes at a certain depth in the tree typically increases
 * exponentially with the depth, the average length of the suggestion lists in
 * the tree is logarithmic in k in the expected case. Let's look, for example,
 * at a simple prefix tree (not a ternary search tree) with n leaf nodes, in
 * which all leaf nodes are at the same depth and each internal node has exactly
 * two child nodes. Such a tree would have n nodes with a suggestion list of
 * length 1, n/2 nodes with a suggestion list of length 2, n/4 nodes with a
 * suggestion list of length 4, and so on until the maximum list length of k is
 * reached. Assuming k is a power of two, this gives a total list length of
 * n + 2(n/2) + 4(n/4) + ... + k(n/k) + k(n/k - 1), which is approximately
 * n (log<sub>2</sub>k + 2). Analogously, a tree with d child nodes per node
 * would have a total list length of n (log<sub>d</sub>k + s), where
 * s = 1/(1 - 1/d) is the sum of a geometric series.
 * <p>
 * Note that this implementation is not synchronized. If multiple threads access
 * a tree concurrently, and at least one of the threads modifies the tree (by
 * calling any of the update methods), it must be synchronized externally.
 * 
 * @version 7 December 2012
 */
public class SuggestTree {
    
    private static final AutocompleteSuggestionList EMPTY_LIST = new AutocompleteSuggestionList();
    
    private final Random random = new Random();
    private final int k;
    private AutocompleteSuggestionList root = null;
    private int size = 0;
    
    // auxiliary fields
    private Suggestion present;
    private int listPos;
    private int putCase;
    
    /**
     * Creates a tree that returns the top {@code k} autocomplete suggestions
     * for a given prefix.
     * 
     * @param k number of autocomplete suggestions to return for a given prefix
     * (if present)
     * @throws IllegalArgumentException if the specified {@code k} value is less
     * than 1
     */
    public SuggestTree(int k) {
        if(k < 1)
            throw new IllegalArgumentException();
        this.k = k;
    }
    
    /**
     * Returns the number of suggestions in this tree.
     * 
     * @return the number of suggestions in this tree
     */
    public int size() {
        return size;
    }

    /**
     * Removes all of the suggestions from this tree.
     */
    public void clear() {
        root = null;
        size = 0;
    }
    
    /**
     * Returns an array containing all of the suggestions in this tree.
     * The suggestions are in lexicographic order.
     * 
     * @return an array containing all of the suggestions in this tree
     */
    public Suggestion[] toArray() {
        Suggestion[] a = new Suggestion[size];
        int[] i = {0};
        collectSuggestions(a, i, root);
        return a;
    }
    
    private void collectSuggestions(Suggestion[] a, int[] i, AutocompleteSuggestionList node) {
        if(node != null) {
            collectSuggestions(a, i, node.left);
            Suggestion s = node.suggestion;
            if(node.down == null || node.end == s.string.length())
                a[i[0]++] = s;
            collectSuggestions(a, i, node.down);
            collectSuggestions(a, i, node.right);
        }
    }
    
    /**
     * Returns the height of the underlying ternary search tree and the number
     * and total length of the internal suggestion lists.
     * 
     * @return the height of the underlying ternary search tree and the number
     * and total length of the internal suggestion lists
     */
    public int[] treeData() {
        int[] info = {0,0,0};
        collectData(info, 0, root);
        return info;
    }
    
    private void collectData(int[] info, int depth, AutocompleteSuggestionList node) {
        if(node != null) {
            if(depth > info[0])
                info[0] = depth;
            info[1]++;
            info[2] += node.suggestions.length;
            collectData(info, depth + 1, node.left);
            collectData(info, depth + 1, node.down);
            collectData(info, depth + 1, node.right);
        }
    }
    
    /**
     * Returns a list of the highest scoring suggestions in this tree that start
     * with the specified prefix. If the tree contains no suggestion with the
     * specified prefix, an empty list is returned.
     *
     * @param prefix the prefix for which to return autocomplete suggestions
     * @return a list of the highest scoring suggestions in this tree that start
     * with the specified prefix
     * @throws IllegalArgumentException if the specified prefix is an empty
     * string
     */
    public AutocompleteSuggestionList getBestSuggestions(String prefix) {
        if(prefix.isEmpty())
            throw new IllegalArgumentException();
        int len = prefix.length();
        int i = 0;
        AutocompleteSuggestionList node = root;
        while(node != null) {
            if(prefix.charAt(i) < node.first)
                node = node.left;
            else if(prefix.charAt(i) > node.first)
                node = node.right;
            else {
                String ns = node.suggestion.string;
                for(i++; i < node.end && i < len; i++) {
                    if(prefix.charAt(i) != ns.charAt(i))
                        return EMPTY_LIST;
                }
                if(i < len)
                    node = node.down;
                else return node;
            }
        }
        return EMPTY_LIST;
    }
    
    /**
     * Increments the score of the specified suggestion by the specified amount.
     * 
     * @param suggestion the suggestion whose score is to be incremented
     * @param amount the amount to add to the score
     * @return the new score of the specified suggestion, or
     * {@code Integer.MIN_VALUE} if this tree contains no such suggestion
     * @throws IllegalArgumentException if the specified suggestion is an empty
     * string or the specified amount is less than 1
     * @throws ArithmeticException if the resulting score would be greater than
     * {@code Integer.MAX_VALUE}
     */
    public int incrementScore(String suggestion, int amount) {
        if(suggestion.isEmpty() || amount < 1)
            throw new IllegalArgumentException();
        modifyScore(suggestion, amount, 0, root);
        return (present != null) ? present.score : Integer.MIN_VALUE;
    }
    
    /**
     * Decrements the score of the specified suggestion by the specified amount.
     * 
     * @param suggestion the suggestion whose score is to be decremented
     * @param amount the amount to subtract from the score
     * @return the new score of the specified suggestion, or
     * {@code Integer.MAX_VALUE} if this tree contains no such suggestion
     * @throws IllegalArgumentException if the specified suggestion is an empty
     * string or the specified amount is less than 1
     * @throws ArithmeticException if the resulting score would be less than
     * {@code Integer.MIN_VALUE}
     */
    public int decrementScore(String suggestion, int amount) {
        if(suggestion.isEmpty() || amount < 1)
            throw new IllegalArgumentException();
        modifyScore(suggestion, -amount, 0, root);
        return (present != null) ? present.score : Integer.MAX_VALUE;
    }
    
    private void modifyScore(String suggestion, int amount, int i, AutocompleteSuggestionList node) {
        if(node == null) {
            present = null;
            listPos = -1;
        }else if(suggestion.charAt(i) < node.first)
            modifyScore(suggestion, amount, i, node.left);
        else if(suggestion.charAt(i) > node.first)
            modifyScore(suggestion, amount, i, node.right);
        else {
            int len = suggestion.length();
            String ns = node.suggestion.string;
            for(i++; i < node.end; i++) {
                if(i == len || suggestion.charAt(i) != ns.charAt(i)) {
                    present = null;
                    listPos = -1;
                    return;
                }
            }
            if(i < len)
                modifyScore(suggestion, amount, i, node.down);
            else if(ns.length() == len) {
                present = node.suggestion;
                int score = present.score;
                if((score > 0 && amount > Integer.MAX_VALUE - score)
                        || (score < 0 && amount < Integer.MIN_VALUE - score))
                    throw new ArithmeticException();
                present.score += amount;
                listPos = 0;
            }else {
                present = null;
                listPos = -1;
            }
            if(listPos != -1) {
                if(amount > 0)
                    moveForwardInList(node.suggestions);
                else
                    moveBackwardInList(node);
            }
        }
    }
    
    private void moveForwardInList(Suggestion[] list) {
        Suggestion s = present;
        int score = s.score;
        int len = list.length;
        int i = listPos;
        while(i < len && s != list[i])
            i++;
        if(i == len && score <= list[len - 1].score)
            listPos = -1;
        else {
            listPos = i;
            if(i == len)
                i = len - 1;
            while(i > 0 && score > list[i - 1].score) {
                list[i] = list[i - 1];
                i--;
            }
            list[i] = s;
        }
    }
    
    private void moveBackwardInList(AutocompleteSuggestionList node) {
        Suggestion s = present;
        int score = s.score;
        Suggestion[] list = node.suggestions;
        int len = list.length;
        int i = listPos;
        while(i < len && s != list[i])
            i++;
        if(i == len)
            listPos = -1;
        else {
            listPos = i;
            while(i < len - 1 && score < list[i + 1].score) {
                list[i] = list[i + 1];
                i++;
            }
            list[i] = s;
            if(i == k - 1)
                setLastListElement(list, node.down);
        }
    }
    
    private void setLastListElement(Suggestion[] list, AutocompleteSuggestionList node) {
        if(node == null)
            return;
        int last = list.length - 1;
        int pos = -1;
        Suggestion[] nList = node.suggestions;
        int nLen = nList.length;
        Suggestion s = null;
        outer:
        for(int i = 0; i < nLen; i++) {
            Suggestion t = nList[i];
            while(++pos < last) {
                if(t == list[pos])
                    continue outer;
            }
            s = t;
            break;
        }
        if(s != null && (list[last] == null || list[last].score < s.score))
            list[last] = s;
        setLastListElement(list, node.left);
        setLastListElement(list, node.right);
    }
    
    /**
     * Adds the specified suggestion with the specified score to this tree, or
     * sets the score to the specified value if the tree already contains the
     * suggestion.
     * 
     * @param suggestion the suggestion to be added or updated
     * @param score the score to be associated with the suggestion
     * @return {@code true} if this tree previously did not contain the
     * suggestion
     * @throws IllegalArgumentException if the specified suggestion is an empty
     * string
     */
    public boolean put(String suggestion, int score) {
        if(suggestion.isEmpty())
            throw new IllegalArgumentException();
        root = put(suggestion, score, 0, root);
        if(putCase == 0)
            size++;
        return (putCase == 0);
    }
    
    private AutocompleteSuggestionList put(String suggestion, int score, int i, AutocompleteSuggestionList node) {
        if(node == null) {
            present = new Suggestion(suggestion, score, random.nextInt());
            node = new AutocompleteSuggestionList(present, i);
            putCase = listPos = 0;
        }else if(suggestion.charAt(i) < node.first) {
            node.left = put(suggestion, score, i, node.left);
            if(node.left.priority < node.priority)
                node = rotateRight(node);
        }else if(suggestion.charAt(i) > node.first) {
            node.right = put(suggestion, score, i, node.right);
            if(node.right.priority < node.priority)
                node = rotateLeft(node);
        }else {
            int len = suggestion.length();
            String ns = node.suggestion.string;
            for(i++; i < node.end; i++) {
                if(i == len || suggestion.charAt(i) != ns.charAt(i)) {
                    split(node, i);
                    break;
                }
            }
            if(i < len)
                node.down = put(suggestion, score, i, node.down);
            else if(ns.length() == len) {
                present = node.suggestion;
                putCase = (score >= present.score) ? 1 : -1;
                present.score = score;
                listPos = 0;
            }else {
                present = new Suggestion(suggestion, score, random.nextInt());
                node.suggestion = present;
                putCase = listPos = 0;
            }
            if(listPos != -1) {
                switch(putCase) {
                    case 0: addToList(node); break;
                    case 1: moveForwardInList(node.suggestions); break;
                    case -1: moveBackwardInList(node);
                }
            }
            if(present.priority < node.priority)
                node.priority = present.priority;
        }
        return node;
    }
    
    private AutocompleteSuggestionList rotateRight(AutocompleteSuggestionList node) {
        AutocompleteSuggestionList left = node.left;
        node.left = left.right;
        left.right = node;
        return left;
    }
    
    private AutocompleteSuggestionList rotateLeft(AutocompleteSuggestionList node) {
        AutocompleteSuggestionList right = node.right;
        node.right = right.left;
        right.left = node;
        return right;
    }
    
    private void split(AutocompleteSuggestionList node, int i) {
        node.down = new AutocompleteSuggestionList(node, i);
        node.end = (short) i;
        Suggestion[] list = node.suggestions;
        if(list.length == k)
            node.suggestions = Arrays.copyOf(list, k);
    }
    
    private void addToList(AutocompleteSuggestionList node) {
        Suggestion s = present;
        int score = s.score;
        Suggestion[] list = node.suggestions;
        int i = list.length;
        if(i < k) {
            Suggestion[] a = new Suggestion[i + 1];
            while(i > 0 && score > list[i - 1].score) {
                a[i] = list[i - 1];
                i--;
            }
            a[i] = s;
            System.arraycopy(list, 0, a, 0, i);
            node.suggestions = a;
        }else if(score > list[i - 1].score) {
            i--;
            while(i > 0 && score > list[i - 1].score) {
                list[i] = list[i - 1];
                i--;
            }
            list[i] = s;
        }else
            listPos = -1;
    }

    /**
     * Removes the specified suggestion from this tree, if present.
     * 
     * @param suggestion the suggestion to be removed
     * @return {@code true} if this tree contained the suggestion
     * @throws IllegalArgumentException if the specified suggestion is an empty
     * string
     */
    public boolean remove(String suggestion) {
        if(suggestion.isEmpty())
            throw new IllegalArgumentException();
        root = remove(suggestion, 0, root);
        if(present != null)
            size--;
        return (present != null);
    }
    
    private AutocompleteSuggestionList remove(String suggestion, int i, AutocompleteSuggestionList node) {
        if(node == null)
            present = null;
        else if(suggestion.charAt(i) < node.first)
            node.left = remove(suggestion, i, node.left);
        else if(suggestion.charAt(i) > node.first)
            node.right = remove(suggestion, i, node.right);
        else {
            int len = suggestion.length();
            String ns = node.suggestion.string;
            for(i++; i < node.end; i++) {
                if(i == len || suggestion.charAt(i) != ns.charAt(i)) {
                    present = null;
                    return node;
                }
            }
            if(i < len)
                node.down = remove(suggestion, i, node.down);
            else if(ns.length() == len) {
                present = node.suggestion;
                listPos = 0;
                if(node.down == null)
                    return remove(node);
            }else
                present = null;
            if(present != null) {
                AutocompleteSuggestionList d = node.down;
                if(node.suggestion == present)
                    node.suggestion = d.suggestion;
                Suggestion s = node.suggestion;
                if(d != null && d.left == null && d.right == null
                        && node.end != s.string.length())
                    node = mergeWithChild(node);
                else {
                    if(listPos != -1)
                        removeFromList(node);
                    if(d == null || s.priority < d.priority)
                        node.priority = s.priority;
                    else
                        node.priority = d.priority;
                }
                if(node.priority > present.priority)
                    node = siftDown(node);
            }
        }
        return node;
    }
    
    private AutocompleteSuggestionList mergeWithChild(AutocompleteSuggestionList node) {
        AutocompleteSuggestionList d = node.down;
        d.left = node.left;
        d.right = node.right;
        d.first = node.first;
        return d;
    }
    
    private AutocompleteSuggestionList remove(AutocompleteSuggestionList node) {
        AutocompleteSuggestionList left = node.left;
        AutocompleteSuggestionList right = node.right;
        if(left != null && right != null) {
            if(left.priority < right.priority) {
                node = rotateRight(node);
                node.right = remove(node.right);
            }else {
                node = rotateLeft(node);
                node.left = remove(node.left);
            }
        }else
            node = (left != null) ? left : right;
        return node;
    }
    
    private AutocompleteSuggestionList siftDown(AutocompleteSuggestionList node) {
        AutocompleteSuggestionList left = node.left;
        AutocompleteSuggestionList right = node.right;
        AutocompleteSuggestionList cmp;
        if(left != null && right != null)
            cmp = (left.priority < right.priority) ? left : right;
        else
            cmp = (left != null) ? left : right;
        if(cmp != null && cmp.priority < node.priority) {
            if(cmp == left) {
                node = rotateRight(node);
                node.right = siftDown(node.right);
            }else {
                node = rotateLeft(node);
                node.left = siftDown(node.left);
            }
        }
        return node;
    }
    
    private void removeFromList(AutocompleteSuggestionList node) {
        Suggestion s = present;
        Suggestion[] list = node.suggestions;
        int len = list.length;
        int i = listPos;
        while(i < len && s != list[i])
            i++;
        if(i == len)
            listPos = -1;
        else {
            listPos = i;
            if(len < k) {
                Suggestion[] a = new Suggestion[len - 1];
                System.arraycopy(list, 0, a, 0, i);
                System.arraycopy(list, i + 1, a, i, len - i - 1);
                node.suggestions = a;
            }else {
                for(int j = i; j + 1 < len; j++)
                    list[j] = list[j + 1];
                list[len - 1] = null;
                setLastListElement(list, node.down);
                if(list[len - 1] == null)
                    node.suggestions = Arrays.copyOf(list, len - 1);
            }
        }
    }
}
