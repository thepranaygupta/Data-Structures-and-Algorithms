class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
		if(strs.size() == 1)
            return {{strs[0]}};
        vector<vector<string>> ans;
        unordered_map<string, vector<string>> M;
        for(int  i = 0; i < strs.size(); i++)
        {
            string str = strs[i];
            sort(strs[i].begin(), strs[i].end());
            M[strs[i]].push_back(str);
        }
        for(auto i = M.begin(); i != M.end(); i++)
            ans.push_back(i -> second);
        return ans;
    }
};