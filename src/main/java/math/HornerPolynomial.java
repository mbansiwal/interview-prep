package math;

/**
 *
 * https://www.geeksforgeeks.org/horners-method-polynomial-evaluation/
 * Given a polynomial of the form cnxn + cn-1xn-1 + cn-2xn-2 + … + c1x + c0 and a value of x, find the value of polynomial for a given value of x. Here cn, cn-1, .. are integers (may be negative) and n is a positive integer.
 *
 * Input is in the form of an array say poly[] where poly[0] represents coefficient for xn and poly[1] represents coefficient for xn-1 and so on.
 *
 * Examples:
 *
 * // Evaluate value of 2x3 - 6x2 + 2x - 1 for x = 3
 * Input: poly[] = {2, -6, 2, -1}, x = 3
 * Output: 5
 *
 * // Evaluate value of 2x3 + 3x + 1 for x = 2
 * Input: poly[] = {2, 0, 3, 1}, x = 2
 * Output: 23
 *
 */
public class HornerPolynomial {

    /**
     * 2a3 - 6a2 + 2a - 1
     *
     * a2(2a-6) + 2a -1
     * a(a(2a-6) + 2) - 1
     *
     * @param polynomial
     * @param x
     * @return
     */
    public static int calculate(int[] polynomial, int x){
        int result = polynomial[0];
        for (int i=1; i < polynomial.length; ++i){
            result = result * x + polynomial[i];
        }
        return result;
    }

    public static void main(String[] args){
        int[] polynomial = {2, -6, 2, -1};
        System.out.println(calculate(polynomial, 3));
    }
}
