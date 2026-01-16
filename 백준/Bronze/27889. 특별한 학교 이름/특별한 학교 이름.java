import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String school = sc.next();
        
        if(school.equals("NLCS")) {
            System.out.println("North London Collegiate School");
        } else if(school.equals("BHA")) {
            System.out.println("Branksome Hall Asia");
        } else if(school.equals("KIS")) {
            System.out.println("Korea International School");
        } else if(school.equals("SJA")) {
            System.out.println("St. Johnsbury Academy");
        }

        sc.close();
    }
}