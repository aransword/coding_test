import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[1001];
        a[1] = 1;
        a[2] = 2;

        for(int i = 3; i < 1001; i++) {
            a[i] = (a[i - 1] + a[i - 2]) % 10007;
        }
        
        

        System.out.println(a[n]);

        sc.close();
    }
}