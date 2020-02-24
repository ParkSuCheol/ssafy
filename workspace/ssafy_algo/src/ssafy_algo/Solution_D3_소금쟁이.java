package ssafy_algo;

import java.util.Scanner;

public class Solution_D3_소금쟁이 {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] map;
	static int x, y, d, N;
	static int fx, fy;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int iT = 1; iT <= T; iT++) {
			N = sc.nextInt(); // 배열의 크기
			int M = sc.nextInt(); // 소금쟁이의 수
			map = new int[N][N];
			aa: for (int i = 0; i < M; i++) {
				y = sc.nextInt();
				x = sc.nextInt();
				int c = sc.nextInt();
				d = c - 1;
				if (map[y][x] == 1) {
					continue aa;
				}
				bb:for (int j = 3; j > 0; j--) {
						fy = y + (dy[d]*j);
						fx = x + (dx[d]*j);
						if (fy >= 0 && fy < N && fx >= 0 && fx < N && map[fy][fx] != 1) {
							map[y][x] = 0;
							map[fy][fx] = 1;
							y = fy;
							x = fx;
						} else {
							map[y][x] = 0;
							break bb;
						}
				}
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1)
						cnt++;
				}
			}
			System.out.println(cnt);
		}
	}


	public static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
