import java.util.Arrays;
import java.util.Scanner;

class Set {
    boolean[] arr = new boolean[21];

    void add(int x) {
        arr[x] = true;
    }

    void remove(int x) {
        arr[x] = false;
    }

    int check(int x) {
        if(arr[x]) {
            return 1;
        } else {
            return 0;
        }
    }

    void toggle(int x) {
        arr[x] = !arr[x];
    }

    void all() {
        for(int i = 1; i <= 20; i++) {
            arr[i] = true;
        }
    }

    void empty() {
        for(int i = 1; i <= 20; i++) {
            arr[i] = false;
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        Set s = new Set();

        for(int i = 0; i < M; i++) {
            String command = sc.next();
            if(command.equals("add")) {
                int x = sc.nextInt();
                s.add(x);
            } else if(command.equals("remove")) {
                int x = sc.nextInt();
                s.remove(x);
            } else if(command.equals("check")) {
                int x = sc.nextInt();
                sb.append(s.check(x)).append('\n');
            } else if(command.equals("toggle")) {
                int x = sc.nextInt();
                s.toggle(x);
            } else if(command.equals("all")) {
                s.all();
            } else if(command.equals("empty")) {
                s.empty();
            }
        }

        System.out.println(sb);

        sc.close();
    }
}