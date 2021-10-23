#include<iostream>
#include<vector>
using namespace std;



vector<string> Gsp(int n){
    if(n==0 ){
        vector<string> a={""};
        return a;
    }
    if(n<0){
        vector<string> b;
        return b;}
    vector<string> rgsp1=Gsp(n-1);
    vector<string> rgsp2=Gsp(n-2);
    vector<string> rgsp3=Gsp(n-3);
    
    vector<string> Fgsp;
    for(string value:rgsp1){
        Fgsp.push_back("1"+value);
    }
     
    for(string value:rgsp2){
        Fgsp.push_back("2"+value);
    }
     
    for(string value:rgsp3){
        Fgsp.push_back("3"+value);
    }
    return Fgsp;
}

    
void display(vector<string>& arr){
    cout << "[";
    for(int i = 0;i < arr.size();i++){
        cout << arr[i];
        if(i < arr.size() -1) cout << ", ";
    }
    
    cout << "]"<<endl;
}



int main(){
    int n;
    cin>>n;
    vector<string> ans= Gsp(n);
    display(ans);
    return 0;
}
