# Trie Trees (PrefixTrees)
## Overview

Tries (prefix trees) are n-ary trees that store characters at each node. This design allows for efficient string lookup.

## More Details and Definitions
Example graph:
```
              (root)
            /   |   \
           M    L    A
          / \   |    |
         A   Y  I    *
         |   |  |
         N   *  E
         |      |
         Y      *
         |
         *      
```
- **Trie** - n-ary tree where each node contains a character, enabling quick prefix lookups
- **Null node/\* node** - terminating node to indicate completed words
  - MANY, MY, LIE, and A
- **Node** - each node in a trie can have 1 to {number of characters in the alphabet + 1} children (if null node is used).
 
#
## Time Complexity (worst case)
**Insertion**: O(k), where k = length of string

Must traverse all k characters, whether they exist or not. If they do not exist, creating a new node is constant. If they do exist, you must still traverse down. As such, O(k).

**Delete**: O(k), where k = length of string

Refer to geeksforgeeks.org link below.

**Lookup**: O(k), where k = length of string

Must traverse all k characters to determine if string exists, so O(k).

#
## Space Complexity
O(n * k), where n = number of words and k = (average?) length of each word.

#
## Distinguishing Features
- Char/string lookup. Good for prefix lookup or determining permutations of words
- Can be space inefficient compared to a set. If looking for "does this word exist", hashset is space more efficient. If looking for suggestions for a prefix, use trie.

#
## Strengths and Weaknesses

**Strengths**:
- _Can be_ space efficient, if many words start with similar patterns
- Efficient prefix queries. E.g. "how many words start with "choco", or "most likely letter after 'strawber'"

**Weaknesses**:
- _Usually_ space efficient, if many words start with different patterns
- Not standard, likely implement yourself

#
## Example uses
- String/word lookup
- List of valid words
- Phone number lookup
- Radix tree - trie but the unbranched chars are string. E.g. L-I-E above would be just be one node with contents LIE

#
## Resources
- https://www.interviewcake.com/concept/java/trie
- https://www.interviewcake.com/concept/python/tree
- https://stackoverflow.com/questions/13032116/trie-complexity-and-searching 
- https://www.geeksforgeeks.org/trie-delete/

#