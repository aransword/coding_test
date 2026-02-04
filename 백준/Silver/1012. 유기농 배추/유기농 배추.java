import java.util.Scanner;

class Node {
    boolean isPlanted = false;
    int area = 0;
}

public class Main {

    // i, j는 현재 좌표
    // N, M은 최대 좌표
    static void dfs(Node[][] farm, int i, int j, int N, int M, int area) {
        if(!farm[i][j].isPlanted) {
            return;
        }

        if(farm[i][j].area != 0) {
            return;
        }

        farm[i][j].area = area;
        if(j > 0) {
            dfs(farm, i, j - 1, N, M, area);
        }
        if(j < M - 1) {
            dfs(farm, i, j + 1, N, M, area);
        }
        if(i > 0) {
            dfs(farm, i - 1, j, N, M, area);
        }
        if(i < N - 1) {
            dfs(farm, i + 1, j, N, M, area);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int test_case = 0; test_case < T; test_case++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int K = sc.nextInt();

            Node[][] farm = new Node[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    farm[i][j] = new Node();
                }
            }

            for(int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                farm[y][x].isPlanted = true;
            }

            int cnt = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(farm[i][j].isPlanted && farm[i][j].area == 0) {
                        cnt++;
                        dfs(farm, i, j, N, M, cnt);
                    }
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);

        sc.close();
    }
}