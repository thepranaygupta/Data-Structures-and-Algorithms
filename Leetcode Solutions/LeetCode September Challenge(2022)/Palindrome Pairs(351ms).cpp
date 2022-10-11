class Solution {
public:
    bool isPalin(string &s, int i, int j) {
        while(i < j)
        {
            if(s[i++] != s[j--]) return false;
        }
    return true;
}
vector<vector<int>> palindromePairs(vector<string> &words) {
    vector<vector<int>> ans;
    if (words.empty()) return ans;
    unordered_map<string, int> mp;
    set<int> st;
    for (int i = 0; i < words.size(); i++) {
        mp[words[i]] = i;
        st.insert(words[i].size());
    }
    for (int i = 0; i < words.size(); ++i) {
        string cpy(words[i]);
        reverse(cpy.begin(),cpy.end());
        int ln = cpy.size();
        if(mp.find(cpy) != mp.end() && mp[cpy] != i)
            ans.push_back({i,mp[cpy]});
        for(auto l : st){
            if(l >= ln) break;
            if(isPalin(words[i],0,ln-l-1)){
                string p = cpy.substr(0,l);
                if(mp.find(p) != mp.end())
                    ans.push_back({mp[p],i});
            }
            if(isPalin(words[i],l,ln-1)){
                string  p = cpy.substr(ln-l);
                if(mp.find(p) != mp.end())
                    ans.push_back({i,mp[p]});
            }
        }
    }
    return ans;
}
};