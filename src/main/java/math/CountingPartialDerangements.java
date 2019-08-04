package math;

public class CountingPartialDerangements {
    private static int binomial(int n, int k){
        if (k ==0 || k==n){
            return 1;
        }

        return binomial(n-1, k-1) + binomial(n-1, k);
    }

    public static int derangements(int n, int k){
        int value = 0;
        if(n == 0 && k ==0){
            return 1;
        }
        if(n == 1 && k ==0){
            return 0;
        }
        if(k == 0){
            value = (n-1)*(derangements(n-1, 0) + derangements(n-2, 0));
        } else{
            value = binomial(n, k) * derangements(n-k, 0) ;
        }
        return value;
    }

    static void binomialCoeff(int C[][], int n, int k)
    {

        // Calculate value of Binomial Coefficient
        // in bottom up manner
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++)
            {

                // Base Cases
                if (j == 0 || j == i)
                    C[i][j] = 1;

                    // Calculate value using previously
                    // stored values
                else
                    C[i][j] = C[i - 1][j - 1] +
                            C[i - 1][j];
            }
        }
    }

    static int RencontresNumber(int n, int m)
    {
        int C[][] = new int[n+1][m+1];
        binomialCoeff(C, n, m);
        return RencontresNumber(C, n, m);
    }
    // Return Recontres number D(n, m)
    static int RencontresNumber(int C[][], int n, int m)
    {
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j <= i) {

                    // base case
                    if (i == 0 && j == 0)
                    {
                        dp[i][j] = 1;
                    }
                        // base case
                    else if (i == 1 && j == 0)
                    {
                        dp[i][j] = 0;
                    }
                    else if (j == 0) {
                        dp[i][j] = (i - 1) * (dp[i - 1][0]
                                + dp[i - 2][0]);
                    }
                    else {
                        dp[i][j] = C[i][j] * dp[i - j][0];
                    }
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args){
        System.out.println(derangements(7,2));
        System.out.println(RencontresNumber(7, 2));
    }
}
