import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] parent; // 부모 노드 배열
    static int[] depth;
    static boolean[] visited; //DFS 사용시에 방문 여부 배열
    static ArrayList<Integer>[] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //정점의 갯수
        K = (int) Math.ceil(Math.log(N) / Math.log(2)); // 2^k < N을 만족하는 최댓값
        visited = new boolean[N + 1]; //방문 배열
        depth = new int[N + 1]; //깊이 배열
        parent = new int[K][N + 1]; //부모를 저장할 배열
        lists = new ArrayList[N + 1];
        
        //인접리스트 만들기
        for(int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        //인접리스트 데이터 채우기
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }

        //DFS로 [0] 부모저장
        DFS(1);

        //2^k 부모 저장
        for(int i = 1;i<K;i++){
            for(int j = 1;j<=N;j++){
                parent[i][j] = parent[i-1][parent[i-1][j]];
            }
        }

        M = Integer.parseInt(br.readLine()); //LCA 찾을 횟수

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); //노드1
            int b = Integer.parseInt(st.nextToken()); //노드2
            System.out.println(LCA(a, b));
        }
    }

    //최초 공통 조상 찾기
    private static int LCA(int a, int b) {
        //a가 더 깊어도 b와 바꿔서 b가 더 깊게
        if(depth[a]>depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        //깊이 맞추기
        for(int k = K-1; k >= 0; k--) {
            if((1 << k) <= depth[b]-depth[a]) {
                b = parent[k][b];
            }
        }

        if (a == b) return a; // 같은 경우 바로 반환

        //조상 찾기
        for(int k = K-1; k >= 0; k--) {
            if(parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        if(a==b) return a;
        else return parent[0][a];
    }

    private static void DFS(int i) {
        if(visited[i]) return;
        visited[i] = true;
        for(int v : lists[i]) { //방문안했다는건 v가 i의 자식이라는 거
            if(!visited[v]) {
                parent[0][v] = i; //부모를 저장
                depth[v] = depth[i] +1 ; //깊이 저장
                DFS(v);
            }
        }
    }
}
