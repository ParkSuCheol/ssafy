package ssafy_algo;

import java.util.Scanner;

public class Solution_Baek_2798_블랙잭 {
	static int n;
	static int[] arr;
	static int[] br = new int[3];
	static int sum;
	static int b;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		M = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		perm(0, 0, 0);
		System.out.println(b);
	}

	static void perm(int flag, int cnt, int start) {
		if (cnt == 3) {
			sum = 0;
			for (int i = 0; i < br.length; i++) {
				sum += br[i];
			}
			if (sum > b && sum <= M) {
				b = sum;
			}
			return;
		}
		flag = 0;
		for (int i = start; i < n; i++) {
			if ((flag & 0 << i) == 0) {
				br[cnt] = arr[i];
				perm(flag | 1 << i, cnt + 1, i + 1);
			}
		}
	}
}
