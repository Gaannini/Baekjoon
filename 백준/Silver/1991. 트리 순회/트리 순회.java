import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] tree;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new int[N][2];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            tree[s.charAt(0)-'A'][0] = s.charAt(2)!='.' ? s.charAt(2)-'A' : -1; //본인 - 왼쪽 자식
            tree[s.charAt(0)-'A'][1] = s.charAt(4)!='.' ? s.charAt(4)-'A' : -1; //본인 - 오른쪽 자식
        }

        //전위 순회
        Preorder(0);
        System.out.println();
        //중위 순회
        Inorder(0);
        System.out.println();
        //후위 순회
        Postorder(0);
    }
    private static void Preorder(int now) {
        if(now==-1) return;
        System.out.print((char) (now+'A')); //현재
        Preorder(tree[now][0]); //왼쪽
        Preorder(tree[now][1]); //오른쪽
    }

    private static void Inorder(int now) {
        if(now==-1) return;
        Inorder(tree[now][0]);//왼쪽
        System.out.print((char) (now+'A')); //현재
        Inorder(tree[now][1]); //오른쪽
    }

    private static void Postorder(int now) {
        if(now==-1) return;
        Postorder(tree[now][0]);//왼쪽
        Postorder(tree[now][1]); //오른쪽
        System.out.print((char) (now+'A')); //현재
    }
}
