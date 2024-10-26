# Segment Tree Data Structure in Python

## What is a Segment Tree?
A segment tree is a data structure that allows efficient querying and updating of elements over an array, especially when dealing with ranges. It is particularly useful for scenarios like finding minimum, maximum, sum, or any other associative operation over a range of elements in an array.

### Structure
1. **Leaf Nodes**: Each leaf in the segment tree corresponds to an element of the array.
2. **Internal Nodes**: Each internal node represents an aggregation (like sum, min, max) of a range of elements, determined by combining the results from its child nodes.

### Basic Operations

1. **Building the Tree**: 
   Constructs the segment tree based on the array, usually in `O(n log n)` time.
   
2. **Range Query**: 
   Retrieves the aggregate value (sum, min, max) over a specified range in `O(log n)` time.
   
3. **Update**: 
   Updates an element in the array and adjusts the tree to maintain accuracy, also in `O(log n)` time.

---

## Explanation

### Initialization

The `__init__` method takes an array as input and initializes the segment tree. During this step:
- It builds the tree by recursively dividing the array.
- Aggregated values (like sums or minimums) are stored at each node.

### Build Function

A recursive build function is used to initialize each node of the segment tree:
- It divides the range until it reaches single elements (leaf nodes).
- Then, it aggregates these values back up to populate the entire tree.

### Query Function

This function allows querying a specific range, like finding the sum or minimum over a range `[L, R]`:
- It navigates through the tree to cover only the relevant parts, often by recursively checking the left and right children.
- Results from nodes that completely or partially overlap with the queried range are aggregated.

### Update Function

The update function is used to change an element’s value at a particular index in the original array:
- After updating the value, it adjusts the segment tree nodes to reflect the change.
- It works back up the tree so that all relevant nodes are updated accordingly.

---

## Practice Problems

- **LeetCode Problem**: [Range Sum Query - Mutable](https://leetcode.com/problems/range-sum-query-mutable/)

---

This README provides an overview of the Segment Tree data structure, along with basic operations and explanation of implementation details.
