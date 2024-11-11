import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] city;
    static long[][] edgelist;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시의 갯수
        M = Integer.parseInt(st.nextToken()); // 버스 노선의 갯수
        city = new long[N + 1]; //1번에서 해당 도시로 가는 최단거리
        edgelist = new long[M][3]; //에지리스트

        Arrays.fill(city, Integer.MAX_VALUE);
        city[1] = 0;

        // 버스 노선 정보
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edgelist[i][0] = Integer.parseInt(st.nextToken()); //시작 도시
            edgelist[i][1] = Integer.parseInt(st.nextToken()); //도착 도시
            edgelist[i][2] = Integer.parseInt(st.nextToken()); //걸리는 시간
        }

        if(BellmanFord()) System.out.println("-1");
        else{
            for(int i = 2; i <= N; i++) { //시작 도시는 빼고 출력
                if(city[i] == Integer.MAX_VALUE) System.out.println("-1");
                else System.out.println(city[i]);
            }
        }

    }

    private static boolean BellmanFord() {
        //N-1만큼 반복
        for(int i = 1;i < N;i++){
            for(int j = 0; j < M; j++) {
                long s = edgelist[j][0]; //노선도의 시작 도시
                long e = edgelist[j][1]; //노선도의 도착도시
                long t = edgelist[j][2]; //노선도 걸리는 시간
                // 시작도시의 가중치가 무한이 아니고 갱신된 값이 더 작을 경우
                if(city[(int) s] != Integer.MAX_VALUE && city[(int) s] + t < city[(int) e]){
                    city[(int) e] = city[(int) s] + t;
                }
            }
        }

        //N번째 반복 여기서 업데이트가 일어나면 음수 사이클 발생
        for(int j = 0; j < M; j++) {
            long s = edgelist[j][0]; //노선도의 시작 도시
            long e = edgelist[j][1]; //노선도의 도착도시
            long t = edgelist[j][2]; //노선도 걸리는 시간
            // 시작도시의 가중치가 무한이 아닐 경우
            if (city[(int) s] != Integer.MAX_VALUE && city[(int) s] + t < city[(int) e]) {
                return true;
            }
        }
        return false;
    }
}
