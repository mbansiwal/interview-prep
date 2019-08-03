package math;

/**
 * https://www.geeksforgeeks.org/sum-binomial-coefficients/
 */
public class SumOfBinomialCoefficients {
    public int sumOfCoefficients(int n){
        /**
         *  (1 + x)n = nC0 + nC1 x + nC2 x2 +... nCn xn
         *  put x == 1
         *  2n = nC0 + nC1 + nC2 + ……. + nCn-1 + nCn
         */
        //2 to the power n
        return 1 << n;
    }

    public static void main(String[] args){
        System.out.println(new SumOfBinomialCoefficients().sumOfCoefficients(4));
    }
}
