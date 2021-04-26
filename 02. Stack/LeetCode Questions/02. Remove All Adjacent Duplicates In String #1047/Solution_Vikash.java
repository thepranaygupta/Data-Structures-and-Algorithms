class Solution {
    public String removeDuplicates(String S) {
        int l=S.length();
        char st[]=new char[l];
        int top=-1;
        for(int i=0;i<l;i++){
            char currCh=S.charAt(i);
            if(top>-1 && st[top]==currCh)
                top--;
            else{
                top++;
                st[top]=currCh;
            }
        }
        return new String(st,0,top+1);
    }
}

/** Logic Used here is :-

    for(i=0 to i=s.length()){
        if(st.peek()==S.charAt(i))
            POP;
        else 
            PUSH;
    }
    return stackAsString
**/
