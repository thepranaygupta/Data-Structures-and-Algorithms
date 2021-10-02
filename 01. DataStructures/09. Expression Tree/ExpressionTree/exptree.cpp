#include <bits/stdc++.h>
using namespace std;
typedef struct TreeNode
{
    char info;
    TreeNode *left, *right;
} TreeNode;
typedef struct TreeNode *ExpTree;
ExpTree Create_Node(int info);
ExpTree constructTree(ExpTree T, char postfix[]);
int getPriority(char ch);
void Convert_In_To_Post(string infix, char postfix[]);

void show_node(ExpTree T);
void preorder(ExpTree T);
void postorder(ExpTree T);
void display(ExpTree tree, char postfix[]);

void display(ExpTree tree, char postfix[])
{

    cout << "\n PreOrder Traverse  (Parent, Left, Right) Postfix Expression :  ";
    preorder(tree);

    cout << "\n PostOrder Traverse (Left, Right, Parent) Prefix Expression  : ";
    postorder(tree);
}

bool isDigit(char ch)
{
    if (ch > 47 && ch < 57)
        return true;
    return false;
}
bool isOperator(char ch)
{
    if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%' || ch == '^')
        return true;
    return false;
}
ExpTree Create_Node(int info)
{
    TreeNode *temp;
    temp = (TreeNode *)malloc(sizeof(TreeNode));
    if (temp == NULL)
    {
        cout << "Out of space!\n";
        return (temp);
    }
    temp->left = NULL;
    temp->right = NULL;
    temp->info = info;
    return temp;
};

ExpTree constructTree(ExpTree tree, char postfix[])
{
    int i = 0;
    stack<TreeNode *> st;
    TreeNode *temp_tree1;
    TreeNode *temp_tree2;
    while (postfix[i] != '\0')
    {
        if (!(postfix[i] == '+' || postfix[i] == '-' || postfix[i] == '*' || postfix[i] == '/' || postfix[i] == '%' || postfix[i] == '^'))
        {
            tree = Create_Node(postfix[i]);
            st.push(tree);
        }
        else
        {
            tree = Create_Node(postfix[i]);
            temp_tree1 = st.top();
            st.pop();
            temp_tree2 = st.top();
            st.pop();
            tree->right = temp_tree1;
            tree->left = temp_tree2;
            st.push(tree);
        }
        i++;
    }
    return tree;
}

void show_node(ExpTree T)
{
    cout << T->info << " ";
}
void preorder(ExpTree T)
{
    if (T != NULL)
    {
        show_node(T);
        preorder(T->left);
        preorder(T->right);
    }
}
void postorder(ExpTree T)
{
    if (T != NULL)
    {
        postorder(T->left);
        postorder(T->right);
        show_node(T);
    }
}

int getPriority(char ch)
{
    switch (ch)
    {
    case '^':
        return 4;
    case '%':
        return 3;
    case '/':
    case '*':
        return 2;
    case '+':
    case '-':
        return 1;
    default:
        return 0;
    }
}
void Convert_In_To_Post(string infix, char postfix[])
{
    unsigned int counter1 = 0;
    stack<char> st;
    int postCount = 0;
    char element;
    while (counter1 < infix.length())
    {
        element = infix[counter1];
        if (element == '(')
        {
            st.push(element);
            counter1++;
            continue;
        }
        if (element == ')')
        {
            while (!st.empty() && st.top() != '(')
            {
                postfix[postCount++] = st.top();
                st.pop();
            }
            if (!st.empty())
            {
                st.pop();
            }
            counter1++;
            continue;
        }

        if (getPriority(element) == 0)
        {
            postfix[postCount++] = element;
        }
        else
        {
            if (st.empty())
            {
                st.push(element);
            }
            else
            {
                while (!st.empty() && st.top() != '(' &&
                       getPriority(element) <= getPriority(st.top()))
                {
                    postfix[postCount++] = st.top();
                    st.pop();
                }
                st.push(element);
            }
        }
        counter1++;
    }

    while (!st.empty())
    {
        postfix[postCount++] = st.top();
        st.pop();
    }
    postfix[postCount] = '\0';
}

int main()
{
    cout << "\n Enter Expression : ";
    string infix;
    cin >> infix;
    char *postfix = (char *)malloc(sizeof(char) * infix.length());
    Convert_In_To_Post(infix, postfix);
    ExpTree tree1 = NULL;
    tree1 = constructTree(tree1, postfix);
    display(tree1, postfix);
    return 0;
}