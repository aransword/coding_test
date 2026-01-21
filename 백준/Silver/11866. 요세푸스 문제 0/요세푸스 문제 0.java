import java.util.Scanner;

class Node {
    Node next = null;
    int val = 0;

    public Node(int value) {
        this.val = value;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Node head = new Node(0);

        // 원형 리스트 구현.
        Node prev = head;
        for(int i = 1; i <= N; i++) {
            prev.next = new Node(i);
            prev = prev.next;
        }

        prev.next = head.next;


        prev = null;
        Node curr = head;
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < K; j++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
            if(i == N - 1) {
                sb.append(curr.val).append('>');
            } else {
                sb.append(curr.val).append(", ");
            }
        }

        System.out.println(sb);

        sc.close();
    }
}