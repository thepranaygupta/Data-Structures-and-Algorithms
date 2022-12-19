//question link- https://leetcode.com/problems/decode-string/

class Solution{
    int i = 0;
    public String decodeString(String s){
        StringBuilder result = new StringBuilder();
        while(i < s.length() && s.charAt(i) != ']'){
            if(Character.isDigit(s.charAt(i))){
                int k = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i)))
                    k = k*10 + s.charAt(i++) - '0';
                i++;
                String r = decodeString(s);
                while(k-- > 0)
                    result.append(r);
                i++;
            }else
                result.append(s.charAt(i++));
        }
        return result.toString();
    }
}