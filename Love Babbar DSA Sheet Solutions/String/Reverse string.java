//question link 1. https://leetcode.com/problems/reverse-string/

class Solution 
{
    public void reverseString(char[] s) 
    {

      char temp=' ';
   for(int i=0; i<s.length/2; i++){
            temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
   }
    for(int i=0;i<s.length;i++)
        System.out.print(s[i]);
    }
}
