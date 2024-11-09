import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] A;
    static int[] time, D, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //인접리스트
        int N = Integer.parseInt(br.readLine());
        A = new ArrayList[N+1];
        for (int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();

        D = new int[N+1]; //진입차수배열
        time = new int[N+1]; // 짓는데 걸리는 시간
        result = new int[N+1]; // 선행건물까지 짓는걸 모두 합한 시간

        //집입차수배열 데이터 넣기
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken()); //시간
            while(true){
                int x = Integer.parseInt(st.nextToken());
                if(x==-1) break;
                A[x].add(i);
                D[i]++;
            }
        }

        Topology();

        for(int i = 1; i <= N; i++)
            System.out.println(result[i]);
    }

    private static void Topology() {
        Queue<Integer> q = new LinkedList<>();

        // 초기 설정 : 진입 차수가 0인 노드 큐 삽입
        for(int i = 1; i < D.length; i++){
            if(D[i]==0){
                q.add(i);
                result[i] = time[i];
            }
        }

        //위상 정렬
        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : A[cur]){ // cur은 next들을 짓기위해 선행건물로 지어야한느 인덱스
                D[next]--; // 진입 차수 감소
                result[next] = Math.max(result[next], result[cur] + time[next]);
                if(D[next]==0){
                    q.add(next);
                }
            }
        }
    }
}
