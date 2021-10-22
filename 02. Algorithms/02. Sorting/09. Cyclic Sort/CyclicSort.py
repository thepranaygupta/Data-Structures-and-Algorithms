# Creating a cyclic sort function  
def cyclic_sort(a):
    i=0
    while(i<len(a)):
        if(a[i]!=i+1):
        
            index=a[i]-1
            x=a[i]
            a[i]=a[index];
            a[index]=x;
        
        else:
            i+=1
    return a
  
list1 = [4,5,6,2,1,7,3]  
print("The unsorted list is: ", list1)  
# Calling the cyclic sort function  
print("The sorted list is:   ", cyclic_sort(list1)) 
