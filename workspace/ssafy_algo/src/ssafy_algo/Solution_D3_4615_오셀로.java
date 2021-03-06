package ssafy_algo;

import java.util.Scanner;

public class Solution_D3_4615_오셀로 {

   static int T, N, M;
   static int[][] board;
   static int bcnt, wcnt;

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      T = sc.nextInt();
      for (int t = 1; t <= T; t++) {
         N = sc.nextInt();
         M = sc.nextInt();
         bcnt = 0;
         wcnt = 0;
         board = new int[N + 1][N + 1];
         board[N / 2][N / 2] = 2;
         board[N / 2][N / 2 + 1] = 1;
         board[N / 2 + 1][N / 2] = 1;
         board[N / 2 + 1][N / 2 + 1] = 2;

         int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
         int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };

         for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int c = sc.nextInt(); // 흑돌 : 1 , 백돌 : 2
            int ec;
            if (c == 2)
               ec = 1;
            else
               ec = 2;
            board[y][x] = c;

            f: for (int d = 0; d < 8; d++) {
               int ny = y;
               int nx = x;
               boolean isen = false;
               int encnt = 0;
               while (true) {
                  ny += dy[d];
                  nx += dx[d];
                  if (ny < 1 || nx < 1 || ny >= N + 1 || nx >= N + 1 || board[ny][nx]==0)
                     continue f;

                  if (board[ny][nx] != ec && !isen) {
                     break;
                  } else if (board[ny][nx] == ec) {
                     isen = true;
                     encnt++;
                  } else if (board[ny][nx] == c && isen) {
                     for (int j = 0; j < encnt; j++) {
                        ny -= dy[d];
                        nx -= dx[d];
                        board[ny][nx] = c;
                     }
                     break;
                  }
               }
            }
         }

         for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
               if (board[i][j] == 1) {
                  bcnt++;
               } else if (board[i][j] == 2) {
                  wcnt++;
               }
            }
         }

         System.out.println("#" + t + " " + bcnt + " " + wcnt);
      }
   }

}