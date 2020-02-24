package ssafy_algo_dfs;

import java.util.Scanner;

public class Solution_D4_1226_미로 {

	static int[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static boolean[][] chk;
	static int x,y,res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int iT = 1; iT <= 10; iT++) {
			int N = sc.nextInt();
			map = new int[16][16];
			for (int i = 0; i < 16; i++) {
				String s = sc.next();
				for (int j = 0; j < 16; j++) {
					map[i][j] = s.charAt(j)-'0';
				}
			}
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 16; j++) {
					if(map[i][j] == 2) {
						y = i;
						x = j;
					}
				}
			}
			chk = new boolean[16][16];
			bfs(y,x);
//			print();
			
			System.out.println("#"+iT + " " +res);
			
		}

	}
	
	private static void bfs(int y, int x) {
		if (map[y][x] == 3) {
			res = 1;
		}
		for(int d = 0; d < 4; d++) {
			int fy = y+dy[d];
			int fx = x+dx[d];
			if(fy >= 0 && fy < 16 && fx >= 0 && fx < 16 
					&& map[fy][fx] != 1 && !chk[fy][fx]) {
				chk[fy][fx] = true;
				bfs(fy,fx);
			}
		}
		
	}

	public static void print() {
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
