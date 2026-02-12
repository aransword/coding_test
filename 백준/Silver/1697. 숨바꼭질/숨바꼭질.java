import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static final int MAX_RANGE = 100000;
    static boolean[] visited = new boolean[MAX_RANGE + 1];

    static int bfs(int curr, int tgt) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(curr);
        visited[curr] = true;

        int level = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int c = queue.poll();
                
                if(c == tgt) {
                    return level;
                }
                if(c - 1 >= 0 && c - 1 <= MAX_RANGE && !visited[c - 1]) {
                    queue.offer(c - 1);
                    visited[c - 1] = true;
                }
                if(c + 1 >= 0 && c + 1 <= MAX_RANGE && !visited[c + 1]) {
                    queue.offer(c + 1);
                    visited[c + 1] = true;
                }
                if(c * 2 >= 0 && c * 2 <= MAX_RANGE && !visited[c * 2]) {
                    queue.offer(c * 2);
                    visited[c * 2] = true;
                }
            }

            level++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        
        int a = bfs(N, K);

        System.out.println(a);

        sc.close();
    }
}