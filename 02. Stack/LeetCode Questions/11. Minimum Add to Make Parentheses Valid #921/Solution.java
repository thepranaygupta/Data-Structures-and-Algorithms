class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character>st=new Stack();
            for(char c :  S.toCharArray()){ 
                if(c=='(')
                    st.push(c);
                else {
                    if(c==')' && !st.isEmpty() && st.peek()=='(')
                        st.pop();
                    else
                       st.push(c);
                }
            }
        return st.size();
    }
}
