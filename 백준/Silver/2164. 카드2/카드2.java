import java.util.Scanner;

class QueueComponent {
    int value;
    QueueComponent rear = null;

    public QueueComponent(int value) {
        this.value = value;
    }
}

class Queue {
    QueueComponent head = null;
    QueueComponent tail = null;

    void push(int a) {
        if(head == null) {
            head = new QueueComponent(a);
            tail = head;
        } else {
            QueueComponent q = new QueueComponent(a);
            tail.rear = q;
            tail = q;
        }
    }

    int pop() {
        if(head == null) {
            return -1;
        }
        else {
            int result = head.value;
            head = head.rear;
            return result;
        }
    }

    boolean isLast() {
        if(head.value == tail.value) {
            return true;
        }
        else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue q = new Queue();
        boolean isDiscard = true;

        for(int i = 1; i <= N; i++) {
            q.push(i);
        }

        while(true) {
            if(q.isLast()) {
                break;
            }

            if(isDiscard) {
                q.pop();
                isDiscard = false;
            } else {
                int v = q.pop();
                q.push(v);
                isDiscard = true;
            }
        }

        System.out.println(q.pop());

        sc.close();
    }
}