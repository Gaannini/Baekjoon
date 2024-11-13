import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;
    static long N, M, K;
    static long minK, square; //2^k
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //데이터 갯수
        M = Integer.parseInt(st.nextToken()); //업데이트 횟수
        K = Integer.parseInt(st.nextToken()); //구간합 횟수
        minK = (int) Math.ceil(Math.log(N) / Math.log(2)); // 2^k ≥ N을 만족하는 최소값
        square = (int) Math.pow(2, minK); // 2^k
        tree = new long[(int) (square*2)]; //이진 트리 배열 , 배열의 크기 = 2^k * 2
        Arrays.fill(tree, 0);

        //데이터 받고 리프 노드에 채움
        for (int i = 0; i < N; i++) {
            tree[(int) (i+(square))] = Long.parseLong(br.readLine());
        }
        // 부모 노드들 채우기
        for(int i = tree.length-1; i > 1; i = (i-2)) {
            int parent = i/2;
            tree[parent] = tree[i]+tree[i-1];
        }

        //구간합 + 업데이트
        for(int i=0;i<M+K;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); //1: 업데이트, 2: 구간합
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a==1)
                update(b, c);
            else if(a==2)
                sum(b, (int) c);
        }
    }

    private static void update(int b, long c) {
        long index = b + square - 1;
        long sub = c - tree[(int) index];
        tree[(int) index] = c;
        for(long idx = index/2;idx>0;idx /= 2)
            tree[(int) idx] += sub;
    }

    private static void sum(int b, int c) {
        long result = 0;
        b = (int) (b + square-1);
        c = (int) (c + square-1);
        while(b <= c){
            //시작노드가 오른쪽 노드이면
            if(b%2==1)
                result+= tree[b];
            //끝노드가 왼쪽 노드이면
            if(c%2==0)
                result+= tree[c];

            b = (b+1)/2;
            c = (c-1)/2;
        }
        System.out.println(result);
    }
}
