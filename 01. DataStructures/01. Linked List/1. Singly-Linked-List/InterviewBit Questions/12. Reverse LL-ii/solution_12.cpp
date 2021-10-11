/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
ListNode *Solution::reverseBetween(ListNode *A, int B, int C)
{
    if (B == C)
        return A;
    int cnt = 1;
    ListNode *start, *end, *pre, *head = A;
    while (cnt != B)
    {
        if (cnt + 1 == B)
            pre = head;
        head = head->next;
        cnt++;
    }
    start = head;
    while (cnt != C + 1)
    {
        head = head->next;
        cnt++;
    }
    end = head;
    ListNode *temp = NULL, *nex = start;
    head = start;
    while (start != end)
    {
        nex = start->next;
        start->next = temp;
        temp = start;
        start = nex;
    }
    if (B == 1)
        A = temp;
    else
        pre->next = temp;
    head->next = nex;
    return A;
}