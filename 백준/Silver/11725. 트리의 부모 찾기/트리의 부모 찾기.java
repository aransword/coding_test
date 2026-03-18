import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Node {
    List<Node> neighbors = new ArrayList<>();
    int num;

    public Node(int num) {
        this.num = num;
    }
}

public class Main {

    static void dfs(Node node, int[] parent, boolean[] isVisited) {
        isVisited[node.num] = true;
        int length = node.neighbors.size();

        for(int i = 0; i < length; i++) {
            Node child = node.neighbors.get(i);
            int childNum = child.num;

            if(!isVisited[childNum]) {
                parent[childNum] = node.num;
                dfs(child, parent, isVisited);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 초기 설정
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N + 1];
        for(int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }

        // 입력을 받으면서 이웃을 추가한다.
        for(int i = 1; i <= N - 1; i++) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);

            nodes[a].neighbors.add(nodes[b]);
            nodes[b].neighbors.add(nodes[a]);
        }

        // 루트노드(1번)을 기준으로 탐색하면서 부모를 집어낸다.
        int[] parent = new int[N + 1];
        boolean[] isVisited = new boolean[N + 1];
        dfs(nodes[1], parent, isVisited);

        for(int i = 2; i <= N; i++) {
            sb.append(parent[i]).append('\n');
        }

        System.out.println(sb);
    }
}