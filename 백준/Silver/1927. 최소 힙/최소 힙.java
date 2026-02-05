import java.util.Scanner;

class Minheap {
    int[] heap;
    int currentCnt = 0;

    public Minheap(int maxSize) {
        heap = new int[maxSize + 1];
    }

    void insert(int num) {
        currentCnt++;
        heap[currentCnt] = num;

        int cnt = currentCnt;
        while(true) {
            if(cnt == 0) {
                break;
            }

            // 만약 부모 노드보다 작은 수라면 부모와 교체
            if(heap[cnt] < heap[cnt / 2]) {
                int temp = heap[cnt / 2];
                heap[cnt / 2] = heap[cnt];
                heap[cnt] = temp;

                cnt = cnt / 2;
            } else {
                break;
            }
        }
    }

    int get() {
        if(currentCnt == 0) {
            return 0;
        }

        int result = heap[1];
        heap[1] = heap[currentCnt];
        currentCnt--;

        int cnt = 1;
        while(cnt * 2 <= currentCnt) {
            int left = cnt * 2;
            int right = (cnt * 2) + 1;
            int targetChild = left; // 일단 왼쪽 자식을 비교 대상으로 설정

            if (right <= currentCnt && heap[right] < heap[left]) {
                targetChild = right;
            }

            if (heap[cnt] <= heap[targetChild]) {
                break;
            }

            // 3. 자식이 더 작다면 교체 (Swap)
            int temp = heap[cnt];
            heap[cnt] = heap[targetChild];
            heap[targetChild] = temp;

            cnt = targetChild; // 아래로 내려감
        }
        

        return result;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Minheap h = new Minheap(N);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int in = sc.nextInt();
            if(in == 0) {
                sb.append(h.get()).append('\n');
            } else {
                h.insert(in);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);

        sc.close();
    }
}