package ssafy_algo_dfs;

import java.util.Scanner;

public class Solution_baek_combidfs_매운맛 {
	
	static int N,M,max,cnt, k;
	static boolean[][] chk;
	static int[][] map;
	static int[][] arr;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static int[] zx;
	static int[] zy;
	static int[] z;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		map = new int[N][M];
		zx = new int[64];
		zy = new int[64];
		z = new int[3];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		k = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
					zx[k] = j;
					zy[k] = i;
					k++;
				}
			}
		}
		com(0,0);
		System.out.println(max);
		
	}
	
	public static void com(int start , int count) {
		cnt = 0;
		if(count == 3) {
			for (int i = 0; i < N; i++) {
				System.arraycopy(arr[i], 0, map[i], 0, M);
			}
			for (int i = 0; i < 3; i++) {
				int a = z[i];
				map[zy[a]][zx[a]] = 1;
			}
//			System.out.println(z[0] +"  "+ z[1] +"  "+ z[2]);
			chk = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 2 && !chk[i][j]) {
						dfs(i,j);
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 0) {
						cnt++;
					}
				}
			}
			if(max < cnt) 
				max = cnt;
			
			return;
		}
		for (int i = start; i < k; i++) {
			z[count] = i;
			com(i + 1, count + 1);
		}
	}
	
	public static void dfs(int y, int x) {
		for (int d = 0; d < 4; d++) {
			int fy = y+dy[d];
			int fx = x+dx[d];
			if(fy >= 0 && fy < N && fx >= 0 && fx < M && map[fy][fx] != 1 && !chk[fy][fx]) {
				chk[fy][fx] = true;
				map[fy][fx] = 2;
				dfs(fy,fx);
			}
		}
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
}
