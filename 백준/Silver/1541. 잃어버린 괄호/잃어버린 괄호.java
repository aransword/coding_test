import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        
        int result = 0;
        String num = "";
        boolean isMinus = false;
        for(int i = 0; i < input.length(); i++) {
            // 문자열을 순차적으로 탐색한다.
            // 만약 숫자라면 num 문자열에 더한다.
            // 단, isMinus가 true라면 뺀다.
            // 만약 연산자이거나 문자열 끝이라면 num을 result에 더한다.
            if(input.charAt(i) == '+') {
                if(isMinus) {
                    result -= Integer.parseInt(num);
                } else {
                    result += Integer.parseInt(num);
                }
                num = "";
            } else if(input.charAt(i) == '-') {
                if(isMinus) {
                    result -= Integer.parseInt(num);
                } else {
                    result += Integer.parseInt(num);
                }
                isMinus = true;
                num = "";
            } else if(i == input.length() - 1) {
                num = num + input.charAt(i);
                if(isMinus) {
                    result -= Integer.parseInt(num);
                } else {
                    result += Integer.parseInt(num);
                }
            } else {
                num = num + input.charAt(i);
            }
        }

        sb.append(result);
        System.out.println(sb);
    }
}