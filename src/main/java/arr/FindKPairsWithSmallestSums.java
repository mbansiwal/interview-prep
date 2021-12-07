package arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKPairsWithSmallestSums {
	class Pair{
        int sum;
        List<Integer> result;
        int jIndex;
        public Pair(int a1, int a2, int jIndex){
            sum = a1 + a2;
            result = Arrays.asList(a1, a2);
            this.jIndex = jIndex;
        }
        
    }
        
    public List<List<Integer>> kSmallestPairs(int[] num1, int[] num2, int k) {
        Queue<Pair> queue = new PriorityQueue<>((p1, p2)-> p1.sum-p2.sum);
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0; i<num1.length;++i){
            queue.add(new Pair(num1[i], num2[0], 0));
        }
        while(k >0 && !queue.isEmpty()){
          Pair temp = queue.poll();  
          result.add(temp.result);
          --k;
          if(temp.jIndex < num2.length-1){
              queue.add(new Pair(temp.result.get(0), num2[temp.jIndex+1], temp.jIndex+1));
          }  
        }
        
        return result;
    }
}
