package string;

public class RabinKarpStringMatching 
{
	int prime = 101;
	
	private long calculateHash(char[] arr, int length)
	{
		long hash = 0;
		
		for (int i = 0; i < length; i++) 
		{
			hash += arr[i]*Math.pow(prime, i);
		}
		return hash;
	}
	
	private long reCalculateHash(char[] arr, long oldHash, int oldIndex, int newIndex, int paternLength)
	{
		long newHash = (oldHash - arr[oldIndex])/prime;
		newHash += arr[newIndex]*Math.pow(prime, paternLength-1);
		return newHash;
	}
	
	
	public void matchPattern(char[] text, char[] pattern)
	{
		int size = text.length;
		int patternSize = pattern.length;
		long patternHash = calculateHash(pattern, patternSize);
		long textHash = calculateHash(text, patternSize);
		
		boolean matchFound = false;
		for (int i = 0; i <= size - patternSize; i++) 
		{
			if(patternHash == textHash && checkEquals(text, i, i + patternSize - 1, pattern, 0, patternSize-1))
			{
				matchFound = true;
				break;
			}
			else
			{
				textHash = reCalculateHash(text, textHash, i, i + patternSize, patternSize);
			}
		}
		System.out.println(matchFound);
	}
	
	private boolean checkEquals(char[] str1, int start1, int end1, char[] str2, int start2, int end2)
	{
		for (; start1<end1 && start2<end2; start1++,start2++) 
		{
			if(str1[start1] != str2[start2])
			{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) 
	{
		RabinKarpStringMatching kmpStringMatching = new RabinKarpStringMatching();
		char[] patternArr = "abcaby".toCharArray();
		char[] textArr = "abxabcabcaby".toCharArray();
		kmpStringMatching.matchPattern(textArr, patternArr);
	}
}
