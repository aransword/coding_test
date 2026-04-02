import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    
    // 모듈러 연산의 분배 법칙
    // (a * b) % c = ((a % c) * (b % c)) % c
    static long modPow(long base, long exp, long mod) {
        if(exp == 1) {
            return base % mod;
        }

        long result = modPow(base, exp / 2, mod) % mod;

        if(exp % 2 == 1) {
            return ((result * result) % mod * (base % mod)) % mod;
        } else {
            return (result * result) % mod;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        String[] inputs = br.readLine().split(" ");
        long a = Long.parseLong(inputs[0]);
        long b = Long.parseLong(inputs[1]);
        long c = Long.parseLong(inputs[2]);

        long result = modPow(a, b, c);

        sb.append(result);
        System.out.println(sb);
    }
}