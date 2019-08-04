package math;

public class MaximumBinomialCoefficientTermValue {
    private static int binomialCoefficient(int n, int k){
        int[][] dp = new int[n+1][k+1];
        for (int i=0; i<=n; ++i){
            for (int j =0; j <= Math.min(i, k); ++j){
                if(j==0 || j == n){
                    dp[i][j] =1;
                }else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[n][k];
    }

    private static int maxCoeficient(int n){
        if(n%2 == 0){
            return binomialCoefficient(n, n /2);
        }else{
            return binomialCoefficient(n, (n+1) /2);
        }
    }

    public static void main(String[] args){
        int n = 4;

        System.out.println(maxCoeficient(n));
    }
}
