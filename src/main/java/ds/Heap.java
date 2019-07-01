package ds;

class HeapNode
{
	private int val;
	private int row;

	public int getColumn()
	{
		return column;
	}

	public void setColumn(int column)
	{
		this.column = column;
	}

	private int column;

	public int getRow()
	{
		return row;
	}

	public void setRow(int row)
	{
		this.row = row;
	}

	HeapNode(int val, int row, int column)
	{
		this.val = val;
		this.row = row;
		this.column = column;
	}

	public int getVal()
	{
		return val;
	}

	public void setVal(int val)
	{
		this.val = val;
	}


}


public class Heap {
	private static int kthSmallest2DSortedArray(int[][] matrix, int k)
	{
		int rowCount = matrix.length;
		int columnCount = matrix[0].length;
		if(k<=0 && k>rowCount*columnCount)
		{
			return -1;
		}

		HeapNode[] heapNodeArr = new HeapNode[columnCount];

		for (int i = 0; i < columnCount; i++)
		{
			heapNodeArr[i] = new HeapNode(matrix[0][i], 0, i);
		}

		HeapNode kthNode = heapNodeArr[0];

		for (int i = 0; i < k; i++)
		{
			kthNode = heapNodeArr[0];

			int nextValue = (kthNode.getRow() < (rowCount-1)) ? matrix[kthNode.getRow()+1][kthNode.getColumn()] : Integer.MAX_VALUE;

			heapNodeArr[0] = new HeapNode(nextValue, kthNode.getRow()+1, kthNode.getColumn());

			minHeapify(heapNodeArr, 0, rowCount);

		}

		return kthNode.getVal();
	}

	private static void minHeapify(HeapNode[] heapNodeArr, int rootIndex, int heapSize)
	{
		int leftChildIndex = rootIndex*2 + 1;
		int rightChildIndex = rootIndex*2 +2;
		int smallestElementIndex = rootIndex;

		HeapNode rootNode = heapNodeArr[rootIndex];
		HeapNode smallestNode = rootNode;
		HeapNode leftChildNode = leftChildIndex < heapSize?heapNodeArr[leftChildIndex]:null ;
		HeapNode rightChildNode = rightChildIndex < heapSize?heapNodeArr[rightChildIndex]:null;
		
		if(leftChildNode !=null && leftChildNode.getVal() < smallestNode.getVal())
		{
			smallestNode = leftChildNode;
			smallestElementIndex = leftChildIndex;
		}
		
		if(rightChildNode !=null && rightChildNode.getVal() < smallestNode.getVal())
		{
			smallestNode = rightChildNode;
			smallestElementIndex = rightChildIndex;
		}
		
		if(smallestElementIndex!=rootIndex)
		{
			// Swap
			heapNodeArr[smallestElementIndex] = rootNode;
			heapNodeArr[rootIndex] = smallestNode;
			minHeapify(heapNodeArr, smallestElementIndex, heapSize);
		}
	}



    public static void main(String[] args) throws Exception
    {
		int mat[][] = { {10, 20, 30, 40}, {15, 25, 35, 45}, {25, 29, 37, 48},{32, 33, 39, 50}};
		System.out.println(kthSmallest2DSortedArray(mat,3));
    }

}
