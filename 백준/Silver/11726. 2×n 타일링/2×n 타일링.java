import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        int[][] combine = new int[1001][1001];

        for(int x = 0; x < 1001; x++) {
            for(int y = 0; y <= x; y++) {
                if(x == y || y == 0) {
                    combine[x][y] = 1;
                } else {
                    combine[x][y] = (combine[x - 1][y - 1] + combine[x - 1][y]) % 10007;
                }
            }
        }
        
        int cnt = 0;

        for(int num2 = 0; num2 * 2 <= n; num2++) {
            int num1 = n - (num2 * 2);
            int x = num1 + num2;

            cnt = (cnt + combine[x][num1]) % 10007;
        }

        System.out.println(cnt);

        sc.close();
    }
}