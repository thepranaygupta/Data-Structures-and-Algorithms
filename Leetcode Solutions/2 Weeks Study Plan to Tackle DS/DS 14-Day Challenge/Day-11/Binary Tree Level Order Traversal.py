class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        queue, ans = deque([root] if root else []), []
        while len(queue):
            qlen, row = len(queue), []
            for _ in range(qlen):
                curr = queue.popleft()
                row.append(curr.val)
                if curr.left: queue.append(curr.left)
                if curr.right: queue.append(curr.right)
            ans.append(row)
        return ans