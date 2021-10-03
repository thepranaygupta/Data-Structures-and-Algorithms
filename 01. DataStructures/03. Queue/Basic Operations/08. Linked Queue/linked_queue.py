"""
Queue ADT:
- Queue is a linear data structure in which insertion and deletion
performed based on FIFO principle.
- FIFO: First In First Out.
Linked Queue:
- Queue implemented by linked list concept is known as Linked Queue.
- It reduces the complexity in array based queue.
- It manages every enqueue() and dequeue() operation run in O(1) time.
Implementation:
- In our implementation we use head and trail variables that respectively
stores header and trailer of linked queue.
- It is used for easy enqueue() and dequeue() operation.
- There is no upper limit condition, because of linked structure.
Contents:
- Class: LinkedQueue: Manages the queue.
- Methods:
    - clear(): Clears the queue.
    - dequeue(): Deletes first element of the queue and returns it. 
    - enqueue(): Adds the given element at the end of queue.
    - extend(): Extends the queue with given iterable elements.
    - is_empty(): Tells the queue is empty or not.
    - peek(): Return the first element without deleting it.
    - reverse(): Reverses the queue.
:URL: https://github.com/prathimacode-hub/PyAlgo-Tree/tree/main/Queues/Linked%20Queue/linked_queue.py
:Author: NanthaKumar <nknanthakumar13@gmail.com>
:Contact: https://github.com/nknantha
:Date: 2021-07-25
"""


class LinkedQueue:
    """
    LinkedQueue class, manages the Queue.
    Class:
        _Node   Protected class for node.
    Attributes:
        _head   Points the start of the queue.
        _trail  Points the end of queue.
        _size   Stores the size of queue.
    """

    # ---------------------------------NODE-CLASS--------------------------------- #
    class _Node:
        """
        Non-Public class for node.
        Attributes:
            data  Stores node's data.
            next  Points the next node.
        """

        # Slots for _Node class.
        __slots__ = 'data', 'next'

        def __init__(self, data, next):
            """
            Creates a Node instance.
            :param object data: Stores given object.
            :param _Node next: Stores the next node reference.
            """
            # Initializing node attributes.
            self.data = data
            self.next = next

    # -------------------------------END-NODE-CLASS------------------------------- #

    # Slots for LinkedQueue.
    __slots__ = '_head', '_trail', '_size'

    def __init__(self, iterable=()):
        """
        Creates a LinkedQueue instance.
        :param iterable: takes a iterable object.
        """
        # Initializing LinkedQueue attributes.
        self._head = self._trail = None
        self._size = 0

        # Adding iterable elements to queue.
        self.extend(iterable)

    def __iter__(self):
        """
        Yields the element in the queue.
        :return: yields the element in the queue.
        """
        cursor = self._head
        while cursor:
            yield cursor.data
            cursor = cursor.next

    def __len__(self):
        """
        Returns the length of the queue.
        :return: the length of the queue.
        :rtype: int
        """
        return self._size

    def __repr__(self):
        """
        Returns the representation of queue.
        :return: the representation of queue.
        :rtype: str
        """
        return f"LinkedQueue([{', '.join(repr(el) for el in self)}])"

    def __str__(self):
        """
        Returns the string representation of queue.
        :return: the string representation of queue.
        :rtype: str
        """
        suffix = ' - ' * bool(self._size) + 'END'
        return f"LinkedQueue: START - {' - '.join(repr(el) for el in self)}{suffix}"

    def clear(self):
        """
        Clears the queue.
        """
        # Pointing head and trail to None.
        self._head = self._trail = None

        # Make size to 0.
        self._size = 0

    def dequeue(self):
        """
        Deletes the first element in the queue and returns it.
        :return: the first element in the queue.
        """
        # Checking for underflow.
        if self.is_empty():
            raise IndexError('Queue is empty')

        # Preserving data and deleting header node.
        data = self._head.data
        self._head = self._head.next
        self._size -= 1

        # Returning the preserved data.
        return data

    def enqueue(self, element):
        """
        Adds the given element in queue.
        :param element: takes an object.
        """
        # Creating new node and storing given element in it.
        new_node = self._Node(element, None)

        # If queue is empty we mark head and trail as new node.
        # Else we just add the new node at trail's next and move the
        # trail to the new node.
        if self._size < 1:
            self._head = self._trail = new_node
        else:
            self._trail.next = new_node
            self._trail = new_node

        # Increasing the size.
        self._size += 1

    def extend(self, iterable):
        """
        Extends the queue with given iterable elements.
        :param iterable: takes an iterable object.
        """
        for element in iterable:
            self.enqueue(element)

    def is_empty(self):
        """
        Gives the queue is empty or not.
        :return: the queue is empty or not.
        :rtype: bool
        """
        return self._size < 1

    def peek(self):
        """
        Returns the first element in the queue without removing it.
        :return: the first element in the queue.
        """
        # Checking for underflow.
        if self.is_empty():
            raise IndexError('Queue is empty')
        else:
            return self._head.data

    def reverse(self):
        """
        Reverses the queue in place.
        """
        # Initially marking prev_node to None and curr_node to head.
        prev_node = None
        curr_node = self._head

        # Walking through the queue.
        while curr_node:
            # Preserving the next node of curr_node.
            next_node = curr_node.next

            # Rotating the node by changing the curr_node's next points
            # to prev_node.
            curr_node.next = prev_node

            # Marking curr_node as prev_node and taking the curr_node as
            # next_node.
            prev_node = curr_node
            curr_node = next_node

        # Swapping head and tails.
        self._trail = self._head
        self._head = prev_node


# ----------------------------------DRIVER-CODE----------------------------------- #
if __name__ == '__main__':
    # Creating a Queue with range of 5.
    print('Creating queue with range of 5,')
    q = LinkedQueue(range(5))
    print(q)

    # Printing represent format of queue.
    print(f"\nRepresent Format: \n{repr(q)}")

    # Enqueueing elements.
    print('\nQueueing some elements,')
    q.enqueue(True)
    q.enqueue(2.0)
    print(q)

    # Peeking element.
    print(f'\nPeek element, {q.peek()}')

    # Reversing queue.
    q.reverse()
    print('\nAfter reversing,')
    print(q)

    # Dequeueing elements.
    print('\nDequeueing some elements,')
    print(q.dequeue())
    print(q.dequeue())
    print(q.dequeue())
    print(q)

    # Checking size and empty.
    print('\nChecking size and empty,')
    print(f'Size: {len(q)}, Empty: {q.is_empty()}')

    # Clearing queue.
    q.clear()
    print('\nAfter clearing the queue,')
    print(f'Size: {len(q)}, Empty: {q.is_empty()}')
    print(q)

# ------------------------------------EXAMPLE------------------------------------- #
'''
>>> from linked_queue import *
>>> q = LinkedQueue(range(1,6))
>>> q
LinkedQueue([1, 2, 3, 4, 5])
>>> print(q)
LinkedQueue: START - 1 - 2 - 3 - 4 - 5 - END
>>> q.reverse()
>>> q
LinkedQueue([5, 4, 3, 2, 1])
>>> len(q)
5
>>> q.enqueue(2.0)
>>> q
LinkedQueue([5, 4, 3, 2, 1, 2.0])
>>> q.dequeue()
5
>>> q
LinkedQueue([4, 3, 2, 1, 2.0])
>>> q.clear()
>>> q
LinkedQueue([])
>>> len(q)
0
'''
'''
Complexity:
    +------------+-----------------+
    | Operation  | Time Complexity |
    +------------+-----------------+
    |  clear()   |       O(1)      |
    | dequeue()  |       O(1)      |
    | enqueue()  |       O(1)      |
    |  extend()  |       O(K)      |
    | is_empty() |       O(1)      |
    |   peek()   |       O(1)      |
    | reverse()  |       O(N)      |
    +------------+-----------------+
'''
