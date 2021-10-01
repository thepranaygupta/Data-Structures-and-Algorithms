class Solution:

    def reverseBetween(self, A, B, C):


        head = A
        r = C-B

        c=1
        prev =None
        curr = head
        while c < B:
            prev = curr
            curr = curr.next
            c += 1
        
        tail = prev
        next_tail = curr
        prev = None
        i=0
        while curr != None and i <= r:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
            i += 1
        if tail != None:
            tail.next = prev
        else:
            head = prev
            
        next_tail.next = curr
        
        return head
    