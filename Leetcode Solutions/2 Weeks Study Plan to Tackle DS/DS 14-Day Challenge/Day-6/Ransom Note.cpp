class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        int r[26] = {0};
        int m[26] = {0};
        
        for(auto c : ransomNote)    r[c - 'a']++;
        for(auto c : magazine)      m[c - 'a']++;
        for(int i = 0; i < 26; i++) if(r[i] > m[i]) return false;
        return true;
    }
};