import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Coord implements Comparable<Coord>{
    int x;
    int y;
    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Coord other) {
        if(this.x == other.x) {
            return this.y - other.y;
        } else {
            return this.x - other.x;
        }
    }
}

public class Main {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Coord[] dots = new Coord[N];

        for(int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            Coord dot = new Coord(x, y);
            dots[i] = dot;
        }

        sc.close();

        Arrays.sort(dots, new Comparator<Coord>() {
            @Override
            public int compare(Coord a, Coord b) {
                return a.compareTo(b);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(dots[i].x).append(' ').append(dots[i].y).append('\n');
        }
        System.out.println(sb);
    }
}