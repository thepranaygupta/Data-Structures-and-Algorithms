class Solution {
public:
    vector<int> partitionLabels(string S) {
  vector<int> res, pos(26, 0);  
  for (auto i = 0; i < S.size(); ++i)
      pos[S[i] - 'a'] = i;
  for (auto i = 0, idx = INT_MIN, last_i = 0; i < S.size(); ++i) {
    idx = max(idx, pos[S[i] - 'a']);
    if (idx == i) res.push_back(i - exchange(last_i, i + 1) + 1);
  }
  return res;
}
};