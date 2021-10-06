#include <bits/stdc++.h>
using namespace std;

string PostfixToPrefix(string &postfix_expression)
{
    stack<string> expression_stack;
    for (int i = 0; i < postfix_expression.size(); i++)
    {
        char current_character = postfix_expression[i];
        string expression = "";
        if (isalnum(current_character)) // to check operand
            expression += current_character;

        else // else it is operator
        {
            string operator1 = expression_stack.top();
            expression_stack.pop();
            string operator2 = expression_stack.top();
            expression_stack.pop();
            expression += current_character + operator2 + operator1;
        }

        expression_stack.push(expression);
    }
    return expression_stack.top();
}

int main()
{
    string postfix_expression;
    cout << "Enter the Postfix Expression" << endl;
    cin >> postfix_expression;
    cout << "The Equivalent Prefix Expression for " << postfix_expression << " is : " << PostfixToPrefix(postfix_expression) << endl;
    return 0;
}
