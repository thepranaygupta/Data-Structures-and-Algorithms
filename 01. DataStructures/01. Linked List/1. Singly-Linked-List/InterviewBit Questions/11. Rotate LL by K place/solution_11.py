class Solution:

    def rotateRight(self, A, B):
        aa = []
        if A == None:
            return A
        while(A):
            aa.append(A.val)
            A = A.next
        bb = []
        bc = []
        B = (B % len(aa))
        i = len(aa)-B
        while(i < len(aa)):
            bb.append(aa[i])
            i += 1
        i = 0
        while(i < len(aa)-B):
            bb.append(aa[i])
            i += 1
        head = ListNode(bb[0])
        cur = head
        for i in range(1, len(bb)):
            cur.next = ListNode(bb[i])
            cur = cur.next
        return head
