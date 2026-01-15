import java.util.Scanner;

class QueueComponent {
    QueueComponent next = null;
    int value;

    public QueueComponent(int value) {
        this.value = value;
    }
}

class Queue {
    QueueComponent head = null;
    QueueComponent tail = null;

    void push(int value) {
        QueueComponent pushedQueueComponent = new QueueComponent(value);
        if(head == null) {
            head = pushedQueueComponent;
            tail = pushedQueueComponent;
        } else {
            tail.next = pushedQueueComponent;
            tail = pushedQueueComponent;
        }
    }

    int pop() {
        if(head == null) {
            return -1;
        } else {
            int result = head.value;
            head = head.next;
            return result;
        }
    }

    int size() {
        if(head == null) {
            return 0;
        } else {
            int cnt = 0;
            QueueComponent node = head;
            while(true) {
                cnt++;
                if(node.next == null) {
                    break;
                } else {
                    node = node.next;
                }
            }
            return cnt;
        }
    }

    int empty() {
        if(head == null) {
            return 1;
        } else {
            return 0;
        }
    }

    int front() {
        if(head == null) {
            return -1;
        } else {
            return head.value;
        }
    }

    int back() {
        if(head == null) {
            return -1;
        } else {
            return tail.value;
        }
    }
}

public class Main {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue q = new Queue();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i ++) {
            String command = sc.next();

            if(command.equals("push")) {
                int x = sc.nextInt();
                q.push(x);
            } else if(command.equals("pop")) {
                sb.append(q.pop()).append('\n');
            } else if(command.equals("size")) {
                sb.append(q.size()).append('\n');
            } else if(command.equals("empty")) {
                sb.append(q.empty()).append('\n');
            } else if(command.equals("front")) {
                sb.append(q.front()).append('\n');
            } else if(command.equals("back")) {
                sb.append(q.back()).append('\n');
            }
        }
        System.out.println(sb);

        sc.close();
    }
}