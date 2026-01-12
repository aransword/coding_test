import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Member implements Comparable<Member>{
    int age;
    String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Member other) {
        return this.age - other.age;
    }
}

public class Main {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Member[] members = new Member[N];

        for(int i = 0; i < N; i++) {
            int age = sc.nextInt();
            String name = sc.next();

            members[i] = new Member(age, name);
        }
        
        Arrays.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member m1, Member m2) {
                return m1.compareTo(m2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(members[i].age).append(' ').append(members[i].name).append('\n');
        }
        System.out.println(sb);
        sc.close();
    }
}