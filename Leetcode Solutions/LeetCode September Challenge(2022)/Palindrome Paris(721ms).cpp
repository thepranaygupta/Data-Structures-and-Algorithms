class Solution {
public:
    inline bool isPalindrome(const string &s, int l, int r) {
        while(l < r && s[l] == s[r]) {
            l++;
            r--;
        }
        return l >= r;
    }
    vector<vector<int>> palindromePairs(vector<string>& words) {
        map<int, unordered_map<string, int>> mm;
        for(int i=0; i<words.size(); i++) {
            mm[words[i].size()][string(words[i].rbegin(), words[i].rend())] = i;
        }
        vector<vector<int>> res;
        for(int i=0; i < words.size(); i++) {
            auto w = words[i];
            for(auto & kv : mm) {
                auto & k = kv.first;
                auto & m = kv.second;
                if (k > w.size())
                    break;
                if (k == w.size()) {
                    if (m.count(w) && m[w] != i) {
                        res.push_back({i, m[w]});
                    }
                    break;
                }
                if (isPalindrome(w, k, w.size() - 1)) {
                    auto tgt = w.substr(0, k);
                    if (m.count(tgt)) {
                        res.push_back({i, m[tgt]});
                    }
                }
                if (isPalindrome(w, 0, w.size() - k - 1)) {
                    auto tgt = w.substr(w.size() - k);
                    if (m.count(tgt)) {
                        res.push_back({m[tgt], i});
                    }
                }
            }
        }
        return res;
    }
};