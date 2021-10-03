#include<iostream>
#include<math.h>
using namespace std;

class stack1{       // self made stack for easy understanding
    private:
        int arr1[10],top_element_place = -1;
    public:
        stack1(){
            for(int i=0;i<10;i++){
                arr1[i] = 0;
            }
        }
        void push(int x){
            if(top_element_place < 9){
                top_element_place++;
                arr1[top_element_place] = x;
            }else{
                cout << "stack overflow detected !!!" << endl;
            }
        }
        void pop(){
            if(top_element_place > -1){
                arr1[top_element_place] = 0;
                top_element_place--;
            }else{
                cout << "stack underflow detected !!!" << endl;
            }
        }
        bool is_empty(){
            if(top_element_place == -1){
                return true;   
            }else{
                return false;  
            }
        }
        bool is_full(){
            if(top_element_place == 9){
                return true;  
            }else{
                return false;  
            }
        }
        int count(){
            cout << "number of elements in stack is -> " << top_element_place+1 << endl;
            return top_element_place+1; 
        }
        int top(){
            return arr1[top_element_place];
        }
        void display(){
            for(int i=0;i<top_element_place+1;i++){
                cout << arr1[i] << ", ";
            }
            cout << endl;
        }
};

stack1 s1,s2,s3;        // stacks declaration

void transferer12(){
    int num1 = s1.top();
    s2.push(num1);
    s1.pop();
}
void transferer13(){
    int num1 = s1.top();
    s3.push(num1);
    s1.pop();
}
void transferer21(){
    int num1 = s2.top();
    s1.push(num1);
    s2.pop();
}
void transferer23(){
    int num1 = s2.top();
    s3.push(num1);
    s2.pop();
}
void transferer31(){
    int num1 = s3.top();
    s1.push(num1);
    s3.pop();
}
void transferer32(){
    int num1 = s3.top();
    s2.push(num1);
    s3.pop();
}


int main(){

    int n1,n2;
    cout << "Enter the number of discs you want in tower of hanoi (MAX discs is 9) -> ";
    cin >> n1;
    if(n1>9){
        n1 = 9;
    }
    n2 = pow(2,n1);
    for(int i=n1;i>0;i--){
        s1.push(i);
    }
    cout << endl << endl;

    cout << "stack 1" << endl;
    s1.display();
    cout << endl;

    cout << "stack 2" << endl;
    s2.display();
    cout << endl;

    cout << "stack 3" << endl;
    s3.display();

    for(int i=1;i<n2;i++){
        if(i%3 == 1){
            if(s2.is_empty() || s1.top() < s2.top()){
                transferer12();
            }else{
                transferer21();
            }
        }
        else if(i%3 == 2){

            if(s3.is_empty() || s1.top() < s3.top()){
                transferer13();
            }else{
                transferer31();
            }
        }
        else if(i%3 == 0){
            if(s3.is_empty() || s3.top() < s2.top()){
                transferer32();
            }else{
                transferer23();
            }
        }
    }
    cout << "############################################################" << endl << endl;
    cout << "stack 1" << endl;
    s1.display();
    cout << endl;

    cout << "stack 2" << endl;
    s2.display();
    cout << endl;

    cout << "stack 3" << endl;
    s3.display();
    return 0;
}