class Solution {
public:
    int maxPerformance(int n, vector<int>& speed, vector<int>& efficiency, int k) {
        vector<pair<int, int>> ord;
        for (int i = 0; i < n; i++)
            ord.push_back({efficiency[i], speed[i]});
        sort(ord.rbegin(), ord.rend());
        priority_queue<int> sppq;
        long totalSpeed = 0, best = 0;
        for (auto& p : ord) {
            int spd = p.second;
            sppq.push(-spd);
            if (sppq.size() <= k) totalSpeed += spd;
            else {
                totalSpeed += spd + sppq.top();
                sppq.pop();
            }
            best = max(best, totalSpeed * p.first);
        }
        return best % 1000000007;
    }
};