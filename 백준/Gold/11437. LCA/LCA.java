import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] parent; //0: 부모 노드, 1: 깊이(Depth)
    static boolean[] visited; //DFS 사용시에 방문 여부 배열
    static ArrayList<Integer>[] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //정점의 갯수
        visited = new boolean[N + 1]; //방문 배열
        parent = new int[2][N + 1]; //부모와 깊이를 저장할 배열
        parent[0][1] = 1; parent[1][1] = 0; //루트노드의 부모를 자신과 깊이를 0으로 설정
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

        //DFS로 부모와 깊이 저장
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) 
                DFS(i);
        }

        int M = Integer.parseInt(br.readLine()); //LCA찾을 횟수

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); //노드1
            int b = Integer.parseInt(st.nextToken()); //노드2
            System.out.println(LCA(a, b));
        }
    }

    //최초 공통 조상 찾기
    private static int LCA(int a, int b) {
        int father = 0; //공통 조상
        if(parent[1][a]<parent[1][b]) {
            int sub = parent[1][b] - parent[1][a]; // 차이만큼만 올라가면 됨
            for(int i = 0; i<sub;i++){
                b = parent[0][b];
            }
        }else if(parent[1][a]>parent[1][b]) {
            int sub = parent[1][a] - parent[1][b]; // 차이만큼만 올라가면 됨
            for(int i = 0; i<sub;i++){
                a = parent[0][a];
            }
        }
        //같은 경우
        if(parent[1][a]==parent[1][b]){
            if(a==b){
                return a;
            }
            father = parent[0][a];
            while(a!=b){
                a = parent[0][a];
                b = parent[0][b];
            }
        }
        return a;
    }

    private static void DFS(int i) {
        if(visited[i]) return;
        visited[i] = true;
        for(int v : lists[i]) { //방문안했다는건 v가 i의 자식이라는 거
            if(!visited[v]) {
                parent[0][v] = i; //부모를 저장
                parent[1][v] = parent[1][i] + 1; //부모의 깊이 + 1
                DFS(v);
            }
        }
    }
}
