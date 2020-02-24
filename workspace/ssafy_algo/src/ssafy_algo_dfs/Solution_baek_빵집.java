package ssafy_algo_dfs;

import java.util.Scanner;

public class Solution_baek_빵집 {
	static int N,M;
	static char[][] arr;
	static int[] dy = {-1,0,1};
	static int[] dx = {1,1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next().toCharArray();
		}
		print();
		
	}
	
	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean safe(int y, int x) {
		if(y >= 0 && y < N && x >= 0 && x < N) 
			return true;
		else
			return false;
	}

}
