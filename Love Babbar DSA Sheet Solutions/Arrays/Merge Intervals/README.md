# **[56. Merge Intervals](https://leetcode.com/problems/merge-intervals/)**

## Easiest solution- 168 / 168 test cases passed - Runtime: 28 ms - Memory Usage: 14.6 MB

- First we sort the elements in ascending order. We declare a vector v which stores the intervals.
- We run for loop and check- Conditions- 1) If vector is empty we need to push the first interval or if the last element of v is less than the next element in intervals, we cannot merge them. Therefore, we make a new interval. 2) If there is a possibility to merge, we merge.

```C++
class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> v;
        sort(intervals.begin(),intervals.end());
        for(auto i : intervals){
            if(v.empty()==1 || v.back()[1]<i[0]){
                v.push_back(i);
            }
            else{
                v.back()[1]=max(v.back()[1], i[1]);
            }
        }
        return v;
    }
};
```



## **[Video Reference : Take U forward](https://www.youtube.com/watch?v=2JzRBPFYbKE)**
