package ssafy_algo;

import java.util.Scanner;

public class Solution_Baek_17413_단어뒤집기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer ac = new StringBuffer();
		StringBuffer a = new StringBuffer();
		StringBuffer trash = new StringBuffer();
		ac.append(sc.nextLine());
		boolean chk = false;
		aa: for (int i = 0; i < ac.length(); i++) {
			if (ac.charAt(i) == '<') {
				a.append(ac.charAt(i));
				chk = true;
				continue;
			} else if (ac.charAt(i) == '>') {
				a.append(ac.charAt(i));
				chk = false;
				continue;
			}
			if (chk) {
				a.append(ac.charAt(i));
			} else {
				bb: while (!chk) {
					if (i >= ac.length())
						break;
					if (ac.charAt(i) == ' ') {
						break;
					}
					if (ac.charAt(i) == '<') {
						i--;
						chk = true;
					} else {
						trash.append(ac.charAt(i));
						i++;
					}
				}
					a.append(trash.reverse());
					trash = new StringBuffer();
					if(!chk)
					a.append(' ');
					if (i >= ac.length())
						break aa;
			}
		}
		System.out.println(a.toString());
	}

}
