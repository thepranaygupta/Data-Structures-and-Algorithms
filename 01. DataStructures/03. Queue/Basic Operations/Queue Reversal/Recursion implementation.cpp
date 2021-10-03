#include<bits/stdc++.h>
using namespace std;

void queue_reverse_recursion_implementation(queue<int>*q2){
    int size = (*q2).size() , data = (*q2).front();
    if(size == 0){
        return;
    }else{
        (*q2).pop();
        queue_reverse_recursion_implementation(q2);
        (*q2).push(data);
        return;
    }
}

int main(){
    queue<int>q1;
    q1.push(10);
    q1.push(20);
    q1.push(30);
    q1.push(40);
    q1.push(50);
    q1.push(60);
    q1.push(70);
    q1.push(80);
    q1.push(90);
    q1.push(100);
    cout << "Queue Size -> " << q1.size() << endl;
    queue_reverse_recursion_implementation(&q1);
    for(int i=q1.size();i>0;i--){
        cout << q1.front() << " ";
        q1.pop();
    }
    cout << endl;
    return 0;
}