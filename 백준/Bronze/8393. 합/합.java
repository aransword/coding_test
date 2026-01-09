import java.util.Scanner;

public class Main {

    public static int sigma(int a) {
        if(a == 1) {
            return 1;
        }
        return a + sigma(a - 1);
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        int result = sigma(n);
        System.out.println(result);

        sc.close();
    }
}