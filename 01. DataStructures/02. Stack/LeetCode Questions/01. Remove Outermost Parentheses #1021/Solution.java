class Solution {
    public String removeOuterParentheses(String S) {
        Stack st=new Stack<Character>();
        StringBuilder ans=new StringBuilder();
        
        for(int i=0; i<S.length(); i++) {
            if(st.empty())
                st.push(S.charAt(i));
            else if(st.size() == 1) {
                if(S.charAt(i) == '(') {
                    ans = ans.append(S.charAt(i));
                    st.push(S.charAt(i));
                }
                else
                    st.pop();
            }
            else {
                if(S.charAt(i) == '(') {
                    ans = ans.append(S.charAt(i));
                    st.push(S.charAt(i));
                }
                else {
                    ans = ans.append(S.charAt(i));
                    st.pop();
                }
            }
        }
        return ans.toString();
    }
}
