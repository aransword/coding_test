import java.util.Scanner;

class StackComponent {
    StackComponent next = null;
    int value;

    public StackComponent(int value){
        this.value = value;
    }
}

class Stack {
    StackComponent head = null;
    StackComponent tail = null;

    int pop() {
        if(head == null) {
            return -1;
        } else {
            int result = tail.value;
            tail = tail.next;
            if(tail == null) {
                head = null;
            }
            return result;
        }
    }

    void push(int x) {
        if(head == null) {
            head = new StackComponent(x);
            tail = head;
        } else {
            StackComponent pushedComponent = new StackComponent(x);
            pushedComponent.next = tail;
            tail = pushedComponent;
        }
    }

    int size() {
        if(head == null) {
            return 0;
        } else {
            int cnt = 0;
            StackComponent s = tail;

            while(true) {
                cnt++;
                if(s.next != null) {
                    s = s.next;
                } else {
                    break;
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

    int top() {
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
        Stack s = new Stack();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            String command = sc.next();

            if(command.equals("push")) {
                int x = sc.nextInt();
                s.push(x);
            } else if(command.equals("pop")) {
                sb.append(s.pop()).append('\n');
            } else if(command.equals("size")) {
                sb.append(s.size()).append('\n');
            } else if(command.equals("empty")) {
                sb.append(s.empty()).append('\n');
            } else if(command.equals("top")) {
                sb.append(s.top()).append('\n');
            }
        }

        System.out.println(sb);
        sc.close();
    }
}