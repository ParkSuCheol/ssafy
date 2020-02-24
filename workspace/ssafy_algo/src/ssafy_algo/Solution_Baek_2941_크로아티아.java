package ssafy_algo;

import java.util.Scanner;

public class Solution_Baek_2941_크로아티아 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] word = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		String input = sc.next().trim();
		int result = 0;
		int i;
		for (i = 0; i < word.length; i++) {
			if (input.contains(word[i])) {
				input = input.replaceAll(word[i], "*");
				//System.out.println(input);
			}
		}
		result = input.length();
		System.out.println(result);
	}

}
