import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] cards = new int[N];

        for(int i = 0; i < N; i++) {
            cards[i] = sc.nextInt();
        }

        int blackjack = 0;

        for(int a = 0; a < N; a++) {
            for(int b = 0; b < N; b++) {
                if(b == a) {
                    continue;
                }
                for(int c = 0; c < N; c++) {
                    if(c == b || c == a) {
                        continue;
                    }
                    int sum = cards[a] + cards[b] + cards[c];
                    if(sum > blackjack && sum <= M) {
                        blackjack = sum;
                    }
                }
            }
        }

        System.out.println(blackjack);

        sc.close();
    }
}