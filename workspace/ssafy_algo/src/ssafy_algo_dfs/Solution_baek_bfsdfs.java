package ssafy_algo_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_baek_bfsdfs {
	static int N, cnt, cnt2;
	static char[][] map;
	static boolean[][] chk;
	static Queue<point> que = new LinkedList<point>();
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		chk = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
		}
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'R' && !chk[i][j]) {
					chk[i][j] = true;
					bfs(i,j,'R');
					cnt++;
				}
				else if(map[i][j] == 'G' && !chk[i][j]) {
					chk[i][j] = true;
					bfs(i,j,'G');
					cnt++;
				}
				else if(map[i][j] == 'B' && !chk[i][j]) {
					chk[i][j] = true;
					bfs(i,j,'B');
					cnt++;
				}
			}
		}
		
		cnt2 = 0 ;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'G')
					map[i][j] = 'R';
			}
		}
		chk = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'R' && !chk[i][j]) {
					chk[i][j] = true;
					bfs(i,j,'R');
					cnt2++;
				}
				else if(map[i][j] == 'B' && !chk[i][j]) {
					chk[i][j] = true;
					bfs(i,j,'B');
					cnt2++;
				}
			}
		}
		
		System.out.println(cnt + " " + cnt2);

	}

	public static void bfs(int y, int x, char c) {
		que.add(new point(y,x));
		chk[y][x] = true;
		while(!que.isEmpty()) {
			point cur = que.poll();
			for (int d = 0; d < 4; d++) {
				int fy = cur.y + dy[d];
				int fx = cur.x + dx[d];
				if(safe(fy,fx) && map[fy][fx] == c && !chk[fy][fx]) {
					chk[fy][fx] = true;
					que.add(new point(fy,fx));
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

	static class point {
		int y;
		int x;

		public point(int y, int x) {
			this.y = y;
			this.x = x;
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
