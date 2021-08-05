class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> st=new Stack();
        int score=0;
        for(char c: S.toCharArray()){
            
            if(c=='('){ 
                st.push(score);
                score=0;
            }
            else{
                score=st.pop()+Math.max(2*score,1);
            }
        }
        return score;
    }
}
