package math;

/**
 * https://www.geeksforgeeks.org/sum-of-all-elements-up-to-nth-row-in-a-pascals-triangle/
 *
 *                                                                sum of elements in ith row
 * 0th row                             1                                1    -> 20
 * 1st row                           1   1                              2    -> 21
 * 2nd row                         1   2   1                            4    -> 22
 * 3rd row                       1   3   3   1                          8    -> 23
 * 4th row                     1   4   6   4   1                        16   -> 24
 * 5th row                   1   5   10  10  5   1                      32   -> 25
 * 6th row                 1   6   15  20  15  6   1                    64   -> 26
 * 7th row               1   7   21  35  35  21  7   1                  128  -> 27
 * 8th row             1  8   28   56  70   56  28  8  1                256  -> 28
 * 9th row           1   9  36  84  126  126  84  36  9  1              512  -> 29
 * 10th row        1  10  45  120 210  256  210 120 45 10  1            1024 -> 210
 *
 * Efficient solution:
 *
 * 2n can be expressed as
 * 2n = ( 20 + 21 + 22 + 23 +. . . + 2(n-1) ) + 1
 *
 * For Example:
 * 26 = ( 20 + 21 + 22 + 23 + 24 + 25 ) + 1
 * 64 = ( 1 + 2 + 4 + 8 +16 + 32 ) + 1
 * 64 = 63 + 1
 *
 * So, calculate 2n instead of calculating every power of 2 up to (n – 1) and from above example the sum of the power of 2 up to (n – 1) will be (2n – 1).
 *
 */
public class SumOfAllElementsUpToNthRowPascalsTriangle {
    public static int calculate(int n){
        int powerN = 1 << n;
        return powerN - 1;
    }

    public static void main(String[] args){
        System.out.println(calculate(5));
        System.out.println(calculate(6));
    }
}
