import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputSize = br.readLine();
        String[] max = inputSize.split(" ");

        int n = Integer.parseInt(max[0]);
        int m = Integer.parseInt(max[1]);

        

        // 첫번째 인덱스가 y축
        // 두번째 인덱스가 x축
        boolean[][] map = new boolean[n][m];
        int[][] distance = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int startX = 0;
        int startY = 0;

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] dot = line.split(" ");
            for(int j = 0; j < m; j++) {
                int land = Integer.parseInt(dot[j]);
                if(land == 2) {
                    map[i][j] = true;
                    startX = j;
                    startY = i;
                } else if(land == 1) {
                    map[i][j] = true;
                } else {
                    map[i][j] = false;
                }
            }
        }
        br.close();

        visited[startY][startX] = true;
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();
        queueX.offer(startX);
        queueY.offer(startY);

        int level = 0;
        while(!queueX.isEmpty() && !queueY.isEmpty()) {
            int size = queueX.size();

            for(int i = 0; i < size; i++) {
                int currX = queueX.poll();
                int currY = queueY.poll();

                distance[currY][currX] = level;

                if(currY - 1 >= 0 && !visited[currY - 1][currX] && map[currY - 1][currX]) {
                    queueX.offer(currX);
                    queueY.offer(currY - 1);
                    visited[currY - 1][currX] = true;
                }
                if(currX - 1 >= 0 && !visited[currY][currX - 1] && map[currY][currX - 1]) {
                    queueX.offer(currX - 1);
                    queueY.offer(currY);
                    visited[currY][currX - 1] = true;
                }
                if(currY + 1 < n && !visited[currY + 1][currX] && map[currY + 1][currX]) {
                    queueX.offer(currX);
                    queueY.offer(currY + 1);
                    visited[currY + 1][currX] = true;
                }
                if(currX + 1 < m && !visited[currY][currX + 1] && map[currY][currX + 1]) {
                    queueX.offer(currX + 1);
                    queueY.offer(currY);
                    visited[currY][currX + 1] = true;
                }
            }

            level++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j]) {
                    sb.append(-1).append(" ");
                } else {
                    sb.append(distance[i][j]).append(" ");
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}