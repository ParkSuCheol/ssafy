package ssafy_algo;

import java.util.Arrays;

public class Solution_Combi {
	static int arr[];
	static int n = 6, r = 3;

	public static void main(String[] args) {
		arr = new int [3];
		com(0,0);
	}

	static void com(int start, int count) {
		if (count == 3) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int i = 0; i < n; i++) {
			arr[count] = i + 1;
			com(i, count + 1);
		}

	}
}
