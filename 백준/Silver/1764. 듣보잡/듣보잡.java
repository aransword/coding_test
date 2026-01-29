import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String[] couldntListen = new String[N];
        String[] couldntSee = new String[M];

        for(int i = 0; i < N; i++) {
            couldntListen[i] = sc.next();
        }

        for(int i = 0; i < M; i++) {
            couldntSee[i] = sc.next();
        }

        Arrays.sort(couldntListen);
        Arrays.sort(couldntSee);

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        if(N < M) {
            for(int i = 0; i < N; i++) {
                if(0 <= Arrays.binarySearch(couldntSee, couldntListen[i])) {
                    sb.append(couldntListen[i]).append('\n');
                    cnt++;
                }
            }
        } else {
            for(int i = 0; i < M; i++) {
                if(0 <= Arrays.binarySearch(couldntListen, couldntSee[i])) {
                    sb.append(couldntSee[i]).append('\n');
                    cnt++;
                }
            }
        }
        sb.insert(0, '\n').insert(0, cnt);

        System.out.println(sb);

        sc.close();
    }
}