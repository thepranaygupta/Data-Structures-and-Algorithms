#include<bits/stdc++.h>
using namespace std;

vector<int> stockSpan(vector<int>& arr){

int n = arr.size();
vector<int> ans(n);
stack<int> s;

for (int i = 0 ;i < n ; i++)
{
    while (!s.empty() && arr[s.top()] <= arr[i])
        s.pop();

    if(s.empty())
        ans[i]= i+1;
    else
        ans[i]= i - s.top();

    s.push(i);
}   
return ans;
}

int main()
{   
    vector<int> arr = {100,80,60,70,60,75,85};
    vector<int> out = stockSpan(arr);

    for(auto x : out){
        cout<<x<<" ";
    }
    return 0;
}