#Method 1
#The original array
arr = [11, 22, 33, 44, 55]
print("Array is :",arr)
res = arr[::-1] #reversing using list slicing
print("Resultant new reversed array:",res)


#Method 2
#The original array
arr = [11, 22, 33, 44, 55]
print("Before reversal Array is :",arr)
#reversing using reverse() 
arr.reverse() 
print("After reversing Array:",arr)

#Method 3
#The original array
arr = [12, 34, 56, 78]
print("Original Array is :",arr)
#reversing using reversed()
result=list(reversed(arr))
print("Resultant new reversed Array:",result)

#Method 4
#Using reverse() Method
import array
#The original array
new_arr=array.array('i',[2,4,6,8,10,12])
print("Original Array is :",new_arr)
 
#reversing using reverse()
new_arr.reverse()
print("Reversed Array:",new_arr)
