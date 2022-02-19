### Problem 
Given a list of words ("review keywords") and a customer query string, output maximum of three suggestions made by the system as the customer types each character

https://leetcode.com/discuss/interview-question/850261/amazon-customer-reviews-question

Approach: Build a trie (prefix tree). This indexes each possible string into trees of individual letters. Each node has 1) a letter, 2) child nodes, and 3) list of words coming through that letter. When looking up each substring, iterate down in trie. Once the substring/final letter is found, return the top three (max) words. 

Note: this approach could be improved by not iterating the trie for each substring. Instead, iterate down, and at each level, add the top three (max) words into an array. Then you'd only traverse the tree once, instead of substring.length times.