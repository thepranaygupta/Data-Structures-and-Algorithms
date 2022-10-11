class Solution {
public:
    string breakPalindrome(string p) {
        int start = 0, end = p.size() - 1;
        if(p.size() <= 1) return "";
        while(start < end){
            if(p[start] != 'a' && p[end] != 'a'){
                p[start] = 'a';
                return p;
            }
            else{
                start++; end--;
            }
        }
        p[p.size() - 1] = 'b';
        return p;
    }
};