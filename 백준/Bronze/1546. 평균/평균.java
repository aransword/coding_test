import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double M = 0;
        double sum = 0;

        for(int i = 0; i < n; i++) {
            double score = sc.nextDouble();
            sum += score;
            if(M < score) {
                M = score;
            }
        }

        double mean = (sum * 100.0) / (n * M);

        System.out.println(mean);


        sc.close();
    }
}