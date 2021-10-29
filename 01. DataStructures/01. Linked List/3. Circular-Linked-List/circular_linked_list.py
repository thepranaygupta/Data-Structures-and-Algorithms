  
class Node:    
  def __init__(self,data):    
    self.data = data;    
    self.next = None;    
     
class CreateList:    
  
  def __init__(self):    
    self.head = Node(None);    
    self.tail = Node(None);    
    self.head.next = self.tail;    
    self.tail.next = self.head;    
        
 
  def add(self,data):    
    newNode = Node(data);    
        
    if self.head.data is None:     
      self.head = newNode;    
      self.tail = newNode;    
      newNode.next = self.head;    
    else:    
          
      self.tail.next = newNode;    
        
      self.tail = newNode;    
         
      self.tail.next = self.head;    
     
    
  def display(self):    
    current = self.head;    
    if self.head is None:    
      print("List is empty");    
      return;    
    else:    
        print("Nodes of the circular linked list: ");    
           
        print(current.data),    
        while(current.next != self.head):    
            current = current.next;    
            print(current.data),    
     
     
class CircularLinkedList:    
  cl = CreateList();    
 
  cl.add(1);    
  cl.add(2);    
  cl.add(3);    
  cl.add(4);    
  #Displays all the nodes present in the list    
  cl.display();    