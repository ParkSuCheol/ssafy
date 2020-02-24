package ssafy_algo;

import java.util.Scanner;

public class Solution_D3_2806_NQ {
	static int N;
	static int[] board;
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int iT = 1; iT <= T; iT++) {
			N = sc.nextInt();
			res = 0;
			board = new int[N];
			ar(0);
			System.out.println(res);
		}
	}

	public static void ar(int y) {
		for (int i = 0; i < N; i++) {
			board[y] = i;
			boolean chk = true;
			for (int j = 0; j < y; j++) {
				if (board[j] == board[y] || y - j == board[y] - board[j] || y - j == board[j] - board[y])
					chk = false;
			}
			if (chk) {
				if (y == N - 1)
					res++;
				else
					ar(y + 1);
			}

		}

	}

}
