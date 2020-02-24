package ssafy_algo;

import java.util.Scanner;

public class Solution_D3_저수지 {
	static char[][] cr;
	static int[][] inr;
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int fx,fy;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int iT = 1; iT <= T; iT++) {
			int N = sc.nextInt();
			cr = new char[N][N];
			inr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cr[i][j] = sc.next().charAt(0);
					if (cr[i][j] == 'G')
						inr[i][j] = 0;
					else
						inr[i][j] = 1;
				}
			}
			int d = 0;
			int sum = 0;
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					sum = 0;
					for (d = 0; d < 8; d++) {
						fx = x + dx[d];
						fy = y + dy[d];						
						if(fx >= 0 && fx < N && fy >= 0 && fy < N && inr[y][x] == 1) {
							if(cr[fy][fx] == 'W')
								sum++;
						}
					}
					if(sum == 0)
						sum = 1;
					else {
						inr[y][x] = sum;
					}
				}
			}
			int Max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (inr[i][j] > Max)
						Max = inr[i][j];
				}
			}
			System.out.println("#"+iT+" " +Max);
			
		}
	}

}
