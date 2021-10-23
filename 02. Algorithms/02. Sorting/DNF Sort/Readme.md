DUTCH NATIONAL FLAG(DNF Sort):
Dutch National Flag (DNF) - It is a programming problem proposed by Edsger Dijkstra. The flag of the Netherlands consists of three colors: white, red, and blue. The task is to randomly arrange balls of white, red, and blue in such a way that balls of the same color are placed together. For DNF (Dutch National Flag), we sort an array of 0, 1, and 2's in linear time that does not consume any extra space. We have to keep in mind that this algorithm can be implemented only on an array that has three unique elements.

ALGORITHM:

Take three-pointers, namely - low, mid, high.
We use low and mid pointers at the start, and the high pointer will point at the end of the given array.

CASES :

1. If array [mid] =0, then swap array [mid] with array [low] and increment both pointers once.
2. If array [mid] = 1, then no swapping is required. Increment mid pointer once.
3. If array [mid] = 2, then we swap array [mid] with array [high] and decrement the high pointer once.