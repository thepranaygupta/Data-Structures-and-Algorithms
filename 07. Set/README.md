### Set is a data structure that is used as a collection of objects. Java supports it through its Java Collection library. There are several ways to implement a set and Java supports three different implementations along with useful operations like intersection between sets.


#### Learn about Set Data Structures in JAVA: [Video Reference](https://youtu.be/rS4VWfPUArY)
#### [Article 1](https://www.geeksforgeeks.org/set-in-java/) | [Article 2](https://iq.opengenus.org/set-in-java/)

<hr>

## HashSet vs TreeSet vs LinkedHashSet:
### [HashSet :](./MyHashSet.java)
- HashSet Use hashtable to store elements.
- Elements are not stored in sorted order(unsorted).
- add,remove,contain method have constant time complexitiy O(1).

### [TreeSet :](./MyTreeSet.java)
- TreeSet Use RedBlack tree to store elements.
- Elements are stored in sorted order (sorted).
- add, remove, and contains methods has time complexity of O(log (n)).

### [LinkedHashSet :](./MyLinkedHashSet.java)
- LinkedHashSet is between HashSet and TreeSet. It is implemented as a hash table with a slinked list running through it.
- The time complexity of basic methods is O(1).

#### HashSet has best-performing implementation of Set compare to LinkedHashSet and TreeSet .

### Problem Link: [GFG - Subarray with 0 sum](https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1#)
### Editorial Link: [Apni Kaksha - Anuj Kumar Sharma](https://youtu.be/PSpuM9cimxA)
### [Code](./SubarrayWith0Sum.java)
