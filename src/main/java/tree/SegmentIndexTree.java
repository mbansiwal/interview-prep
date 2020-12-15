package tree;

public class SegmentIndexTree {
    private int[] tree;

    public SegmentIndexTree(int size){
        this.tree = new int[size+1];
    }

    public SegmentIndexTree(int[] input){
        int n = input.length;
        this.tree = new int[n+1];
        for(int i=1; i <= n; ++i){
            update(i, input[i-1]);
        }
    }
    public int getSum(int index) {
        if(index >= tree.length){
            throw new IllegalArgumentException("Index out of bound");
        }
        int sum = 0;
        while(index > 0){
            sum += tree[index];
            index = getParentIndex(index);
        }
        return sum;
    }

    public void update(int index, int value){
        while(index < tree.length){
            tree[index] += value;
            index = getChildIndex(index);
        }
    }

    private int getParentIndex(int index){
        return index - (index & (-index));
    }

    private int getChildIndex(int index){ 
        return index + (index&(-index));
    }

    public static void main(String[] args){
        int[] input = {1,2,3,4,5};
        SegmentIndexTree sit = new SegmentIndexTree(input);
        System.out.println(sit.getSum(1));
        System.out.println(sit.getSum(2));
        System.out.println(sit.getSum(3));
        System.out.println(sit.getSum(4));
        System.out.println(sit.getSum(5));
    }
}
