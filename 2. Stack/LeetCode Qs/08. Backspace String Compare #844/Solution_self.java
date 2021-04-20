class Solution {
    public boolean backspaceCompare(String s, String t) {
        String a=operate(s);
        String b=operate(t);
        return a.equals(b);
    }
    String operate(String check) {
        Stack stack=new Stack<Character>();
        for(int x=0; x<check.length(); x++) {
            char i=check.charAt(x);
            if(!stack.isEmpty() && i=='#'){
                stack.pop();
            }
            else if(i=='#')
                continue;
            else
                stack.push(i);
        }
        char ans[] = new char[stack.size()];
        int i = stack.size()-1;
        while(!stack.isEmpty()){
            ans[i--] = (char)stack.pop();
        }
        return new String(ans);
    }
}