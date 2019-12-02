package net.mahtabalam.v2;

import java.util.Arrays;

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
		for(int[] r : dpTable) {
			System.out.println(Arrays.toString(r));
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
