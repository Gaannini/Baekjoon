import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        A = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Long.parseLong(st.nextToken());
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            long x = Long.parseLong(st.nextToken());
            //해당 값 시작&끝(초과되는 첫번째) 인덱스 찾기
            int start = startIdx(x);
            int end = endIdx(x);

            sb.append(end-start).append(" ");
        }
        System.out.println(sb);
    }

    private static int startIdx(long x) {
        int left = 0, right = A.length;
        while(left<right){
            int mid = (left+right)/2;
            if(A[mid]<x){
                left = mid+1;
            }else right = mid;
        }
        return left;
    }

    private static int endIdx(long x) {
        int left = 0, right = A.length;
        while(left<right){
            int mid = (left+right)/2;
            if(A[mid]>x) right = mid;
            else left = mid+1;
        }
        return left;
    }
}
