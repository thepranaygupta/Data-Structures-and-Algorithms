# Creating a recursive function  
def Towerofhanoi(disks, source, auxiliary, target):  
    if(disks == 1):  
        print('Move disk 1 from rod {} to rod {}.'.format(source, target))  
        return  
    # function call itself  
    Towerofhanoi(disks - 1, source, target, auxiliary)  
    print('Move disk {} from rod {} to rod {}.'.format(disks, source, target))  
    Towerofhanoi(disks - 1, auxiliary, source, target)  
disks = int(input('Enter the number of disks: '))  
# We are referring source as A, auxiliary as B, and target as C  
Towerofhanoi(disks, 'A', 'B', 'C')  # Calling the function  
