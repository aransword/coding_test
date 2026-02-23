import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Conference implements Comparable<Conference> {
    int start;
    int end;

    public Conference(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Conference c) {
        if(this.end == c.end) {
            return this.start - c.start;
        } else {
            return this.end - c.end;
        }
    }

    public String toString() {
        return "회의 시작 시간 : " + this.start + " ~ 회의 종료 시간 : " + this.end;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        Conference[] conferences = new Conference[N];
        for(int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            int start = Integer.parseInt(in[0]);
            int end = Integer.parseInt(in[1]);

            conferences[i] = new Conference(start, end);
        }

        Arrays.sort(conferences, new Comparator<Conference>() {
            @Override
            public int compare(Conference c1, Conference c2) {
                return c1.compareTo(c2);
            }
        });

        int maximumCount = 1;
        Conference now = conferences[0];
        for(int i = 1; i < N; i++) {
            if(now.end <= conferences[i].start) {
                now = conferences[i];
                maximumCount++;
            }
        }

        sb.append(maximumCount);
        System.out.println(maximumCount);
    }
}