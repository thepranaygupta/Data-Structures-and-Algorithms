//https://www.geeksforgeeks.org/bottom-view-binary-tree/
vector<int> bottomview(TreeNode *root)
{
  vector<int> ans;
  if (!root)
    return ans;

  map<int, int> map;
  queue<pair<TreeNode *, int>> q;

  q.push({root, 0});

  while (!q.empty())
  {
    auto it = q.front();
    q, pop();
    TreeNode *node = it.first;
    int line = it.second;
    map[line] = node->val;

    if (node->left)
      q.push({node->left, line - 1});

    if (node->right)
      q.push({node->right, line + 1});
  }

  for (auto it : map)
  {
    ans.push_back(it.second);
  }
  return ans;
}
