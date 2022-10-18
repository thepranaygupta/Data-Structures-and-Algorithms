class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char,int> map;
        for(int i=0;i<s.length();i++){
            map[s[i]]++;
        }
        int cnt=0;
        for(auto i:map){
            if(i.second%2!=0){
                cnt++;
            }
        }
        if(cnt>1){
            return s.length()-cnt+1;
        }
        return s.length();
    }
};