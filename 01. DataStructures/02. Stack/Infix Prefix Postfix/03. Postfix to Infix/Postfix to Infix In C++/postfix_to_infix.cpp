// I/O Sample:
/*
Postfix exp: "AB+CD-*"
Infix exp:((A+B)*(C-D))

Postfix exp: "ABC/-AD/E-*"
Infix exp:((A-(B/C))*((A/D)-E))
*/

// Including header fils.
#include<iostream> // For using cout, cin
#include<stack>    // For using stack<string>
#include<cctype>   // For using isalpha()
using namespace std;

// Defination of Convert class,
// that will convert the postfix expression into infix.
class Convert{
    string postfix;
    public:
        // Declaration of Constructor.
        Convert(string exp);
        // Member function to convert.
        string postfixToInfix();
};

// Defination of Constrcutor.
Convert::Convert(string exp){
    this->postfix = exp;
}

// Defination of postfixToInfix() function,
// which will return the equavalent Infix of expression.
string Convert::postfixToInfix(){
    stack<string> myStack;
    for(int i = 0; i < postfix.length(); i++){
        if(isalpha(postfix[i])){
            string opr(1, postfix[i]); 
            myStack.push(opr); 
        }else{
            string opr1 = myStack.top(); myStack.pop(); 
            string opr2 = myStack.top(); myStack.pop(); 
            myStack.push("(" + opr2 + postfix[i] + opr1 + ")");
        }
    }
    return myStack.top();
}

// main() function or the driver function.
int main(){
    // Taking input of Postfix expression form the user.
    string exp = "";
    cout<< "\nEnter the Postfix Expression: "<< endl;
    cin>> exp;

    // Instantiating Convert class,
    // Using exp.
    Convert *obj = new Convert(exp);
    
    // Printing the Postfix and its equavalent Infix expression.
    cout<< "\nPostfix Expression: "<< exp<< endl; 
    cout<< "Infix Expression: "<< obj->postfixToInfix()<< endl; 
    
    return 0;
    // End of main() function.
}    
