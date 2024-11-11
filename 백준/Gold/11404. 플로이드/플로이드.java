import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] D;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int INF = 99999999;
        N = Integer.parseInt(br.readLine()); //도시의 갯수(노드)
        M = Integer.parseInt(br.readLine()); //버스의 갯수(간선)
        D = new int[N+1][N+1]; //최단거리를 저장할 배열

        //자신이 자신에게 가는 루트는 0 넣기
        for(int i = 1; i <= N; i++) {
            Arrays.fill(D[i], INF);
            D[i][i] = 0;
        }

        // 버스 노선 저장
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); //시작
            int e = Integer.parseInt(st.nextToken()); //도착
            int m = Integer.parseInt(st.nextToken()); //비용
            D[s][e] = Math.min(D[s][e], m); // 기존 값과 비교하여 최소값 저장
        }

        //플로이드 워셜
        FloydWarchall();

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++){
                if(D[i][j] == INF) System.out.print("0 ");
                else System.out.print(D[i][j]+" ");
            }
            System.out.println();
        }

    }

    private static void FloydWarchall() {
        for(int K=1; K<=N; K++){ //경유지
            for(int S=1; S<=N; S++){ //출발
                for(int E=1; E<=N; E++){ //도착
                    //지금 현재 S->E보다 S->K + K->E 값이 더 작으면 업데이트
                    D[S][E] = Math.min(D[S][E], D[S][K] + D[K][E]);
                }
            }
        }
    }
}
