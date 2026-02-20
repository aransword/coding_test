import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 상하좌우 탐색을 위한 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] tomatoes = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();

        int unripenedCount = 0; // 안 익은 토마토 개수 추적

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoes[i][j] == 1) {
                    // 시작부터 익어있는 토마토를 큐에 넣음 (x, y, 걸린 일수)
                    queue.offer(new int[]{i, j, 0}); 
                } else if (tomatoes[i][j] == 0) {
                    unripenedCount++;
                }
            }
        }

        // 처음부터 다 익어있는 상태라면 0 출력 후 종료
        if (unripenedCount == 0) {
            System.out.println(0);
            return;
        }

        int days = 0;

        // BFS 실행
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            days = current[2];

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 상자 범위를 벗어나지 않고, 안 익은 토마토(0)가 있다면
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && tomatoes[nx][ny] == 0) {
                    tomatoes[nx][ny] = 1; // 토마토를 익힘
                    unripenedCount--;     // 안 익은 토마토 개수 감소
                    queue.offer(new int[]{nx, ny, days + 1}); // 큐에 새로 익은 토마토 추가
                }
            }
        }

        // BFS가 끝난 후 안 익은 토마토가 남아있다면 -1, 아니면 걸린 일수 출력
        if (unripenedCount > 0) {
            System.out.println(-1);
        } else {
            System.out.println(days);
        }
    }
}