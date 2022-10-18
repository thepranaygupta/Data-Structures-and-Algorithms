class Solution
{
public:
    vector<int> sumEvenAfterQueries(vector<int>& A, vector<vector<int>>& queries);
};
vector<int> Solution :: sumEvenAfterQueries(vector<int>& arr, vector<vector<int>>& queries)
{
    int sum = 0;
    for(auto ele:arr)
        if(ele%2==0) sum +=ele;
    vector<int> answer;
    for(auto row_vec:queries)
    {
        int extra = row_vec[0];
        int index = row_vec[1];
        int oldValue = arr[index];
        arr[index] +=extra;
        int newValue = arr[index];
        if(oldValue%2==0 && newValue%2==0) sum+=extra;
        else if(oldValue%2!=0 && newValue%2==0) sum+=newValue;
        else if(oldValue%2==0 && newValue%2!=0) sum-=oldValue;
        answer.push_back(sum);
    }
    return answer;
}