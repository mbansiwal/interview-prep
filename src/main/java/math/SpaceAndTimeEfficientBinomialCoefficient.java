package math;

/**
 * https://www.geeksforgeeks.org/space-and-time-efficient-binomial-coefficient/
 *
 * Write a function that takes two parameters n and k and returns the value of Binomial Coefficient C(n, k). For example, your function should return 6 for n = 4 and k = 2, and it should return 10 for n = 5 and k = 2.
 *
 * C(n, k) = n! / (n-k)! * k!
 *         = [n * (n-1) *....* 1]  / [ ( (n-k) * (n-k-1) * .... * 1) *
 *                                     ( k * (k-1) * .... * 1 ) ]
 * After simplifying, we get
 * C(n, k) = [n * (n-1) * .... * (n-k+1)] / [k * (k-1) * .... * 1]
 *
 * Also, C(n, k) = C(n, n-k)  // we can change r to n-r if r > n-r
 *
 */
public class SpaceAndTimeEfficientBinomialCoefficient {
    public static int calculate(int n, int k){
        k = Math.min(k, n-k);

        int value = 1;
        for(int i = 0; i < k; ++i){
            value *= (n-i);
            value /= (i+1);
        }
        return value;
    }

    public static void main(String[] args)
    {
        int n = 8;
        int k = 2;
        System.out.println("Value of C("+ n + ", " + k+ ") "
                + "is" + " "+ calculate(n, k));
    }
}
