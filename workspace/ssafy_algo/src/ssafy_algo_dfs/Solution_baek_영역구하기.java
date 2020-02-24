package ssafy_algo_dfs;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_baek_영역구하기 {
	static int N,M,K;
	static int[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][M];
		arr = new int[1000];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = 1;
			}
		}
		
		for (int i = 0; i < K; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			x2--;
			y2--;
			for (int j = y2; j >= y1; j--) {
				for (int j2 = x2; j2 >= x1; j2--) {
					map[j][j2] = 0;
				}
			}
		}
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					cnt++;
					dfs(i,j,cnt);
				}
			}
		}
		
		System.out.println(--cnt);
//		print();
		for (int i = 1; i <= cnt; i++) {
			int count = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(map[j][k] == i+1)
						count++;
				}
			}
			arr[i-1] = count;
		}
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=0)
				System.out.print(arr[i]+ " ");
		}
	}
	
	public static void dfs(int y, int x,int c) {
		map[y][x] = c;
		for (int d = 0; d < 4; d++) {
			int fy = y+dy[d];
			int fx = x+dx[d];
			if(safe(fy,fx) && map[fy][fx]==1 ) {
				map[fy][fx] = c;
				dfs(fy,fx,c);
			}
		}
	}
	
	
	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] +  " ");
			}
			System.out.println();
		}
	}
	
	public static boolean safe(int y, int x) {
		if(y >= 0 & y < N && x >= 0 && x <M)
			return true;
		else
			return false;
	}

}
