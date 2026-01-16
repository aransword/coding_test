import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] board = new int[N][M];
        

        for(int y = 0; y < N; y++){
            String row = sc.next();
            for(int x = 0; x < M; x++) {
                board[y][x] = row.charAt(x) == 'W' ? 1 : 0;
            }
        }

        // 체스판의 형태는 두개 뿐

        int[][] wChess = new int[8][8];
        int[][] bChess = new int[8][8];

        for(int y = 0; y < 8; y++) {
            for(int x = 0; x < 8; x++) {
                if((x + y) % 2 == 0) {
                    wChess[y][x] = 1;
                    bChess[y][x] = 0;
                } else {
                    wChess[y][x] = 0;
                    bChess[y][x] = 1;
                }
            }
        }

        int minCnt = 64;

        for(int a = 0; a + 7 < N; a++) {
            for(int b = 0; b + 7 < M; b++) {
                int wCnt = 0;
                int bCnt = 0;
                int cy = 0;
                for(int y = a; y < a + 8; y++, cy++) {
                    int cx = 0;
                    for(int x = b; x < b + 8; x++, cx++) {
                        if(board[y][x] != wChess[cy][cx]) {
                            wCnt++;
                        }
                        if(board[y][x] != bChess[cy][cx]) {
                            bCnt++;
                        }
                    }
                }
                
                int result = wCnt > bCnt ? bCnt : wCnt;
                if(result < minCnt) {
                    minCnt = result;
                }
                
            }
        }

        System.out.println(minCnt);

        sc.close();
    }
}