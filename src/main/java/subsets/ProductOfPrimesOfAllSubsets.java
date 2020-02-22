package subsets;

import java.util.Arrays;

public class ProductOfPrimesOfAllSubsets {
    public static void main(String[] args)
    {
        int a[] = { 3, 7 };
        int n = a.length;
        System.out.println(sumOfSubset(a, n));
    }

    // Sieve method to check prime or not
    static void sieve(boolean []prime)
    {
        int n = prime.length -1 ;

        // Initially mark all primes
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        // Iterate and mark all the
        // non primes as false
        for (int i = 2; i <= n; i++)
        {
            if (prime[i])
            {
                // Multiples of prime marked as false
                for (int j = i * i; j <= n; j += i)
                {
                    prime[j] = false;
                }
            }
        }
    }

    static int sumOfSubset(int arr[], int n)
    {
        int product = 1;
        int maxNumber = Arrays.stream(arr).max().getAsInt();
        boolean[] primes = new boolean[maxNumber+1];
        int totalNumberOfAppearance = (int)Math.pow(2, n-1);
        sieve(primes);
        for (int element: arr)
        {
         if(primes[element]){
             product *= Math.pow(element, totalNumberOfAppearance);
         }
        }

        return product;
    }
}
