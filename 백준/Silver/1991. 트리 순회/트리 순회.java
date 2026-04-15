import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BinaryTree {
    BinaryTree left;
    BinaryTree right;
    char s;

    public BinaryTree(char s) {
        this.s = s;
        this.left = null;
        this.right = null;
    }
}

public class Main {

    static void prefix(StringBuilder sb, BinaryTree root) {
        sb.append(root.s);
        if(root.left != null) {
            prefix(sb, root.left);
        }
        if(root.right != null) {
            prefix(sb, root.right);
        }
    }

    static void infix(StringBuilder sb, BinaryTree root) {
        if(root.left != null) {
            infix(sb, root.left);
        }
        sb.append(root.s);
        if(root.right != null) {
            infix(sb, root.right);
        }
    }

    static void postfix(StringBuilder sb, BinaryTree root) {
        if(root.left != null) {
            postfix(sb, root.left);
        }
        if(root.right != null) {
            postfix(sb, root.right);
        }
        sb.append(root.s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        /*
         * 배열 형태로 이진 트리를 유지하려면 인덱스를 가져야 하는데,
         * 그렇게 되면 결국 인덱스가 너무 커져서 메모리가 부족해진다.
         * 그렇기 때문에 객체로 트리를 유지한다.
         */

        int nodeCnt = Integer.parseInt(br.readLine());
        BinaryTree[] trees = new BinaryTree[nodeCnt];

        for(int i = 0; i < nodeCnt; i++) {
            trees[i] = new BinaryTree((char) ('A' + i));
        }

        for(int i = 0; i < nodeCnt; i++) {
            String[] input = br.readLine().split(" ");

            // 입력된 노드 번호
            int rootNum = input[0].charAt(0) - 'A';
            if(!input[1].equals(".")) {
                int leftNum = input[1].charAt(0) - 'A';
                trees[rootNum].left = trees[leftNum];
            }
            if(!input[2].equals(".")) {
                int rightnum = input[2].charAt(0) - 'A';
                trees[rootNum].right = trees[rightnum];
            }
        }

        prefix(sb, trees[0]);
        sb.append('\n');
        infix(sb, trees[0]);
        sb.append('\n');
        postfix(sb, trees[0]);

        System.out.println(sb);
    }
}