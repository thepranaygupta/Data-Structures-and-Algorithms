class Solution {
public:
    bool wordPattern(string pattern, string s) {
        unordered_map<char, int> p2i;
        unordered_map<string, int> w2i;
        istringstream in(s); string word;
        int i = 0, n = pattern.size();
        for(word; in>>word; i++){
            if(i==n || p2i[pattern[i]] != w2i[word]) return false;
            p2i[pattern[i]] = w2i[word] = i+1;
        }
        return i==n;
    }
};