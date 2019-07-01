package hash;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class CountPairsFromTwoLinkedLists
{
	static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2, int x)
    {
        int count = 0;
          
        // sort head1 in ascending order and
        // head2 in descending order
        Collections.sort(head1);
        Collections.sort(head2,Collections.reverseOrder());
         
        // traverse both the lists from left to right
        Iterator<Integer> itr1 = head1.iterator();
        Iterator<Integer> itr2 = head2.iterator();
         
        Integer num1 = itr1.hasNext() ? itr1.next() : null;
        Integer num2 = itr2.hasNext() ? itr2.next() : null;
         
        while(num1 != null && num2 != null)
        {    
             
            // if this sum is equal to 'x', then move both 
            // the lists to next nodes and increment 'count'
             
            if ((num1 + num2) == x)
            {
                num1 = itr1.hasNext() ? itr1.next() : null;
                num2 = itr2.hasNext() ? itr2.next() : null;
                 
                count++; 
            } 
             
            // if this sum is greater than x, then
            // move itr2 to next node
            else if ((num1 + num2) > x)
                num2 = itr2.hasNext() ? itr2.next() : null;
             
            // else move itr1 to next node 
            else
                num1 = itr1.hasNext() ? itr1.next() : null;
             
        }
                            
        // required count of pairs     
        return count;
    }
     
    // Driver method
    public static void main(String[] args) 
    {
        Integer arr1[] = {3, 1, 5, 7};
        Integer arr2[] = {8, 2, 5, 3};
         
        // create linked list1 3->1->5->7
        LinkedList<Integer> head1 = new LinkedList<>(Arrays.asList(arr1));
         
        // create linked list2 8->2->5->3
        LinkedList<Integer> head2 = new LinkedList<>(Arrays.asList(arr2));
        
        int x = 10;
          
        System.out.println("Count = " + countPairs(head1, head2, x));
    }   
}
