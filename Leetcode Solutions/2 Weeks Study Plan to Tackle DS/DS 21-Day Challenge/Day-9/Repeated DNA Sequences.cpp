class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        unordered_map<size_t,int> MP;
        hash<string> hash_fn;
        vector<string> ret;
        for(int i = 0; i < int(s.size()) - 9; ++i)
            if(MP[hash_fn(s.substr(i,10))]++ == 1 )
                ret.push_back(s.substr(i,10));
      return ret;
    }
};