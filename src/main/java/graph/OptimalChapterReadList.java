package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/optimal-read-list-given-number-days/
 * 
 * A person is determined to finish the book in ‘k’ days but he never wants to stop a chapter in between. Find the optimal assignment of chapters, such that the person doesn’t read too many extra/less pages overall.

Example 1:
Input:  Number of Days to Finish book = 2
        Number of pages in chapters = {10, 5, 5}
Output: Day 1:  Chapter 1
        Day 2:  Chapters 2 and 3

Example 2:
Input:  Number of Days to Finish book = 3
        Number of pages in chapters = {8, 5, 6, 12}
Output: Day 1:  Chapter 1
        Day 2:  Chapters 2 and 3 
        Day 2:  Chapter 4


 * @author mbansiwal
 *
 */
public class OptimalChapterReadList
{
	int DAYS = 3;
	int CHAPTERS = 4;
	int NOLINK = -1;
	List<Integer> optimalPath;
	int[][] DAG = new int[CHAPTERS+1][CHAPTERS+1];
	int min = Integer.MAX_VALUE;
	
	public void minimizeAssignment(int[] pages)
	{
		int[] edges = new int[CHAPTERS + 1];
		int[] paths = new int[DAYS+1];
		int totalSum = 0;
		for (int i = 0; i < paths.length; i++)
		{
			totalSum += pages[i];
			edges[i+1] = totalSum;
		}
		
		int averagePagesPerDay = Math.round(totalSum/DAYS);
		for (int i = 0; i <= CHAPTERS; i++)
		{
			for (int j = 0; j <= CHAPTERS; j++)
			{
				if(j <= i)
				{
					DAG[i][j] = NOLINK;
				}
				else
				{
					DAG[i][j] = Math.abs(averagePagesPerDay - (edges[j]-edges[i]));
				}
			}
		}
		assignChapters(0, paths, 0, 0, DAYS);
		for (int i = 0; i < DAYS; i++)
		{
			int chapter = optimalPath.get(i);
			System.out.print("Day: "+(i+1)+", Chapter: "+chapter);
			chapter++;
			while((i < DAYS-1 && chapter < optimalPath.get(i+1)) || (i == DAYS-1 && chapter <= CHAPTERS))
			{
				System.out.print(","+chapter);
				chapter++;
			}
			
			System.out.println();
		}
		displayResult();
	}
	
	private void assignChapters(int sourceChapter, int[] paths, int pathLength, int sumOfPages, int noOfDaysToSpend)
	{
		if(noOfDaysToSpend < 0)
		{
			return;
		}
		
		paths[pathLength] = sourceChapter;
		pathLength++;
		
		if(noOfDaysToSpend == 0 && CHAPTERS == sourceChapter)
		{
			if(sumOfPages < min)
			{
				updateResult(paths, pathLength);
				min = sumOfPages;
			}
		}
		
		for (int destination = sourceChapter+1; destination <= CHAPTERS; destination++)
		{
			sumOfPages += DAG[sourceChapter][destination];
			assignChapters(destination, paths, pathLength, sumOfPages, noOfDaysToSpend - 1);
			sumOfPages -= DAG[sourceChapter][destination];
		}
	}
	
	private void updateResult(int[] paths, int pathLength)
	{
		optimalPath = new ArrayList<>();
		for (int i = 0; i < pathLength; i++)
		{
			optimalPath.add(paths[i] + 1);
		}
	}
	
	private void displayResult()
	{
		int day = 1;
		int currentChapter = 1;
		for (int chapter : optimalPath)
		{
			if((currentChapter+1) == chapter)
			{
				day++;
			}
			else
			{
				while(currentChapter <= chapter)
				{
					System.out.print(","+currentChapter);
					currentChapter++;
				}
				System.out.println();
			}
			System.out.print("Day: "+day);
			System.out.print("Chapters: ");
		}
	}
	
	public static void main(String[] args)
	{
		int[] pages = {7, 5, 6, 12};
		new OptimalChapterReadList().minimizeAssignment(pages);
	}
}
