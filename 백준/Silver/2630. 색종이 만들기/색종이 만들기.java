import java.util.Scanner;

public class Main {

    static int[][] paper;
    static int whiteCnt = 0;
    static int blueCnt = 0;

    static void dfs(int xStart, int xEnd, int yStart, int yEnd) {

        boolean side = true;
        int sideColor = paper[yStart][xStart];
        for(int y = yStart; y <= yEnd; y++) {
            for(int x = xStart; x <= xEnd; x++) {
                if(paper[y][x] != sideColor) {
                    dfs(xStart, (xStart + xEnd) / 2, yStart, (yStart + yEnd) / 2);
                    dfs(((xStart + xEnd) / 2) + 1, xEnd, yStart, (yStart + yEnd) / 2);
                    dfs(xStart, (xStart + xEnd) / 2, ((yStart + yEnd) / 2) + 1, yEnd);
                    dfs(((xStart + xEnd) / 2) + 1, xEnd, ((yStart + yEnd) /2) + 1, yEnd);

                    side = false;
                    break;
                }
            }
            if(!side) {
                break;
            }
        }

        if(side) {
            if(sideColor == 0) {
                whiteCnt++;
            } else {
                blueCnt++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        paper = new int[N][N];

        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                paper[y][x] = sc.nextInt();
            }
        }

        dfs(0, N-1, 0, N-1);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);

        sc.close();
    }
}