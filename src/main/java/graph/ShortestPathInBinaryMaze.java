package graph;

import java.util.LinkedList;
import java.util.Queue;

class Point
{
	int x;
	int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

class QueueNode
{
	Point point;
	int distance;
	public QueueNode(Point point, int distance) {
		super();
		this.point = point;
		this.distance = distance;
	}
}

public class ShortestPathInBinaryMaze 
{
	int ROW = 9;
	int COL = 10;
	int[] rowNum = {-1,0,0,1};
	int[] colNum = {0,-1,1,0};
	
	
	
	boolean isValid(int row, int col)
	{
		return row < ROW && row>=0 && col < COL && col >= 0;
	}
	
	public int BFS(int[][] mat, Point source, Point destination)
	{
		if(mat[source.x][source.y] != 1 || mat[destination.x][destination.y] != 1)
		{
			return Integer.MAX_VALUE;
		}
		boolean visited[][] = new boolean[ROW][COL];
		
		visited[source.x][source.y] = true;
		
		Queue<QueueNode> queue = new LinkedList<>();
		queue.add(new QueueNode(source, 0));
		
		while(!queue.isEmpty())
		{
			QueueNode current = queue.poll();
			
			if(isEqual(current.point, destination))
			{
				return current.distance;
			}
			
			for (int i = 0; i < rowNum.length; i++) 
			{
				int row = current.point.x + rowNum[i];
				int col = current.point.y + colNum[i];
				
				if(isValid(row, col) && !visited[row][col] && mat[row][col] == 1)
				{
					visited[row][col] = true;
					queue.add(new QueueNode(new Point(row, col), current.distance+1));
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	
	
	private boolean isEqual(Point source, Point destination)
	{
		return source.x == destination.x && source.y == destination.y;
	}
	
	public static void main(String[] args) 
	{
		int mat[][]  = 
				{
					{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
	                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
	                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
	                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
	                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
	                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
	                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
	                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
	                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
	            };
		System.out.println(new ShortestPathInBinaryMaze().BFS(mat, new Point(0, 0), new Point(3, 4)));
	}
}
