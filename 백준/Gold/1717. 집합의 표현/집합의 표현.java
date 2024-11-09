import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //노드 수
        int m = Integer.parseInt(st.nextToken()); //연산 수

        A = new int[n+1];
        Arrays.setAll(A, i -> i);

        // 질의 계산
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken()); //연산종류 0: union, 1: find
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(type == 0){
                union(a, b);
            } else{
                if(findLeader(a) == findLeader(b)) System.out.println("YES");
                else System.out.println("NO");
            }

        }
    }

    private static int findLeader(int x) {
        if(A[x] == x) return x;
        else return A[x] = findLeader(A[x]); //경로압축

    }

    private static void union(int a, int b) {
        a = findLeader(a);
        b = findLeader(b);
        if(a < b) A[b] = a;
        else A[a] = b;
    }
}
