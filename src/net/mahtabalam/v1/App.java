package net.mahtabalam.v1;

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
