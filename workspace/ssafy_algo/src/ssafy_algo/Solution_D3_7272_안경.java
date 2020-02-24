package ssafy_algo;

import java.util.Scanner;

public class Solution_D3_7272_안경 {
	static String A, B;
	static int res = 0;
	static int a = 3, b = 3;
	static char aa, bb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int iT = 1; iT <= T; iT++) {
			a = 3;
			b = 3;
			A = sc.next();
			B = sc.next();
			if (A.length() != B.length()) {
				res = 0; // DIFF 같지 않다
			} else {
				for (int i = 0; i < A.length(); i++) {
					a = 3;
					b = 3;
					aa = A.charAt(i);
					bb = B.charAt(i);
					if (aa == 'A' || aa == 'D' || aa == 'O' || aa == 'P' || aa == 'Q' || aa == 'R') {
						a = 1;
					} else if (aa == 'B') {
						a = 2;
					}
					if (bb == 'A' || bb == 'D' || bb == 'O' || bb == 'P' || bb == 'Q' || bb == 'R') {
						b = 1;
					} else if (bb == 'B') {
						b = 2;
					}
					if (a != b) {
						res = 0;
						break;
					} else if (a == b && i == A.length() - 1) {
						res = 1;
						break;
					}

				}
			}
			if (res == 1) {
				System.out.println("#" + iT + " " + "SAME");
			} else {
				System.out.println("#" + iT + " " + "DIFF");
			}

		}
	}

}
