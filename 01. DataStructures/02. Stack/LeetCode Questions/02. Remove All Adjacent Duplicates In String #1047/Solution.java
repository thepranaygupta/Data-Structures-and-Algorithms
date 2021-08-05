class Solution {
    public String removeDuplicates(String S) {
        Stack st=new Stack<Character>();
        StringBuilder ans=new StringBuilder(S.length());
        for(int i=0; i<S.length(); i++) {
            //if the top of the stack is equal to the current character from the string, pop that element from the stack and remove the last character from ans
            if(!st.isEmpty() && (char)st.peek() == S.charAt(i)) { 
                st.pop();
                ans.deleteCharAt(ans.length()-1);
            }
            //else add that character to the stack and alse append to ans 
            else {
                st.add(S.charAt(i));
                ans.append(S.charAt(i));
            }
        }
        return ans.toString();
    }
}
