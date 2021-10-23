class Solution 
{
    public String simplifyPath(String s) 
    {
        if(s.length()==0)
            return "";
        
        Stack<String>st=new Stack<>();
        st.push("/");
        
        String path[]=s.split("/");
        
        
        for(int i=0;i<path.length;i++)
        {
            String ch=path[i];
            
            if(ch.equals(""))
                continue;
            
            else if(ch.charAt(0)=='.')
            {
                if(ch.length()>2)
                {
                    st.push(ch);
                    st.push("/");
                    continue;
                }
                else if(ch.length()==2)
                {
                    while(st.size()>0 && st.peek().equals("/"))
                    {
                        st.pop();
                    }
                    if(st.size()>0)
                        st.pop();
                }
                if(st.size()!=0 && st.peek().equals("/"))
                    i=i;
                else
                    st.push("/");
                
            }
            else
            {
                st.push(ch);
                st.push("/");
            }
        }
        
        if(st.size()>1 && (st.peek().equals("/") || st.peek().equals(".")))
            st.pop();
        
        if(st.size()==0)
            st.push("/");
        
        StringBuilder sb=new StringBuilder();
        
        while(st.size()>0)
        {
            sb.insert(0,st.pop());
        }
        
        return sb.toString();
    }
}