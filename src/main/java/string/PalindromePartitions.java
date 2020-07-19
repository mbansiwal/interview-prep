package string;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitions {
    public static void main(String[] args){
        String str = "aab";
        System.out.println(new PalindromePartitions().partition(str));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition(result, new ArrayList<>(), s, 0);
        return result;
    }

    public void partition(List<List<String>> result, List<String> tempResults, String s, int start){
        if(start == s.length()){
            result.add(new ArrayList<>(tempResults));
        }

        for (int i=start; i < s.length(); ++i){
            if(isPalindrome(s, start, i)){
                tempResults.add(s.substring(start, i+1));
                partition(result, tempResults, s, i+1);
                tempResults.remove(tempResults.size() -1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
