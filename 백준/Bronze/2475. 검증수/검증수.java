import java.util.Scanner;



public class Main {
    static int pow(int a) {
        return a * a;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for(int i = 0; i < 5; i++) {
            int input = sc.nextInt();
            sum += pow(input);
        }
        System.out.println(sum % 10);

        sc.close();
    }
}