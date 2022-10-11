class Solution {
public:
    vector<vector<int>> palindromePairs(vector<string>& words) {
        unordered_map<string, int> wmap;
        vector<vector<int>> ans;
        for (int i = 0; i < words.size(); i++)
            wmap[words[i]] = i;
        for (int i = 0; i < words.size(); i++) {
            if (words[i] == "") {
                for (int j = 0; j < words.size(); j++) {
                    string& w = words[j];
                    if (isPal(w, 0, w.size()-1) && j != i) {
                        ans.push_back(vector<int> {i, j});
                        ans.push_back(vector<int> {j, i});
                    }
                }
                continue;
            }
            string bw = words[i];
            reverse(bw.begin(), bw.end());
            if (wmap.find(bw) != wmap.end()) {
                int res = wmap[bw];
                if (res != i) ans.push_back(vector<int> {i, res});
            }
            for (int j = 1; j < bw.size(); j++) {
                if (isPal(bw, 0, j-1)) {
                    string s = bw.substr(j, bw.size()-j);
                    if (wmap.find(s) != wmap.end())
                        ans.push_back(vector<int> {i, wmap[s]});
                }
                if (isPal(bw, j, bw.size()-1)) {
                    string s = bw.substr(0, j);
                    if (wmap.find(s) != wmap.end())
                        ans.push_back(vector<int> {wmap[s], i});
                }
            }
        }
        return ans;
    }
private:
    bool isPal(string& word, int i, int j) {
        while (i < j)
            if (word[i++] != word[j--]) return false;
        return true;
    }
};