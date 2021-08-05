class Solution {
    public boolean backspaceCompare(String s, String t) {
            Stack<Character> st1 = backspaceOperationWithStack(s);
            Stack<Character> st2 = backspaceOperationWithStack(t);
 
         return st1.equals(st2);   
    }
    
    public Stack<Character> backspaceOperationWithStack(String str) {
 
          Stack<Character> st = new Stack<>();
 
          //Traverse a string
          for(int i = 0; i < str.length(); i++) {
 
            char ch = str.charAt(i);
 
            /*
              If current char is not a backspace,
              then push them in a stack. Else pop the
              last pushed character from a stack.
            */
            if(ch != '#') {
             st.push(ch);
            } 
             else if (!st.isEmpty()){
               st.pop();
             } 
         }
 
         return st;
     }
}