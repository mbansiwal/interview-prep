package arr;

import java.util.Stack;

public class MaximumHistogram {
	public int maxHistogram(int[] heights) {
		int maxArea = 0;
        int i =0;
        Stack<Integer> stack = new Stack<>();
        for(;i<heights.length; ){
            if(stack.empty() || heights[stack.peek()] <= heights[i]){
                stack.push(i++);
            } else{
                int area = 0;
                int top = stack.pop();
                if(stack.empty()){
                    area = i*heights[top];
                } else{
                    area = heights[top]*(i - 1 - stack.peek());
                }
                maxArea = Math.max(maxArea, area);
            }
        }
        while(!stack.empty()){
            int area = 0;
            int top = stack.pop();
            if(stack.empty()){
                area = i*heights[top];
            } else{
                area = heights[top]*(i - 1 - stack.peek());
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
	}

	public static void main(String[] args) {
		MaximumHistogram hist = new MaximumHistogram();
		int height[] = { 2, 1, 5, 6, 2, 3 };
//		System.out.println(hist.maxHistogram(height));
		
		int height2[] = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println(hist.maxHistogram(height2));
	}
}
