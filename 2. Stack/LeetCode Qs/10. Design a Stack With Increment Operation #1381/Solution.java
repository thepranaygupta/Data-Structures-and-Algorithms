class CustomStack {
    
     int top;
	 int arr[];
     int n;// size of stack
    public CustomStack(int maxSize) {
        top=-1;
        n=maxSize;
        arr=new int[n];
    }
    
    public void push(int x) {
      if (top != n-1){
          top++; 
		  arr[top] = x;
      }  
    }
    
    public int pop() {
        if (top == -1) return -1;
        else{
            int popValue = arr[top];
	      arr[top] = 0;
	      top--;
	      return popValue;
        }
    }
    
    public void increment(int k, int val) {
        int min=Math.min(k-1,top);
        
        for(int i=0;i<=min;i++){
            arr[i]=arr[i]+val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
