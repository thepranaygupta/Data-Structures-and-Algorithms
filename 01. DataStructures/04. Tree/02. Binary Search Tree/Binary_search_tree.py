# Python3 implementation of tree using array

tree = [None] * 10
 
def root(k):
    if tree[0] != None:
        print("Tree already had root")
    else:
        tree[0] = k
 
 
def set_left(k, p):
    if tree[p] == None:
        print("Can't set child at", (p * 2) + 1, ", no parent found")
    else:
        tree[(p * 2) + 1] = k
 
 
def set_right(k, p):
    if tree[p] == None:
        print("Can't set child at", (p * 2) + 2, ", no parent found")
    else:
        tree[(p * 2) + 2] = k
 
 
def print_tree():
    for i in range(10):
        if tree[i] != None:
            print(tree[i], end="")
        else:
            print("-", end="")
    print()
 
 
# Driver Code
root('A')
set_right('C', 0)
set_left('D', 1)
set_right('E', 1)
set_right('F', 2)
print_tree()