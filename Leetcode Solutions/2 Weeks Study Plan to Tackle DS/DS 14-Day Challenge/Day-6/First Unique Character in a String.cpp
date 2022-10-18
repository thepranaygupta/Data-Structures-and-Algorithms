class Solution {
public:
    int firstUniqChar(string s) {
        map<char, int> G;
        for (int i{}; i < s.size(); i++) { 
            G[s[i]]++;
    } 
        for (int i{}; i < s.size(); i++) { 
      if (G[s[i]] == 1) return i; 
    } 
        return -1;
    }
};