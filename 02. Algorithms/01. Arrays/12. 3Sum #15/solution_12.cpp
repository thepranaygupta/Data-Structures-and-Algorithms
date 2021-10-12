// Leetcode Problem Link :- https://leetcode.com/problems/3sum/

class Solution
{
public:
    vector<vector<int>> threeSum(vector<int> &num)
    {
        vector<vector<int>> fin_triplet;
        sort(num.begin(), num.end());
        for (int i = 0; i < num.size(); i++)
        {
            int target = -num[i];
            int front = i + 1;
            int rear = num.size() - 1;

            while (front < rear)
            {
                int sum = num[front] + num[rear];
                if (sum < target)
                    front++;
                else if (sum > target)
                    rear--;
                else
                {
                    vector<int> triplet = {num[i], num[front], num[rear]};
                    fin_triplet.push_back(triplet);

                    while (front < rear && num[front] == triplet[1])
                        front++;

                    while (front < rear && num[rear] == triplet[2])
                        rear--;
                }
            }
            while (i + 1 < num.size() && num[i + 1] == num[i])
                i++;
        }
        return fin_triplet;
    }
};