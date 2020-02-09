package arr;

public class KadaneMaxCircularSum {

    public static void main (String[] args)
    {
        int a[] =  {11, 10, -20, 5, -3, -5, 8, -13, 10};
        System.out.println("Maximum circular sum is " +
                maxCircularSum(a));
    }

    private static int maxCircularSum(int[] a) {
        int maxSum = kadane(a);

        int arrSum = 0;
        for(int i=0; i < a.length; ++i){
            arrSum += a[i];
            a[i] = -a[i];
        }

        int maxWrapSum = arrSum + kadane(a);

        return Math.max(maxWrapSum, maxSum);
    }

    private static int kadane(int[] arr){
        int currentSum = 0;
        int maxSum = 0;
        int startIndex = 0;
        int endIndex = 0;
        int maxLength = 0;
        for (int i =0; i < arr.length; ++i){
            currentSum += arr[i];

            if(currentSum < arr[i]){
                currentSum = arr[i];
                startIndex = i;
            }

            if(maxSum < currentSum){
                maxSum = currentSum;
                endIndex = i;
                maxLength = Math.max(maxLength, endIndex - startIndex +1);
            }
        }

        return maxSum;
    }
}

