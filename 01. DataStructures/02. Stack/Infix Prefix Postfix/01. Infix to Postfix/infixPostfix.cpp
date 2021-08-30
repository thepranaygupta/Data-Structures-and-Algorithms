#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define FAST_IO ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);

bool isOp(char c) {
	if (c == '^' || c == '-' || c == '+' || c == '*' || c == '/' )
		return true;

	return false;
}

int precedence(char c) {
	if (c == '^')
		return 3;
	if (c == '*' || c == '/')
		return 2;
	if (c == '+' || c == '-')
		return 1;
	return -1;
}


string infixToPostfix(string& s, stack<char>& stck) {
	string postfix = "";
	for (int i = 0; i < (int)s.size(); ++i) {
		if ((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= 'A' && s[i] <= 'Z'))
			postfix += s[i];
		else if (s[i] == '(')
			stck.push(s[i]);
		else if (s[i] == ')') {
			while (stck.top() != '(' && !stck.empty()) {
				char temp = stck.top();
				postfix += temp;
				stck.pop();
			}
			if (stck.top() == '(')
				stck.pop();
		}
		else if (isOp(s[i])) {
			if (stck.empty())
				stck.push(s[i]);
			else {
				if (precedence(s[i]) > precedence(stck.top()))
					stck.push(s[i]);
				else if ((precedence(s[i]) == precedence(stck.top())) && s[i] == '^') {
					stck.push(s[i]);
				}
				else {
					while (!stck.empty() && (precedence(s[i]) <= precedence(stck.top()))) {
						char gg = stck.top();
						postfix += gg;
						stck.pop();
					}
					stck.push(s[i]);
				}
			}
		}
	}
	while (!stck.empty()) {

		postfix += stck.top();
		stck.pop();
	}
	return postfix;
}

void solve() {

	string infix; cin >> infix;
	string postfix = "";
	stack<char> stck;
	cout << infixToPostfix(infix, stck) << '\n';


}

int main() {
	FAST_IO
	int t = 1;
	cin >> t;

	while (t--) {
		solve();
	}
	return 0;
}
