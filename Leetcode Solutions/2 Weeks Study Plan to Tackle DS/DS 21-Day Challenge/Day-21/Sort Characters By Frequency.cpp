class Solution {

public:

    string frequencySort(string s) {

        unordered_map<char, int> cnt;

        for (char c : s) cnt[c] += 1;

        vector<pair<int, char>> arr;

        for (auto& [c, freq] : cnt)

            arr.push_back(make_pair(freq, c));

        

        sort(arr.begin(), arr.end(), [](const auto& a, const auto& b) {

            return a.first > b.first;

        });

        string ans;

        for (auto& [freq, c] : arr)

            ans.append(freq, c);

        return ans;

    }

};