## A Python Program to implement SingleLinkedList

## Creation of Node Class to create node object ## 

class Node:
    def __init__(self,value=None):
        self.value = value
        self.next = None

## SingleLinkedList Class
class singleLinkList:
 
    def __init__(self):
        self.head=None
        self.tail=None
     
    ## To Iterate through nodes and print node 
    def __iter__(self):
        node = self.head
        while node:
            yield node
            node = node.next
    
          
    ### Inserting Function ###
    def insertNode(self,value,location):
        newNode = Node(value)
        if self.head is None:
            self.head = newNode
            self.tail = newNode
        else:
             if location == 0 :   ## location 0 means beginning position
                 newNode.next = self.head
                 self.head = newNode
             elif location == 1 : ## location 1 means last position
                 newNode.next = None
                 self.tail.next = newNode
                 self.tail = newNode
             else :
                 currentNode = self.head
                 index = 0 
                 while index < location-1:
                     currentNode = currentNode.next
                     index+=1
                 nextNode = currentNode.next
                 currentNode.next = newNode
                 newNode.next = nextNode
                 
                 
    ## Looping thorugh nodes 
    def traverse(self):
        if self.head is None:
            print('Single Linked List does not exist')
        else:
            node = self.head
            while node is not None:
                print(node.value)
                node=node.next
              
              
    ## Search a Node value exist or not         
    def search(self,value):
        node = self.head
        if self.head is None:
            print('No nodes present in list')
        else:
            node = self.head
            while node is not None:
                if node.value==value:
                    return f"{value} is exist in list"
                node=node.next
            return f"{value} Value does not exist"
    
    ## Delete the node from end or beginning or after a node 
    def delete(self,location):
        if self.head == None:
            print('List does not exist')
        else:
            if location == 0 :
                if self.head == self.tail:
                   self.head=None
                   self.tail=None
                else:
                    self.head=self.head.next
            elif location == 1 :
                  if self.head == self.tail:
                   self.head=None
                   self.tail=None
                  else:
                    node = self.head
                    while node is not None:
                        if node.next == self.tail:
                            break
                        node=node.next
                        node.next=None
                        self.tail=node
            else:
                currentNode = self.head
                index=0
                while index < location-1:
                    currentNode = currentNode.next
                    index+=1
                nextNode = currentNode.next
                currentNode.next=nextNode.next


                        









        


## Initialising the SingleLinkedList Object 
sll = singleLinkList()

## Through list object we are performing various functions using methods in class
## Node Object Initailised through methods in SingleLinkedList Class 
sll.insertNode(1,0)
sll.insertNode(5,1)
sll.insertNode(3,2)
sll.insertNode(9,3)
sll.insertNode(4,4)
sll.traverse()
print(sll.search(5))
print(sll.search(9))
print(sll.search(8))
sll.delete(3)
## __iter__ helps to retrive list of nodes in following way
print([node.value for node in sll])
