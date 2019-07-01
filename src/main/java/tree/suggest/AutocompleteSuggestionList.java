package tree.suggest;

public final class AutocompleteSuggestionList
{
	public Suggestion[] suggestions;
    public Suggestion suggestion;
    public char first;
    public short end;
    public int priority;
    public AutocompleteSuggestionList left;
    public AutocompleteSuggestionList right;
    public AutocompleteSuggestionList down;
    
    public AutocompleteSuggestionList() {
        suggestions = new Suggestion[0];
    }
    
    public AutocompleteSuggestionList(Suggestion s, int start) {
        suggestions = new Suggestion[] {s};
        suggestion = s;
        first = s.string.charAt(start);
        end = (short) s.string.length();
        priority = s.priority;
        left = right = down = null;
    }
    
    public AutocompleteSuggestionList(AutocompleteSuggestionList node, int start) {
        suggestions = node.suggestions;
        suggestion = node.suggestion;
        first = suggestion.string.charAt(start);
        end = node.end;
        priority = node.priority;
        left = right = null;
        down = node.down;
    }
    
    /**
     * Returns the suggestion at the specified position in this list.
     *
     * @param index position of the suggestion to return
     * @return the suggestion at the specified position in this list
     * @throws ArrayIndexOutOfBoundsException if the specified index is
     * negative or not less than the length of this list
     */
    public Suggestion get(int index) {
        return suggestions[index];
    }

    /**
     * Returns the number of suggestions in this list.
     * 
     * @return the number of suggestions in this list
     */
    public int length() {
        return suggestions.length;
    }
}
