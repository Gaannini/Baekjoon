import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] S = new long[N+1];

        st = new StringTokenizer(br.readLine());

        // 배열, 구간합 배열 채우기
        for(int i=1;i<N+1;i++){
          S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }

        // 구간 합 구하고 출력 S[j] - S[i-1]
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int fir = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(S[end] - S[fir-1]);
        }
    }
}
