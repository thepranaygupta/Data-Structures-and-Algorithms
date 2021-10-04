## 13. pascal's triangle
## https://www.interviewbit.com/problems/pascal-triangle/

Given numRows, generate the first numRows of Pascal's triangle.
Pascal's triangle : To generate A[C] in row R, sum up A'[C] and A'[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]


```C++
vector<vector<int> > Solution::solve(int A) {
   
    vector<vector<int>> v;
     if(A == 0)
   return v;
    vector<int> v1;
    v1.push_back(1);
    v.push_back(v1);
    
    int x;
    for(int i=2;i<=A;i++)
    {
       vector<int> v2(v1.size(),0);
        x=1;
        v2[0] = v1[0];
    while(x<v1.size()){
        v2[x] = v1[x]+v1[x-1];
          x++; 
    }
    v2.push_back(v1[0]);
    v.push_back(v2);
    v1 = v2;
}
    return v;

}

```

## Asked in Google, Amazon
