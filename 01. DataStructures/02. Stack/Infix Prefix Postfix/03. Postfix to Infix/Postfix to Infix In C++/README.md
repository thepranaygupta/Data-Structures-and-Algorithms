## Postfix to Infix:
- ### Time Complexity: O(N)
- ### Auxiliary Space Complexity: O(N)

## Code Snippet:
```cpp
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
```

## Running Code:
![alt text](./output_01.png)
![alt text](./output_02.png)
