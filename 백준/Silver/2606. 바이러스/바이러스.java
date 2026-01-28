import java.util.Scanner;

class Node {
    boolean[] neighbor;
    boolean infected = false;

    public Node(int nodeSize) {
        neighbor = new boolean[nodeSize];
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        Node[] computer = new Node[N + 1];
        for(int i = 1; i < N + 1; i++) {
            computer[i] = new Node(N + 1);
        }

        // 각 노드 연결.
        int S = sc.nextInt();
        for(int i = 0; i < S; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            computer[x].neighbor[y] = true;
            computer[y].neighbor[x] = true;
        }
        

        // 1번 감염
        computer[1].infected = true;

        while(true) {
            boolean isInfected = false;
            for(int i = 1; i < N + 1; i++) {
                if(computer[i].infected) {
                    for(int j = 1; j < N + 1; j++) {
                        if(computer[i].neighbor[j] && !computer[j].infected) {
                            computer[j].infected = true;
                            isInfected = true;
                        }
                    }
                }
            }
            if(!isInfected) {
                break;
            }
        }

        int result = 0;
        for(int i = 2; i < N + 1; i++) {
            if(computer[i].infected) {
                result++;
            }
        }
        
        System.out.println(result);

        sc.close();
    }
}