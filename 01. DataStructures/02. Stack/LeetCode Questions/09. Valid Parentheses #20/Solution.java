class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0) return false;
        
        Stack<Character> st = new Stack();
       for(char c :  s.toCharArray()){ 
               if(c=='(' || c=='[' ||  c=='{')
                   st.push(c);
               else if(c==']' && !st.isEmpty() &&  st.peek()=='[') st.pop();
               else if(c==')' && !st.isEmpty() &&  st.peek()=='(') st.pop();
               else if(c=='}' && !st.isEmpty() &&  st.peek()=='{') st.pop();
               else st.push(c);
        }
       return st.isEmpty();
    }
}
