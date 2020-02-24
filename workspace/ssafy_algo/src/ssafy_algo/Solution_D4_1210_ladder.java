package ssafy_algo;

import java.util.Scanner;

public class Solution_D4_1210_ladder {

	static int[] dx = { -1, 1, 0 }; // 좌 우
	static int[][] arr;
	static int rx, ry;
	static int d = 0;
	static int x, y;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int iT = 1; iT <= 1; iT++) {
			arr = new int[100][100];
			int N = sc.nextInt();
			rx = 0;
			ry = 99;
			d = 0;
			for (int y = 0; y < 100; y++) {
				for (int x = 0; x < 100; x++) {
					arr[y][x] = sc.nextInt();
				}
			}

			for (int i = 0; i < 100; i++) {
				if (arr[ry][i] == 2) {
					rx = i;
					break;
				}
			}

			while (y != 0) {
				y--;
				boolean chk = false;
				for (int i = 0; i < 2; i++) {
					x = rx +dx[i];
					if (x >= 0 && x < 100 && arr[y][x] == 1) {
						chk = true;
						d = i;
						rx = x;
						break;
					}
				}
				while (chk) {
					if (y - 1 >= 0 && arr[y-1][x] == 1) {
						chk = false;
						y++;
						break;
					}
					x = x+dx[d];
					rx = x;
				}
			}
			System.out.println(rx);
			System.out.println(x);

		}
	}

}
