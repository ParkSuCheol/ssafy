package ssafy_algo;

import java.util.Arrays;

public class Solution_perm {
	static int n = 6;
	static int r = 3;
	static int[] arr = new int[3];

	public static void main(String[] args) {
		perm(0, 0, 0);
	}

	static void perm(int flag, int cnt, int start) {
		if (cnt == 3) {
			System.out.println(Arrays.toString(arr));
			return;
		}

		flag = 0;
		for (int i = start; i < n; i++) {
			if ((flag & 0 << i) == 0) {
				arr[cnt] = i + 1;
				perm(flag | 1 << i, cnt + 1, i + 1);
			}
		}
	}

}
