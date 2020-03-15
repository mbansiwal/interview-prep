package tree;

public class SegmentTree {
    int[] segmentTree;
    int[] input;
    public SegmentTree(int[] input){
        this.input = input;
        this.segmentTree = createTree(input);
    }
    private int[] createTree(int[] data){
        this.segmentTree = new int[sizeOfSegmentTree(data.length)];
        constructTree(0, 0, input.length-1);
        return segmentTree;
    }

    private int sizeOfSegmentTree(int length){
        int height = getHeight(length);
        return (int)(Math.pow(2, height+1)-1);
    }

    private int getHeight(int length){
        return (int)Math.ceil(Math.log(length)/Math.log(2));
    }

    private void constructTree(int pos, int low, int high){
        if(low == high){
            segmentTree[pos] = input[low];
            return;
        }

        int mid = (low+high)/2;

        constructTree(2*pos + 1, low, mid);
        constructTree(2*pos + 2, mid+1, high);
        segmentTree[pos] = Math.min(segmentTree[2*pos+1], segmentTree[2*pos+2]);
    }

    public int rangeQuery(int queryLow, int queryHigh){
        return rangeQuery(queryLow, queryHigh, 0, input.length-1, 0);
    }

    private int rangeQuery(int queryLow, int queryHigh, int low, int high, int pos){
        if(queryLow <= low && queryHigh >= high){
            return segmentTree[pos];
        }

        if(queryLow > high || queryHigh < low){
            return Integer.MAX_VALUE;
        }

        if(low >= high){
            return Integer.MAX_VALUE;
        }
        int mid = (low + high)/2;
        return Math.min(rangeQuery(queryLow, queryHigh, low, mid, 2*pos+1),
                rangeQuery(queryLow, queryHigh, mid+1, high, 2*pos+2));
    }

    public void updateValue(int newValue, int index){
        if(index < 0 || index > (input.length-1)){
            throw new IllegalArgumentException("Index out of Range");
        }

        input[index] = newValue;
        updateTree(newValue, index, 0, 0, input.length-1);
    }

    private void updateTree( int newValue, int index, int pos, int low, int high){
        if(index < low || index > high){
            return;
        }

        if(low == high){
            segmentTree[pos] = newValue;
            return;
        }

        int mid = (low+high)/2;
        if(index >= low && index <= mid) {
            updateTree(newValue, index, 2 * pos + 1, low, mid);
        } else {
            updateTree(newValue, index, 2 * pos + 2, mid + 1, high);
        }
        segmentTree[pos] = Math.min(segmentTree[2*pos+1], segmentTree[2*pos+2]);
    }

    public static void main(String args[]) {
        int input[] = {1, 3, 5, 13, 7, 9, 11};
        SegmentTree st = new SegmentTree(input);
        System.out.println(st.rangeQuery(2, 5));
        st.updateValue(4, 3);
        System.out.println(st.rangeQuery(2, 5));

    }
}
