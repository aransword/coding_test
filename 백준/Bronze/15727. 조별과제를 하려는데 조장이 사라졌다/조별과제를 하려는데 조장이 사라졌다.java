import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int r = L / 5;
        if(L % 5 == 0) {
            System.out.println(r);
        } else {
            System.out.println(r + 1);
        }
        sc.close();
    }
}