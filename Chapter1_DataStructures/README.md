# Chapter 1: Data Structures
## Table of Contents
1. Arrays
2. Linked Lists
3. Stacks
4. Queues
5. Trees
    - Binary Trees
    - Binary Search Trees
    - Heaps and Priority Queues
    - Trie Trees (Prefix Trees)
6. Graphs
7. Sets
8. Hash Tables
#
## Time Complexity Summary
### Arrays
- Access: O(1)
- Insertion (at specific): O(n)
- Append (at end): O(1) (amortized)
- Deletion: O(n)
- Search: O(n)

### Linked lists
- Access/Search/Lookup: O(n)
- Insert (at specific): O(n)
- Append/Prepend (at beginning/end): O(1)
- Deletion: O(n)

### Stacks
- Access (at a given location)/Search: O(n)
- Push: O(1) (possibly amortized)
- Pop: O(1)
- Peek(): O(1)

### Queues
- Access (at a given location): O(n)
- Enqueue/Add: O(1)
- Dequeue/Remove: O(1)
- Peek: O(1)

### Trees
**Binary trees**:
- Insert: O(n)
- Delete: O(n)
- Lookup: O(n)

**Binary search trees**:
- Insert: O(n). O(log n) if balanced.
- Delete: O(n). O(log n) if balanced.
- Lookup: O(n). O(log n) if balanced.

**Red-black trees**:

**Tries/prefix tree**: 
- Insert: O(k), where k = length of string
- Delete: O(k), where k = length of string
- Lookup: O(k), where k = length of string

### Heaps and Priority Queues
### Graphs
### Hash Tables

#