import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] A = new int[inputs.length];

        for(int i = 0; i < inputs.length; i++) {
            A[i] = Integer.parseInt(inputs[i]);
        }

        int[] arrayLengths = new int[inputs.length];

        // 수열을 돌면서, 인덱스가 자신보다 작은 위치에서 자신보다 크기가 작은 수 중에 연속 길이가 가장 긴 값을 찾는다.
        // 근데 이러면 연산 횟수가 너무 많아지는 것이 아닌가?
        arrayLengths[0] = 1;
        int result = 1;
        for(int i = 1; i < arrayLengths.length; i++) {
            boolean isFind = false;
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(A[i] > A[j] && max < arrayLengths[j]) {
                    max = arrayLengths[j];
                }
            }
            arrayLengths[i] = max + 1;
            if(result < arrayLengths[i]) {
                result = arrayLengths[i];
            }
        }

        sb.append(result);
        System.out.println(sb);
    }
}