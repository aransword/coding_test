import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static int Zsearch(int xStart, int xEnd, int yStart, int yEnd, int cTarget, int rTarget) {

        if(xEnd - xStart == 1) {
            if(xStart == cTarget && yStart == rTarget) {
                return 1;
            } else if(xEnd == cTarget && yStart == rTarget) {
                return 2;
            } else if(xStart == cTarget && yEnd == rTarget) {
                return 3;
            } else {
                return 4;
            }
        }

        int xHalf = (xStart + xEnd) / 2;
        int yHalf = (yStart + yEnd) / 2;

        // 각각 좌상귀, 우상귀, 좌하귀, 우하귀
        if(cTarget <= xHalf && rTarget <= yHalf) {
            return Zsearch(xStart, xHalf, yStart, yHalf, cTarget, rTarget);
        } else if(cTarget > xHalf && rTarget <= yHalf) {
            return Zsearch(xHalf + 1, xEnd, yStart, yHalf, cTarget, rTarget) + (xHalf - xStart + 1) * (xHalf - xStart + 1);
        } else if(cTarget <= xHalf && rTarget > yHalf) {
            return Zsearch(xStart, xHalf, yHalf + 1, yEnd, cTarget, rTarget) + ((xHalf - xStart + 1) * (xHalf - xStart + 1)) * 2;
        } else {
            return Zsearch(xHalf + 1, xEnd, yHalf + 1, yEnd, cTarget, rTarget) + ((xHalf - xStart + 1) * (xHalf - xStart + 1)) * 3;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);

        int r = Integer.parseInt(inputs[1]); // 행
        int c = Integer.parseInt(inputs[2]); // 열

        int size = 1;
        for(int i = 0; i < N; i++) {
            size *= 2;
        }
        size -= 1;

        int cnt = Zsearch(0, size, 0, size, c, r) - 1;

        sb.append(cnt);

        System.out.println(cnt);
    }
}