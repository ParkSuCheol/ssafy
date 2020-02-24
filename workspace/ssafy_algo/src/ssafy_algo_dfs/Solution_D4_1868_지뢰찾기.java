package ssafy_algo_dfs;

import java.util.Scanner;

public class Solution_D4_1868_지뢰찾기 {
	static int N, cnt,res;
	static int[][] map;
	static char[][] arr;
	static boolean[][] chk;
	static int[] dx = {0,1,1,1,0,-1,-1,-1};
	static int[] dy = {-1,-1,0,1,1,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int iT = 1; iT <= T; iT++) {
			N = sc.nextInt();
			map = new int[N][N];
			arr = new char[N][N];
			chk = new boolean[N][N];
			res = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.next().toCharArray();
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					boolean aa = true;
					if(arr[i][j] == '*')
						continue;
					for (int d = 0; d < 8; d++) {
						int fy = i+dy[d];
						int fx = j+dx[d];
						if(safe(fy,fx) && arr[fy][fx] == '*' && !chk[fy][fx]) {
							aa = false;
							break;
						}
					}
					if(aa && !chk[i][j]) {
						dfs(i,j);
						res++;
//						System.out.println("=====================");
//						print();
//						System.out.println(res);
					}

				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j] == '.' && !chk[i][j] && map[i][j] == 0) {
//						print();
//						System.out.println(res);
//						System.out.println("========================");
						dfs(i,j);
						res++;
					}
				}
			}
			
//			print();
			System.out.println("#"+iT+" "+res);
		}
	}
	
	public static void dfs(int y, int x) {
		boolean a = true;
		int z = 0;
		for (int d = 0; d < 8; d++) {
			int fy = y+dy[d];
			int fx = x+dx[d];
			if(safe(fy,fx) && !chk[fy][fx] && arr[fy][fx] == '*') {
				a = false;
				z++;
			}
		}
		if(a) { // 주위에 아무 폭탄이 없다
			map[y][x] = 0;
			chk[y][x] = true;
			for (int d = 0; d < 8; d++) {
				int fy = y+dy[d];
				int fx = x+dx[d];
				if(safe(fy,fx) && !chk[fy][fx]) {
					dfs(fy,fx);
				}
			}
		}
		else { // 주위에 폭탄이 있으면 
			map[y][x] = z;
		}
		
	}

	public static boolean safe(int y, int x) {
		if(y >= 0 && y < N && x >= 0 && x < N)
			return true;
		else 
			return false;
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
