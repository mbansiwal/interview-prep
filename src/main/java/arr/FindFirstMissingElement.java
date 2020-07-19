package arr;

/**
 * https://www.geeksforgeeks.org/find-the-first-missing-number/?ref=rp
 *
 * Time Complexity: O(Logn)
 */
public class FindFirstMissingElement {
    public static void main(String[] args)
    {
        FindFirstMissingElement small = new FindFirstMissingElement();
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 10};
        int n = arr.length;
        System.out.println("First Missing element is : "
                + small.findFirstMissing(arr, 0, n - 1));
        System.out.println("First Missing element is : "
                + small.findFirstMissing2(arr));

        int arr2[] = {0, 1, 2, 3, 4, 5};
        n = arr2.length;
        System.out.println("First Missing element is : "
                + small.findFirstMissing(arr2, 0, n - 1));
        System.out.println("First Missing element is : "
                + small.findFirstMissing2(arr2));

        int arr3[] = {1, 2, 3, 4, 5};
        n = arr3.length;
        System.out.println("First Missing element is : "
                + small.findFirstMissing(arr3, 0, n - 1));
        System.out.println("First Missing element is : "
                + small.findFirstMissing2(arr3));
    }

    private int findFirstMissing(int[] arr, int low, int high) {
        if(low > high){
            return high+1;
        }

        if(low != arr[low]){
            return low;
        }

        int mid = (low+high)/2;

        if(mid == arr[mid]) {
            return findFirstMissing(arr, mid+1, high);
        } else{
            return findFirstMissing(arr, low, mid);
        }
    }

    private int findFirstMissing2(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            if(low != arr[low]){
                return low;
            }
            int mid = (low + high)/2;
            if(arr[mid] == mid){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return high+1;
    }
}
