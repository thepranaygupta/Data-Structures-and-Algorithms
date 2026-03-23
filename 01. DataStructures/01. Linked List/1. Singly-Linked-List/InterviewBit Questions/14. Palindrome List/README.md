# Palindrome List

**Problem Link:** [Palindrome List - InterviewBit](https://www.interviewbit.com/problems/palindrome-list/)

**Solution Link:** [Palindrome List Solution](./solution%204.java)

---

## Problem Description

Given a singly linked list, determine if it is a **palindrome**.

A linked list is a palindrome if it reads the same forwards and backwards.

---

## Examples

**Example 1:**
Input:  1 -> 2 -> 1
Output: 1 (True - it is a palindrome)

**Example 2:**
Input:  1 -> 2 -> 3
Output: 0 (False - it is not a palindrome)

**Example 3:**
Input:  1 -> 2 -> 2 -> 1
Output: 1 (True - it is a palindrome)

---

## Approach

1. Find the middle of the linked list using slow and fast pointers
2. Reverse the second half of the linked list
3. Compare both halves node by node
4. If all nodes match return 1 (palindrome), else return 0

---

## Complexity

| Type  | Complexity |
|-------|-----------|
| Time  | O(N)      |
| Space | O(1)      |

---

## Tutorial Reference

[Check if Linked List is Palindrome - take U forward](https://youtu.be/-DtNInqFUXs)
```

---

**Commit message:**
```
Fix wrong README description for Palindrome List - Fixes #423
```

**PR Title:**
```
Fix wrong README description for Palindrome List - Fixes #423
```

**PR Description:**
```
Fixes #423

## Problem
README in folder 14. Palindrome List had the description 
of "Sort Binary Linked List" instead of "Palindrome List".

## Changes Made
- Removed wrong "Sort Binary Linked List" description
- Added correct Palindrome List problem description
- Added correct problem link
- Added examples with input/output
- Added approach explanation
- Added Time & Space complexity table
- Added tutorial reference link