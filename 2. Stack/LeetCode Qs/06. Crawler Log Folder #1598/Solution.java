class Solution {
    public int minOperations(String[] logs) {
        Stack st = new Stack<String>();
        for(String i : logs){
            if(i.equals("../")){
                if(!st.empty())
                    st.pop();
            }
            else if(i.equals("./")) 
                continue;
            else
                st.push(i);
        }
        return st.size();
    }
}