import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int greater = a > b ? a : b ;
        int lesser = a < b ? a : b;

        int r= 1;
        for(int i = 1; i <= lesser; i++) {
            if(a % i == 0 && b % i == 0) {
                r = i;
            }
        }

        int t= 1;
        for(int i = 1; i <= lesser; i++) {
            if(lesser % i == 0 && (greater * i) % lesser == 0) {
                t = greater * i;
                break;
            }
        }

        System.out.println(r);
        System.out.println(t);


        sc.close();
    }
}
