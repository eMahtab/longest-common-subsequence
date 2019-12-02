# Longest Common Subsequence

A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements. Longest common subsequence (LCS) of 2 sequences is a subsequence, with maximal length, which is common to both the sequences.

### Note : Subsequence doesn't need to be contiguous.

### Approach

##### Base case
If any one of the string is empty then longest common subsequence will be of length 0.

e.g. "" and "abc" the longest common substring will be of length 0, because there is nothing common, between these two strings. 


![When we can move to only right left](LCS-1.PNG?raw=true "Title")



![When we can move to only right left](LCS-2.PNG?raw=true "Title")
