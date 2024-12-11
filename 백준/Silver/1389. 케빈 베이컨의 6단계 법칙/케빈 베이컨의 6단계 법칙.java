import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //사람 수
        int M = Integer.parseInt(st.nextToken()); //관계 수
        int[][] FW = new int[N+1][N+1]; //

        // 배열 초기화
        for(int i = 1; i <= N; i++) {
            Arrays.fill(FW[i], 99999999);
            FW[i][i] = 0;
        }

        //가중치 저장
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            FW[a][b] = 1;
            FW[b][a] = 1;
        }

        //플로이드 워셜 점화실 사용한 반복문(최단거리 배열 채우기)
        for(int K = 1; K <= N; K++) {
            for(int S = 1; S <= N; S++) {
                for(int E = 1; E <= N; E++) {
                    FW[S][E] = Math.min(FW[S][E], FW[S][K] + FW[K][E]);
                }
            }
        }

        int result = 1;
        int minSum = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++) {
            int sum = 0;
            for(int j = 1; j <= N; j++) {
                sum+=FW[i][j];
            }
            if(sum < minSum) {
                minSum = sum;
                result = i;
            }
        }
        System.out.println(result);
    }
}
