package ssafy_algo;

import java.util.Scanner;

public class Solution_D3_안전기지 {
	static int[][] gi;
	static int res;
	static int[] dx = { 0, 0, 0, 0, -2, -1, 1, 2 }; //    좌우
	static int[] dy = { -2, -1, 1, 2, 0, 0, 0, 0 }; // 상하
	static int N;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int iT = 1; iT <= T; iT++) {
			int N = sc.nextInt();
			gi = new int[N][N]; // NxN 땅
			int B = sc.nextInt(); // B 개의 기지국 좌표
			for (int i = 0; i < B; i++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				
				for (int d = 0; d < 8; d++) {
					int fy = y+dy[d];
					int fx = x+dx[d];
					if(fy >= 0 && fx >= 0 && fy < N && fx < N) {
						gi[fy][fx]++;
					}
				}
				
			}
//			max(gi,N);
			max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (gi[i][j] > max)
						max = gi[i][j];
				}
			}
			res = max;
			
			System.out.println("#"+iT+" "+res);
			
			
		}

	}

	public static void max(int[][] gi, int N) {
		gi = new int[N][N];
		res = 0;
		max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (gi[i][j] > max)
					max = gi[i][j];
			}
		}
		res = max;
	}

}
