import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] cards = new int[20000001];
        int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            int card = sc.nextInt();
            cards[card + 10000000]++;
        }

        StringBuilder sb = new StringBuilder();
        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            int target = sc.nextInt();
            sb.append(cards[target + 10000000]).append(' ');
        }

        System.out.println(sb);

        sc.close();
    }
}