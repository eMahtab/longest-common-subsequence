# Longest Common Subsequence

A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements. Longest common subsequence (LCS) of 2 sequences is a subsequence, with maximal length, which is common to both the sequences.

### Note : Subsequence doesn't need to be contiguous.

### Approach

#### Recursive

##### Base case
If any one of the string is empty then longest common subsequence will be of length 0. 
e.g. "" and "abc" the longest common substring will be of length 0, because there is nothing common, between these two strings. 

If str1[i] == str2[j], then move to next character for both the strings.
1 + longestCommonSubsequence(text1.substring(1), text2.substring(1))

```java
public class App {
	
	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
	}

	public static int longestCommonSubsequence(String text1, String text2) {
		if (text1.length() == 0 || text2.length() == 0) {
			return 0;
		}

		if (text1.charAt(0) == text2.charAt(0)) {
			return 1 + longestCommonSubsequence(text1.substring(1), text2.substring(1));
		} else {
			return Math.max(longestCommonSubsequence(text1.substring(1), text2),
					longestCommonSubsequence(text1, text2.substring(1)));
		}
   }
}

```

![When we can move to only right left](LCS-1.PNG?raw=true "Title")



![When we can move to only right left](LCS-2.PNG?raw=true "Title")
