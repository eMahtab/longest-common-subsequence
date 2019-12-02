# Longest Common Subsequence

A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements. Longest common subsequence (LCS) of 2 sequences is a subsequence, with maximal length, which is common to both the sequences.

### Note : Subsequence doesn't need to be contiguous.

## Solution
We can solve this problem either recursively or by using Dynamic Programming. 

### Recursive Approach

1. If any one of the string is empty then longest common subsequence will be of length 0. (Base case)
e.g. "" and "abc" the longest common substring will be of length 0, because there is nothing common, between these two strings. 

2. If str1[i] == str2[j], then move to next character for both the strings (str1 and str2)

3. If str1[i] != str2[j], then try both the cases and return the one which results in longest common subsequence. 
	1. Move to the next character in str1 
	2. Move to the next character in str2


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

The recursive approach solves the same subproblem everytime, we can improve the runtime by using the Dynamic Programming approach.

### Dynamic Programming - Bottom Up (Tabulation) Approach
For example lets find the longest common subsequence for strings, "abc" and "cab". 
Approach: We start filling the dpTable, row by row, and we fill all the columns in a single row, before moving to next row. 
By doing this we are solving the subproblems, which will help us, to get to the result of our actual problem.

Now while filling the cell dpTable[i][j], there can be two cases
1. str1[i] == str2[j], in this case dpTable[i][j] = dpTable[i - 1][j - 1] + 1
2. str1[i] != str2[j], in this case dpTable[i][j] = Math.max(dpTable[i - 1][j], dpTable[i][j - 1])

### Case 1 : When str1[i] == str2[j]
![When we can move to only right left](LCS-1.PNG?raw=true "Title")


### Case 2 : When str1[i] != str2[j]
![When we can move to only right left](LCS-2.PNG?raw=true "Title")

```java
public class App {
	
	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("abc", "cab"));
	}

	public static int longestCommonSubsequence(String text1, String text2) {

		int rows = text1.length();
		int columns = text2.length();
		
		if(rows == 0 || columns == 0)
	           return 0;
		
		int[][] dpTable = new int[rows+1][columns+1];
		for(int i = 1; i <= rows; i++) {
			for(int j = 1; j <= columns; j++) {
				if(text1.charAt(i-1) == text2.charAt(j-1)) {
					dpTable[i][j] = dpTable[i-1][j-1] + 1;
				} else {
					dpTable[i][j] = Math.max(dpTable[i-1][j], dpTable[i][j-1]);
				}
			}
		}

		System.out.println(subSequence(text1, text2, dpTable));
		return dpTable[rows][columns];
	}
	
	public static StringBuilder subSequence(String text1, String text2, int[][] dpTable) {
		String subsequence = "";
		int row = text1.length();
		int column = text2.length();
		while(row > 0 && column > 0 && dpTable[row][column] != 0) {
			if(dpTable[row][column] == dpTable[row - 1][column]) {
				row = row - 1;
			} else if(dpTable[row][column] == dpTable[row][column-1]) {
				column = column -1;
			} else {
				subsequence += text1.charAt(row-1);
				row = row - 1;
				column = column - 1; 
			}
		}
		StringBuilder sb = new StringBuilder(subsequence);
		return  sb.reverse();
	}

}
```
