package arr;

public class LongestMountain {
    public int longestMountain(int[] arr) {
        int base =0;

        int n = arr.length;
        int ans = 0;
        while(base < n){
            int end = base;
            if(end + 1 < n && arr[end] < arr[end+1]){
                while(end + 1 < n && arr[end] < arr[end+1]){
                    end++;
                }

                if(end + 1 < n && arr[end] > arr[end+1]){
                    while(end + 1 < n && arr[end] > arr[end+1]){
                        end++;
                    }
                    ans = Math.max(ans, end - base + 1);
                }
            }
            base = Math.max(end, base+1);
        }

        return ans;
    }


    public static void main(String[] args){
        int arr[] = {2,1,4,7,3,2,5};
        System.out.println(new LongestMountain().longestMountain(arr));

        //it is same bitonic max sum
        System.out.println(BitonicSubArray.findMax(arr));
    }
}
