package arr;

public class FindTheOnlyRepetitiveElement {
    public int findDuplicate3(int[] nums)
    {
        int xor = 0;
        for (int i=0; i < (nums.length-1); ++i){
            xor = xor ^ nums[i] ^ (i+1);
        }
        xor = xor ^ nums[nums.length -1];
        return xor;
    }

    public static void main(String[] args){
        int a[] = {1, 3, 2, 3, 4};
        System.out.println(new FindTheOnlyRepetitiveElement().findDuplicate3(a));

        int a2[] = {1, 5, 1, 2, 3, 4};
        System.out.println(new FindTheOnlyRepetitiveElement().findDuplicate3(a2));
    }
}
