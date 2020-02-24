package ssafy_algo;

import java.util.Scanner;

public class practice {
	static int[][] ar;
	static int[] chk;
	static boolean ck;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int iT = 1; iT <= T; iT++) {
			ck = true;
			ar = new int[9][9];
			chk = new int[11];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					ar[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < 9; i++) {
				chk = new int[11];
				for (int j = 0; j < 9; j++) {
					chk[ar[i][j]]++;
				}
				for (int j = 0; j < 9; j++) {
					if (chk[j] >= 2) {
						ck = false;
						break;
					}
				}
			}

			if (ck) {
				for (int i = 0; i < 9; i++) {
					chk = new int[11];
					for (int j = 0; j < 9; j++) {
						chk[ar[j][i]]++;
					}
					for (int j = 0; j < 9; j++) {
						if (chk[j] >= 2) {
							ck = false;
							break;
						}
					}
				}
				
				if (ck) {
					for (int i = 0; i < 9; i+=3) {
						chk = new int[11];
						for (int j = i; j < i + 3; j++) {
							for (int j2 = 0; j2 < 3; j2++) {
								chk[ar[j][j2]]++;
							}
						}
						for (int j = 0; j < 9; j++) {
							if (chk[j] >= 2) {
								ck = false;
								break;
							}
						}
						
						chk = new int[11];
						for (int j = i; j < i + 3; j++) {
							for (int j2 = 3; j2 < 6; j2++) {
								chk[ar[j][j2]]++;
							}
						}
						for (int j = 0; j < 9; j++) {
							if (chk[j] >= 2) {
								ck = false;
								break;
							}
						}
						chk = new int[11];
						for (int j = i; j < i + 3; j++) {
							for (int j2 = 6; j2 < 9; j2++) {
								chk[ar[j][j2]]++;
							}
						}
						for (int j = 0; j < 9; j++) {
							if (chk[j] >= 2) {
								ck = false;
								break;
							}
						}
					
					}
				}

			}
			System.out.print("#"+iT+" ");
			if (ck)
				System.out.println("1");
			else
				System.out.println("0");

		}

	}

}
