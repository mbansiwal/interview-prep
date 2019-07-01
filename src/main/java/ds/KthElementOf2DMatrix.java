package ds;

class MatrixHeapNode
{
	int row;
	int column;
	int data;
	public MatrixHeapNode(int row, int column, int data) {
		super();
		this.row = row;
		this.column = column;
		this.data = data;
	}
}

class MatrixHeap
{
	int size;
	MatrixHeapNode[] heapNodes;
	public MatrixHeap(MatrixHeapNode[] heapNodes) 
	{
		size = heapNodes.length;
		this.heapNodes = heapNodes;
	}
	
	public void minimizeHeap()
	{
		int times = (size-1)/2;
		while(times>=0)
		{
			minimizeHeap(times);
			times--;
		}
	}
	public void minimizeHeap(int rootIndex)
	{
		int leftChildIndex = 2*rootIndex + 1;
		int rightChildIndex = 2*rootIndex + 2;
		MatrixHeapNode leftChild = leftChildIndex<(size-1)?heapNodes[leftChildIndex]:null;
		MatrixHeapNode rightChild = rightChildIndex<(size-1)?heapNodes[rightChildIndex]:null;
		MatrixHeapNode rootNode = heapNodes[rootIndex];
		MatrixHeapNode smallestNode = rootNode;
		int smallestIndex = rootIndex;
		if(leftChild!=null && smallestNode.data > leftChild.data)
		{
			smallestNode = leftChild;
			smallestIndex = leftChildIndex;
		}
		if(rightChild!=null && smallestNode.data > rightChild.data)
		{
			smallestNode = rightChild;
			smallestIndex = rightChildIndex;
		}
		
		if(rootNode != smallestNode)
		{
			heapNodes[rootIndex] = smallestNode;
			heapNodes[smallestIndex] = rootNode;
			minimizeHeap(smallestIndex);
		}
	}
	
	public MatrixHeapNode extractMinimum()
	{
		MatrixHeapNode minimumNode = heapNodes[0];
		heapNodes[0] = heapNodes[size-1];
		size--;
		minimizeHeap(0);
		return minimumNode;
	}
}


public class KthElementOf2DMatrix 
{
	private static int findKthSmallestElement(int data[][], MatrixHeap matrixHeap, int k, int rowCount)
	{
		MatrixHeapNode[] matrixHeapNodes = matrixHeap.heapNodes;
		MatrixHeapNode smallestNode = null;
		
		int maxRows = rowCount-1;
		for (int i = 0; i < k; i++) 
		{
			smallestNode = matrixHeapNodes[0];
			
			int nextVal = smallestNode.row < maxRows?data[smallestNode.row+1][smallestNode.column]:Integer.MAX_VALUE;
			matrixHeapNodes[0] = new MatrixHeapNode(smallestNode.row+1, smallestNode.column, nextVal);
			matrixHeap.minimizeHeap(0);
		}
		return smallestNode.data;
	}
	public static void main(String[] args) 
	{
		int data[][] = { {10, 20, 30, 40}, {15, 25, 35, 45}, {26, 29, 37, 48},{32, 33, 39, 50}};
		int rowSize = data.length;
		int columSize = data[0].length;
		MatrixHeapNode[] matrixHeapNodes = new MatrixHeapNode[columSize];
		for (int col = 0; col < columSize; col++) 
		{
			matrixHeapNodes[col] = new MatrixHeapNode(0,col,data[0][col]);
		}
		MatrixHeap matrixHeap = new MatrixHeap(matrixHeapNodes);
		System.out.println(findKthSmallestElement(data, matrixHeap, 6, rowSize));
	}
}
