package tree;

/**
 * https://www.geeksforgeeks.org/number-of-unique-bst-with-a-given-key-dynamic-programming/
 *
 * Given N, Find the total number of unique BSTs that can be made using values from 1 to N.
 *
 * Input: n = 3
 * Output: 5
 * For n = 3, preorder traversal of Unique BSTs are:
 * 1. 1 2 3
 * 2. 1 3 2
 * 3. 2 1 3
 * 4. 3 1 2
 * 5. 3 2 1
 *
 * Input: 4
 * Output: 14
 */
public class NumberOfUniqueBST {
    public static void main (String[] args)
    {
        System.out.println("Number of structurally " +
                "Unique BST with "+ 3 +
                " keys are : " +
                numberOfBST(3) +", using O(n) solution "+catalanNumber(3));

        System.out.println("Number of structurally " +
                "Unique BST with "+ 4 +
                " keys are : " +
                numberOfBST(4)+", using O(n) solution "+catalanNumber(4));

        System.out.println("Number of structurally " +
                "Unique BST with "+ 5 +
                " keys are : " +
                numberOfBST(5)+", using O(n) solution "+catalanNumber(5));
    }

    /**
     * O(n^2) solution
     * @param n
     * @return
     */
    private static int numberOfBST(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i <= n; ++i){
            for (int j=1; j <=i; ++j){
                dp[i] = dp[i] + dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }

    /**
     *
     */
    private static int catalanNumber(int n){
        return binomialCoef(2*n, n)/(n+1);
    }

    private static int binomialCoef(int n, int k){
        int coef = 1;
        for(int i=0; i < k; ++i){
            coef *= (n-i);
            coef /= (i+1);
        }
        return coef;
    }
}
