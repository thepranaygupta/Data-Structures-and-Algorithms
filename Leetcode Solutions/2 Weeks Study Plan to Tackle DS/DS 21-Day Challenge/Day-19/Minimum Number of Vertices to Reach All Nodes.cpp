class Solution {
public:
  vector<int> findSmallestSetOfVertices(int n, vector<vector<int>>& edges) {
    vector<int> res, in(n);
    for(auto edge: edges)
      in[edge[1]]++;
    for(int i=0; i!=n; ++i)
      if(in[i]==0) res.push_back(i);
    return res;
  }
};