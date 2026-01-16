import java.util.Scanner;

class Stack {
    int length;
    int top = -1;
    int[] s;

    // s에 -1이 들어있으면 '('
    // s에 1이 들어있으면 ')'
    public Stack(int length) {
        this.length = length;
        s = new int[length];
    }
    
    int pop() {
        if(top == -1) {
            return 0;    
        } else {
            int result = s[top];
            s[top] = 0;
            top--;
            return result;
        }
    }

    void push(int i) {
        top++;
        s[top] = i;
    }

    boolean empty() {
        if(top == -1) {
            return true;
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int test_case = 0; test_case < T; test_case++) {
            String str = sc.next();
            int length = str.length();
            boolean isVPS = true;
            Stack s = new Stack(length);

            for(int i = 0; i < length; i++) {
                if(str.charAt(i) == '(') {
                    s.push(-1);
                } else if(str.charAt(i) == ')') {
                    int popped = s.pop();
                    if(popped == 0) {
                        isVPS = false;
                        break;
                    }
                }
            }
            if(isVPS) {
                if(s.pop() == 0) {
                    sb.append("YES").append('\n');
                } else {
                    sb.append("NO").append('\n');
                }
            } else {
                sb.append("NO").append('\n');
            }
        }

        System.out.println(sb);

        sc.close();
    }
}