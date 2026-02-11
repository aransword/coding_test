import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] X = new int[N];
        int[] compressedCoord = new int[N];

        for(int i = 0; i < N; i++) {
            X[i] = sc.nextInt();
            compressedCoord[i] = X[i];
        }

        Arrays.sort(compressedCoord);

        int[] list = new int[N];
        Arrays.fill(list, 1000000001);

        int prev = 0;
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            if(i == 0) {
                prev = compressedCoord[i];
                list[cnt] = compressedCoord[i];
                cnt++;
            } else {
                if(prev == compressedCoord[i]) {
                    continue;
                } else {
                    prev = compressedCoord[i];
                    list[cnt] = compressedCoord[i];
                    cnt++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int index = Arrays.binarySearch(list, X[i]);
            sb.append(index).append(' ');
        }

        System.out.println(sb);

        sc.close();
    }
}