package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Microsoft question one of the toughest one where we have walls in the cells and walls are blockers
 * From Source we need to reach out to Cafeteria at minimum distance from the source point.    
 *  
 * @author mbbansiw
 *
 */
enum CellType{
	Cafeteria, Cubical;
}

class Cell{
	CellType cellType;
	int[] walls;
	boolean visited;
	public Cell(CellType cellType, int[] walls) {
		super();
		this.cellType = cellType;
		this.walls = walls;
	}
}

class CellQueueNode {
	Cell cell;
	int distance = Integer.MAX_VALUE;
	Point point;
	public CellQueueNode(Cell cell, Point point) {
		super();
		this.cell = cell;
		this.point = point;
	}
	
}

public class ReachCafteriaWithWallsAround {
	int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public static void main(String[] args) {
		int[] noWalls = {0,0,0,0};
		Cell[][] cells = 
		{
			{	new Cell(CellType.Cubical, noWalls), 
				new Cell(CellType.Cubical, noWalls), 
				new Cell(CellType.Cubical, noWalls), 
				new Cell(CellType.Cubical, noWalls)
			},
			{	new Cell(CellType.Cafeteria, new int[] {0, 0, 1, 0}), 
				new Cell(CellType.Cubical, new int[] {0, 0, 1, 0}), 
				new Cell(CellType.Cubical, new int[] {0, 0, 1, 0}), 
				new Cell(CellType.Cafeteria, noWalls)
			},
			{	new Cell(CellType.Cubical, new int[] {0, 0, 0, 0}), 
				new Cell(CellType.Cubical, new int[] {0, 0, 0, 1}), 
				new Cell(CellType.Cubical, new int[] {0, 0, 0, 1}), 
				new Cell(CellType.Cubical, noWalls)
			},
			{	new Cell(CellType.Cubical, noWalls), 
				new Cell(CellType.Cubical, noWalls), 
				new Cell(CellType.Cubical, noWalls), 
				new Cell(CellType.Cubical, noWalls)
			}
		};
		
		int[] source = {2, 1};
		System.out.println(new ReachCafteriaWithWallsAround().findMinimumDistance(cells, source));
	}
	
	
	public int findMinimumDistance(Cell[][] cells, int[] source) {
		Cell sourceCell = cells[source[0]][source[1]];
		int rows = cells.length;
		int columns = cells[0].length;
		Queue<CellQueueNode> queue = new LinkedList<>();
		CellQueueNode node = new CellQueueNode(sourceCell, new Point(source[0], source[1]));
		node.distance = 0;
		queue.add(node);
		
		int distance = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			CellQueueNode cellQueueNode = queue.poll();
			cellQueueNode.cell.visited = true;
			Cell currentCell = cellQueueNode.cell;
			if(currentCell.cellType == CellType.Cafeteria) {
				System.out.println(cellQueueNode.distance);
				distance = Math.min(distance, cellQueueNode.distance);
			}else {
				for(int i=0; i < directions.length; ++i) {
						if(!isWallPresent(currentCell, i)) {
							int x = cellQueueNode.point.x + directions[i][0];
							int y = cellQueueNode.point.y + directions[i][1];
							if(isValid(cells, x, y, rows, columns, i)) {
								CellQueueNode childNode = new CellQueueNode(cells[x][y], new Point(x, y));
								childNode.distance = cellQueueNode.distance + 1;
								queue.add(childNode);
							}	
						}
				}
			}
		}
		return distance;
	}
	
	private boolean isWallPresent(Cell cell, int direction) {
		return cell.walls[direction] == 1;
	}
	
	private boolean isValid(Cell[][] cells, int i, int j, int rows, int columns, int direction) {
		return i >=0 && j >=0 && i < rows && j < columns && !cells[i][j].visited;
	}
	
}
