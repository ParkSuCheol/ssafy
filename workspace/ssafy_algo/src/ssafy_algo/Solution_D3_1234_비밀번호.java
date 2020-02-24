package ssafy_algo;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_D3_1234_비밀번호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> ars = new ArrayList<Integer>();
		int T = 10;
		for (int iT = 1; iT <= T; iT++) {
			int i = sc.nextInt();
			String s = sc.next();
			char b;
			int c;
			ars = new ArrayList<Integer>();
			for (int j = 0; j < i; j++) {
				b = s.charAt(j);
				c = b - '0';
				ars.add(c);
			
			}
			aa: while (true) {
				for (int j = 1; j < i; j++) {
					if (ars.get(j) == ars.get(j - 1)) {
						ars.remove(j - 1);
						ars.remove(j - 1);
						break;
					}
					if (j == ars.size()-1) {
						break aa;
					}
				}
			}
			System.out.print("#"+iT+" ");
			for (int j = 0; j < ars.size(); j++) {
				System.out.print(ars.get(j));
			}
			System.out.println();
		}
	}

}
