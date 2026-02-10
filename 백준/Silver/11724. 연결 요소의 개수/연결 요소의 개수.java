import java.util.Scanner;

class Node {
    int num = 0;
    int visited = 0;
    boolean[] neighbor;

    public Node(int size) {
        neighbor = new boolean[size];
    }
}

public class Main {

    static Node[] nodes;

    static void dfs(int currentNodeNum, int maxNodeNum, int cnt) {
        nodes[currentNodeNum].visited = cnt;
        for(int i = 1; i < maxNodeNum; i++) {
            if(i == currentNodeNum) {
                continue;
            }
            if(nodes[currentNodeNum].neighbor[i]) {
                if(nodes[i].visited != 0) {
                    continue;
                } else {
                    dfs(i, maxNodeNum, cnt);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        nodes = new Node[N + 1];

        for(int i = 1; i < N + 1; i++) {
            nodes[i] = new Node(N + 1);
        }

        for(int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            nodes[u].neighbor[v] = true;
            nodes[v].neighbor[u] = true;
        }

        int areaCnt = 0;
        for(int i = 1; i < N + 1; i++) {
            if(nodes[i].visited != 0) {
                continue;
            }
            areaCnt++;
            dfs(i, N + 1, areaCnt);
        }

        System.out.println(areaCnt);

        sc.close();
    }
}