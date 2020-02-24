package ssafy_algo;

import java.util.Scanner;

public class Solution_D3_7087_제목붙이기 {
	static int[] alpha;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int iT = 1; iT <= T; iT++) {
			int N = sc.nextInt();
			alpha = new int[26];
			for (int i = 0; i < N; i++) {
				char a = sc.next().charAt(0);
				int num = a-'0';
				num = num - 17;
				if(alpha[num] == 0) {
					alpha[num] = 1;
				}
			}
			int cnt = 0;
			for (int i = 0; i < alpha.length; i++) {
				if(alpha[i] != 0)
					cnt++;
				else
					break;
			}
			System.out.println("#" + iT + " " + cnt);
		}
	}

}
