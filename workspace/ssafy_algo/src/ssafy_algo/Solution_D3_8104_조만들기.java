package ssafy_algo;

import java.util.Scanner;

public class Solution_D3_8104_조만들기 {
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int iT = 1; iT <= T; iT++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			arr = new int[N][K];
			int cnt = 1;
			boolean chk = true;
			for (int i = 0; i < N; i++) {
				if (chk) {
					for (int j = 0; j < K; j++) {
						arr[i][j] = cnt;
						cnt++;
					}
					chk = false;
				}
				else {
					for (int j = K - 1; j >= 0; j--) {
						arr[i][j] = cnt;
						cnt++;
					}
					chk = true;
				}
			}
			System.out.print("#"+iT+" ");
			for (int i = 0; i < K; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum	+= arr[j][i]; 
				}
				System.out.print(sum+" ");
			}
			System.out.println();
		}
	}

}
