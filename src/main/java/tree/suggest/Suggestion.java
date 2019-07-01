package tree.suggest;

public final class Suggestion 
{
    public String string;
    public int score;
    public int priority;
     
    public Suggestion(String string, int score, int priority) {
        this.string = string;
        this.score = score;
        this.priority = priority;
    }
    
    /**
     * Returns the suggestion string.
     * 
     * @return the suggestion string
     */
    public String get() {
        return string;
    }
    
    /**
     * Returns the score of this suggestion.
     * 
     * @return the score of this suggestion
     */
    public int getScore() {
        return score;
    }
}