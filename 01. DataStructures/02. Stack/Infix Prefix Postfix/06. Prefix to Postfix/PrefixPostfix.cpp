#include <iostream>
#include <string>
#include <stack>
#include <unordered_set>

std::string prefixToPostfix(std::string prefix)
{
    std::stack<std::string> prefixPostfixStack;
    std::unordered_set<char> symbols = {'+', '-', '*', '/', '^'};

    int n = prefix.size();

    for (int i = n - 1; i >= 0; i--)
    {
        if (symbols.find(prefix[i]) != symbols.end())
        {
            std::string op1 = prefixPostfixStack.top();
            prefixPostfixStack.pop();
            std::string op2 = prefixPostfixStack.top();
            prefixPostfixStack.pop();

            std::string t = op1 + op2 + prefix[i];
            
            prefixPostfixStack.push(t);
        }
        else
        {
            std::string t = std::string(1, prefix[i]);
            prefixPostfixStack.push(t);
        }
    }
    return prefixPostfixStack.top();
}

int main(){

    std::string prefix;
    std::cout << "Enter the prefix expression: ";
    std::cin >> prefix;

    std::cout << "The Postfix expression of the entered Prefix expression is: " << prefixToPostfix(prefix);

    return 0;
}