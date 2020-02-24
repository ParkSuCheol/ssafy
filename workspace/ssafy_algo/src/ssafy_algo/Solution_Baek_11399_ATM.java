package ssafy_algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_Baek_11399_ATM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int res = 0;
		for (int i = 1; i <= arr.length; i++) {
			for (int j = 0; j < i; j++) {
				res += arr[j];
			}
		}
		System.out.println(res);
	}

}
