package ssafy_algo_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_두더지_bfs {


	static Queue<point> que = new LinkedList<>();
	static int[][] map;
	static int N, y, x,cnt;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					cnt++;
					bfs(i,j,cnt+1);
				}
			}
		}
		print(map);
	}

	static class point {
		int y;
		int x;
		
		public point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void bfs(int y, int x,int c) {
		que.add(new point(y, x));
		map[y][x] = c;
		while (!que.isEmpty()) {
			point cur = que.poll();
			for (int d = 0; d < 4; d++) {
				int fy = cur.y+dy[d];
				int fx = cur.x+dx[d];
				//if(!safe(fy,fx)) {continue;}
				if(safe(fy,fx) && map[fy][fx] == 1) {
					map[fy][fx] = c;
					que.offer(new point (fy,fx));
				}
				
			}
		}
	}

	public static boolean safe(int y, int x) {
		if (y >= 0 && y < N && x >= 0 && x < N)
			return true;
		else
			return false;
	}
	
	public static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
