import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, V;
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    static ArrayList<Integer> DFSArr, BFSArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //정점개수
        M = Integer.parseInt(st.nextToken()); //간선개수
        V = Integer.parseInt(st.nextToken()); //시작점

        //배열, 인접리스트 초기화
        visited = new boolean[N + 1]; //방문배열
        DFSArr = new ArrayList<>(); //DFS 순서
        BFSArr = new ArrayList<>(); //BFS 순서
        lists = new ArrayList[N + 1]; //인접리스트
        for(int i = 1; i <= N; i++) lists[i] = new ArrayList<>();

        for(int i = 0;i < M;i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            lists[n1].add(n2);
            lists[n2].add(n1);
        }
        // 정렬: 작은 번호의 노드부터 방문하기 위함
        for (int i = 1; i <= N; i++) {
            Collections.sort(lists[i]);
        }

        Arrays.fill(visited, false);
        DFS(V);
        Arrays.fill(visited, false);
        BFS(V);

        for(int i = 0; i < DFSArr.size(); i++) System.out.print(DFSArr.get(i) + " ");
        System.out.println();
        for(int i = 0; i < BFSArr.size(); i++) System.out.print(BFSArr.get(i) + " ");


    }
    public static void DFS(int V) {
        if(visited[V]) return;
        visited[V] = true;
        DFSArr.add(V);
        for(int x : lists[V]) {
            if(!visited[x]) {
                DFS(x);
            }
        }
    }

    public static void BFS(int V) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        while(!q.isEmpty()) {
            int cur = q.poll();
            visited[cur] = true;
            BFSArr.add(cur);
            for(int x : lists[cur]) {
                if(!visited[x]) {
                    visited[x] = true;
                    q.offer(x);
                }
            }
        }
    }
}
