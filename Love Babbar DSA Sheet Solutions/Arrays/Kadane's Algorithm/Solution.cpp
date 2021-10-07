#include<iostream>
#include<math.h>
#include<vector>
using namespace std;

//Function to calculate maximum sum subarray
int maximum_sum_subarray(vector<int>& arr){

    int max_so_far=arr[0], max_till_here=arr[0];

    for(int i=1;i<arr.size();i++){

         max_till_here=max(arr[i],max_till_here+arr[i]); //max sum ending at a perticular index will either be arr[i] 
         //or previous sum added to arr[i]
            max_so_far=max(max_so_far,max_till_here);

    }
    return max_so_far;
}

int main(){
    int n,sum;
    cin>>n;
    vector<int> arr(n);

    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    sum=maximum_sum_subarray(arr);
    cout<<sum<<"\n";
    return 0;

}