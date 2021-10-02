
#include <bits/stdc++.h>
using namespace std;
 
// function to check if character is operator or not
bool isOperator(char op) {
  if(op=='+' || op=='*' || op=='-' || op=='/'){
    return true;
  }
  return false;
}
 
string preToInfix(string exp) {
  stack<string> s;
  int len = exp.size();  // storing the length of expression
 
  for (int i = len-1; i >= 0; i--) {         // starting from right to left
 
    // checking if symbol is operator
    if (isOperator(exp[i])) {
      string op1 = s.top();    // pop two operands from stack
      s.pop();
      string op2 = s.top();
      s.pop();
      string temp = "(" + op1 + exp[i] + op2 + ")"; // concencate them
      s.push(temp);  // pushing to stack
    }
 
    // if symbol is an operand
    else {
      s.push(string(1, exp[i]));
    }
  }
  return s.top();  // contains infix expression
}
 

int main() {
  string exp = "*-A/BC-/AKL";
  cout << "Infix : " << preToInfix(exp);
  return 0;
}
