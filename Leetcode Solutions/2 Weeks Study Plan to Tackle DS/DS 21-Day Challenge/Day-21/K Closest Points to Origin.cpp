class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& ps, int K) {

  multimap<int, int> m;

  for (int i = 0; i < ps.size(); ++i)

    m.insert({ ps[i][0] * ps[i][0] + ps[i][1] * ps[i][1], i });

  vector<vector<int>> res;

  for (auto it = m.begin(); K > 0; ++it, --K) res.push_back(ps[it->second]);

  return res;

}
};