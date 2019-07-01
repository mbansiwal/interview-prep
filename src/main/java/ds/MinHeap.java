package ds;

class MinHeapNode
{
	private int val;

	MinHeapNode(int val)
	{
		this.val = val;
	}

	public int getVal()
	{
		return val;
	}

	public void setVal(int val)
	{
		this.val = val;
	}
	
	@Override
	public String toString() {
		return ""+val;
	}
}

public class MinHeap {
	int heapSize = 0;
	MinHeapNode[] heapNodes;
	public MinHeap(int[] heapArr) {
		heapSize = heapArr.length;
		heapNodes = new MinHeapNode[heapArr.length];
		for (int i = 0; i < heapSize; i++) 
		{
			heapNodes[i] = new MinHeapNode(heapArr[i]);
		}
	}
	
	private void minify(MinHeapNode[] heapNodes, int rootIndex)
	{
		int leftChildIndex = 2*rootIndex + 1;
		int rightChildIndex = 2*rootIndex + 2;
		int smallestNodeIndex = rootIndex;
		MinHeapNode rootNode = heapNodes[rootIndex];
		MinHeapNode smallestNode = rootNode;
		MinHeapNode leftChildNode = leftChildIndex< heapSize?heapNodes[leftChildIndex]:null;
		MinHeapNode rightChildNode = rightChildIndex< heapSize?heapNodes[rightChildIndex]:null;
		
		if(leftChildNode != null && leftChildNode.getVal() < smallestNode.getVal())
		{
			smallestNode = leftChildNode;
			smallestNodeIndex = leftChildIndex;
		}
		if(rightChildNode != null && rightChildNode.getVal() < smallestNode.getVal())
		{
			smallestNode = rightChildNode;
			smallestNodeIndex = rightChildIndex;
		}
		if(smallestNode != rootNode)
		{
			heapNodes[smallestNodeIndex] = rootNode;
			heapNodes[rootIndex] = smallestNode;
			minify(heapNodes, smallestNodeIndex);
		}
		
	}
	
	public void minHeap()
	{
		int i = (heapSize - 1 )/2;
		while(i>=0)
		{
			minify(heapNodes, i);
			i--;
		}
	}
	
	int extractMin()
	{
	    if (heapSize == 0)
	    {
	    	return Integer.MAX_VALUE;
	    }
	 
	    // Store the minimum vakue.
	    MinHeapNode root = heapNodes[0];
	 
	    // If there are more than 1 items, move the last item to root
	    // and call heapify.
	    if (heapSize > 1)
	    {
	    	heapNodes[0] = heapNodes[heapSize-1];
	        minify(heapNodes, 0);
	    }
	    heapSize--;
	 
	    return root.getVal();
	}
	
	public static void main(String[] args) 
	{
		int[] heapArr = {2,6,4,7,3,9,1,12,76,100,37};
		MinHeap minHeap = new MinHeap(heapArr);
		minHeap.minHeap();
		
		
		for (int i = 0; i < heapArr.length; i++) {
			System.out.println(minHeap.extractMin());
		}
		
	}
}
