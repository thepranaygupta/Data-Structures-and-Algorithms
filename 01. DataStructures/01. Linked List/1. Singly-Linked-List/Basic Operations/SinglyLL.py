"""
A simple Python program to introduce a linked list
"""

from __future__ import annotations
from typing import Any


class Node:
    def __init__(self, data: Any) -> None:
        self.data = data  # Assign data
        self.next: Node | None = None  # Initialize next as None


# Linked List class contains a Node object
class LinkedList:
    def __init__(self) -> None:
        self.head: Node | None = None

    def __str__(self) -> str:
        res = ""

        curr = self.head
        while curr is not None:
            res += f"{curr.data} "
            curr = curr.next

        return res

    def __len__(self) -> int:
        counter = 0
        if self.is_empty():
            return counter

        curr = self.head
        while curr is not None:
            counter += 1
            curr = curr.next

        return counter

    def is_empty(self) -> bool:
        return self.head is None

    def append(self, data: Any) -> None:
        """
        Append node at end of linked list
        :param data: data of node to append
        :return: None
        >>> llist = LinkedList()
        >>> llist.append(1)
        >>> llist.append(2)
        >>> llist.append(3)
        >>> print(llist)
        1 2 3
        """

        if self.is_empty():
            self.head = Node(data)
        else:
            curr = self.head
            while curr.next is not None:
                curr = curr.next

            new_node = Node(data)
            curr.next = new_node

    def push(self, data: Any) -> None:
        """
        Push node to front of linked list
        :param data: data of node to push
        :return: None
        >>> llist = LinkedList()
        >>> llist.push(1)
        >>> llist.push(2)
        >>> llist.push(3)
        >>> print(llist)
        >>> 3 2 1
        """

        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node

    def insert(self, data: Any, index: int) -> None:
        """
        Insert a new node at a certain index
        :param data: data to be stored inside new node
        :param index: position to insert new node
        :return: None
        >>> llist = LinkedList()
        >>> llist.append(1)
        >>> llist.append(2)
        >>> llist.append(3)
        >>> llist.append(4)
        >>> llist.insert(4, 2)
        >>> llist.insert(5, 1)
        >>> print(llist)
        1 5 4 3 4
        """

        if index < 0:
            raise IndexError
        elif index == 0 or self.is_empty():
            self.push(data)
            return

        curr = self.head
        for _ in range(0, index - 1):
            curr = curr.next

            if curr is None or curr.next is None:
                raise IndexError

        new_node = Node(data)
        new_node.next = curr.next
        curr.next = new_node

    def remove_tail(self) -> Any:
        """
        Remove last node of linked list
        :return: data of removed node
        >>> llist = LinkedList()
        >>> llist.append(1)
        >>> llist.append(2)
        >>> llist.remove_tail()
        >>> print(llist)
        1
        """

        if self.is_empty():
            raise "Remove from empty list"

        if self.head.next is None:
            data = self.head.data
            self.head = None
        else:
            curr = self.head
            while curr.next.next is not None:
                curr = curr.next

            data = curr.next.data
            curr.next = None

        return data

    def remove_head(self) -> Any:
        """
        Remove first node of linked list
        :return: data of removed node
        >>> llist = LinkedList()
        >>> llist.append(1)
        >>> llist.append(2)
        >>> llist.remove_head()
        >>> print(llist)
        2
        """

        if self.is_empty():
            raise "Remove from empty list"

        if self.head.next is None:
            return self.remove_tail()

        data = self.head.data
        self.head = self.head.next

        return data

    def delete(self, index: int) -> Any:
        """
        Delete the node at a certain index
        :param index: index of node to be deleted
        :return: data stored in deleted node
        >>> llist = LinkedList()
        >>> llist.append(1)
        >>> llist.append(2)
        >>> llist.append(3)
        >>> llist.delete(1)
        >>> print(llist)
        1 3
        """

        if index < 0 or self.is_empty():
            raise IndexError
        elif index == 0:
            return self.remove_head()

        curr = self.head
        for _ in range(0, index - 1):
            curr = curr.next

            if curr is None or curr.next is None:
                raise IndexError

        data = curr.next.data
        curr.next = curr.next.next

        return data

    def get(self, index: int) -> Any:
        """
        Return data of node at specified index
        :param index: index of node to get
        :return: data of node at index
        >>> llist = LinkedList()
        >>> llist.append(1)
        >>> llist.append(2)
        >>> llist.append(3)
        >>> print(llist.get(1))
        2
        """

        if index < 0 or self.is_empty():
            raise IndexError
        elif index == 0:
            return self.head.data

        curr = self.head
        for _ in range(0, index):
            curr = curr.next

            if curr is None:
                raise IndexError

        return curr.data


# Code execution starts here
if __name__ == '__main__':
    # Start with the empty list
    llist = LinkedList()

    llist.append(1)
    llist.append(2)
    llist.append(3)
    llist.append(4)
    llist.append(5)

    # The linked list now looks as follows:
    # head (1) -> (2) -> (3) -> (4) -> (5) -> None
    print(llist)

    # Perform some other basic operations
    llist.push(6)
    print(llist)

    llist.remove_head()
    llist.remove_tail()
    llist.delete(2)
    print(llist)

    llist.insert(7, 1)
    print(llist)

    print(llist.get(2))
