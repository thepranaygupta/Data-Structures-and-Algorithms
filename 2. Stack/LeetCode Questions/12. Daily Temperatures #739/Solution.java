class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) 
                stack.pop();
            if(stack.isEmpty())
                ans[i]=0;
            else
                ans[i]=stack.peek() - i;
            
            stack.push(i);
        }
        return ans;
    }
}
