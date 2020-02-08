package arr;

import java.util.Arrays;

public class CountInversionsInAnArray {
    public int countInversions(int arr[]){
        int inversions = 0;
        convert(arr);

        int n = arr.length;

        int[] smaller = new int[n];
        int[] greater = new int[n];
        int[] tree = new int[n+1];
        for (int i=n-1; i>=0; --i){
            smaller[i] += getSum(tree, arr[i] - 1);
            updateBinaryIndexTree(tree, arr[i], 1);
        }

        Arrays.fill(tree, 0);
        for(int i=0; i<n; ++i){
            greater[i] = i - getSum(tree, arr[i]);
            updateBinaryIndexTree(tree, arr[i], 1);
        }

        for (int i=0; i<n; ++i){
            inversions+=smaller[i] * greater[i];
        }
        return inversions;
    }

    private int getSum(int arr[], int index){
        int sum = 0;
        while(index > 0){
            sum += arr[index];
            index -= index & (-index);
        }
        return sum;
    }

    private void updateBinaryIndexTree(int[] tree, int index, int value){
        while(index <= tree.length){
            tree[index] += value;
            index += index & (-index);
        }
    }

    private void convert(int[] arr){
        int temp[] = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);

        for (int i=0; i < arr.length; ++i){
            arr[i] = Arrays.binarySearch(temp, arr[i]) + 1;
        }
    }

    private static void printParents(){
        int[] arr = {4,3,2,1};
        for(int i=0; i<arr.length; ++i){
            System.out.println(arr[i]- (arr[i]&(-arr[i])));
        }
    }

    private static void printChilds(){
        System.out.println("Childs");
        int[] arr = {4,3,2,1};
        for(int i=0; i<arr.length; ++i){
            System.out.println(arr[i] + (arr[i]&(-arr[i])));
        }
    }

    public static void main(String[] args){
        printParents();

        printChilds();
        int arr[] = {8, 4, 2, 1};
        System.out.println(new CountInversionsInAnArray().countInversions(arr));
    }
}
