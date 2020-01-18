package math;

/**
 * https://www.geeksforgeeks.org/sum-of-squares-of-first-n-natural-numbers/
 *
 * formula is n(n+1)(2n+1)/6
 *
 */
public class SumOfSquaresOfFirstNNaturalNumbers {
    public static int calculate(int n){
        int sum = n*(n+1)*(2*n+1)/6;
        return sum;
    }

    public static void main(String args[])
    {
        int n = 10;
        System.out.println(calculate(n));
    }
}
