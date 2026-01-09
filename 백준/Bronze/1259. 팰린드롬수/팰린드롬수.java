import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            int N = sc.nextInt();
            if(N == 0) {
                break;
            }
            int[] a = new int[5];
            int i;

            for(i = 0; i < 5; i++) {
                a[i] = N % 10;
                N = N / 10;
                if(N == 0)
                    break;
            }

            boolean isPal = true;
            for(int j = 0; j <= i; j++) {
                if(a[j] != a[i - j]) {
                    isPal = false;
                    break;
                }
            }

            if(isPal) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
        

        sc.close();
    }
}