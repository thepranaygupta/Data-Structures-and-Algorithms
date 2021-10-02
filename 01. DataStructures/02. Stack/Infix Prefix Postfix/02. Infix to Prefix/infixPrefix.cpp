// Infix to Prefix using Stack in C++
#include <bits/stdc++.h> 
using namespace std; 
bool isOperator(char c) 
{ 
    return (!isalpha(c) && !isdigit(c)); 
} 
int preceed(char a) 
{ 
    if(a == '+' || a == '-') 
    return 1;
    else if(a == '*' || a == '/') 
    return 2;  
    else if(a == '^') 
    return 3;
    else
    return -1; 
}
string infixToPostfix(string infix) 
{ 
    infix = '(' + infix + ')';  
    stack<char> char_stack; 
    string output; 
    for (int i = 0; i < infix.size(); i++) { 
   
        if (isalpha(infix[i]) || isdigit(infix[i])) 
            output += infix[i]; 
            
        else if (infix[i] == '(') 
            char_stack.push('('); 
  
        else if (infix[i] == ')') { 
  
            while (char_stack.top() != '(') { 
                output += char_stack.top(); 
                char_stack.pop(); 
            } 
  
            char_stack.pop();  
        } 
 
        else { 
              
            if (isOperator(char_stack.top())) { 
                while (preceed(infix[i]) <= preceed(char_stack.top())) { 
                    output += char_stack.top(); 
                    char_stack.pop(); 
                } 
                char_stack.push(infix[i]); 
            } 
        } 
    } 
    return output; 
} 
  
string infixToPrefix(string infix) 
{ 

    reverse(infix.begin(), infix.end()); 
    for (int i = 0; i < infix.size(); i++) { 
  
        if (infix[i] == '(') { 
            infix[i] = ')'; 
            i++; 
        } 
        else if (infix[i] == ')') { 
            infix[i] = '('; 
            i++; 
        } 
    } 
  
    string prefix = infixToPostfix(infix); 
    reverse(prefix.begin(), prefix.end()); 
    return prefix; 
} 
  

int main() 
{ 
    string s = ("(a+(b/c)*(d^e)-f)"); 
    cout << infixToPrefix(s) << std::endl; 
    return 0; 
}