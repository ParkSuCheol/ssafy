package ssafy_algo_dfs;

import java.util.Scanner;

public class Solution_D4_7733_치즈도둑 {
	static int[][] map;
	static boolean[][] chk;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int cnt, N, res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int iT = 1; iT <= T; iT++) {
			N = sc.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int max = Integer.MIN_VALUE;
			for (int k = 0; k < 100; k++) {
				chk = new boolean[N][N];
				cnt = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map[i][j] == k) {
							map[i][j] = 0;
						}
					}
				}
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(map[i][j] != 0 && !chk[i][j]) {
							chk[i][j] = true;
							dfs(i,j);
							cnt++;
//							print();
//							System.out.println("k : "+ k + "   cnt : " + cnt +"  max : "+max);
//							System.out.println("=========================");
						}
					}
				}
				if(max < cnt)
					max = cnt;
			}
			System.out.println("#"+iT+" "+max);
		}

	}

	public static void dfs(int y, int x) {
		for (int d = 0; d < 4; d++) {
			int fy = y + dy[d];
			int fx = x + dx[d];
			if (fy >= 0 && fy < N && fx >= 0 && fx < N && !chk[fy][fx] && map[fy][fx] != 0) {
				chk[fy][fx] = true;
				dfs(fy, fx);
			}
		}
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
