class Solution {
    public String makeGood(String S) {
        int l=S.length();
        char st[]=new char[l];
        int top=-1;
        for(int i=0;i<l;i++){
            char currCh=S.charAt(i);
            if(top>-1 && Math.abs(st[top]-S.charAt(i)) == 32)
                top--;
            else{
                top++;
                st[top]=currCh;
            }
        }
        return new String(st,0,top+1);
    }
}