class Solution:

    def addTwoNumbers(self, A, B):

        l1 = A

        l2 = B

        carry = 0

        cur = temp = ListNode(0)

        while l1 or l2 or carry:
            if l1:
                carry += l1.val
                l1 = l1.next
            if l2:
                carry += l2.val
                l2 = l2.next
            cur.next = ListNode(carry % 10)
            cur = cur.next

            carry = carry//10
        return temp.next
