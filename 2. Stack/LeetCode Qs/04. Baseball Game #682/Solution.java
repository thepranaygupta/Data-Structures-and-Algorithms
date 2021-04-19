class Solution {
    public int calPoints(String[] ops) {
        Stack st=new Stack<Integer>();
        int x, y, sum=0;
        for(String i: ops) {
            switch(i) {
                case "C":
                    st.pop();
                    break;
                case "D":
                    x=(int)st.peek();
                    st.push(x*2);
                    break;
                case "+":
                    x=(int)st.peek();
                    st.pop();
                    y=(int)st.peek();
                    st.pop();
                    st.push(y);
                    st.push(x);
                    st.push(x+y);
                    break;
                default:
                    x=Integer.parseInt(i);
                    st.push(x);
                    break;
            }
        }
        while(st.size()>0)
            sum = sum+(int)st.pop();
        return sum;
    }
}