import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static long[][] GraphEdge; //에지 정보 저장
    static long[] parent; //유니온 파인드 저장
    static long cost = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); //노드
        E = Integer.parseInt(st.nextToken()); //간선
        parent = new long[V+1];

        // parent 배열 초기화
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        // 에지 정보 입력
        GraphEdge = new long[E][3];
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            GraphEdge[i][0] = Integer.parseInt(st.nextToken()); //노드 1
            GraphEdge[i][1] = Integer.parseInt(st.nextToken()); //노드 2
            GraphEdge[i][2] = Integer.parseInt(st.nextToken()); //가중치
        }
        //가중치를 기준으로 오름차순 정렬
        Arrays.sort(GraphEdge, (a, b) -> Long.compare(a[2], b[2]));

        Kruskal();

        System.out.println(cost);

    }

    private static void Kruskal() {
        int node = 0;
        for(int i=0;i<E;i++){
            if(node==V-1){
                break;
            }
            long n1 = find(GraphEdge[i][0]); 
            long n2 = find(GraphEdge[i][1]);
            if(n1!=n2){
                union((int) GraphEdge[i][0], (int) GraphEdge[i][1]);
                cost+=GraphEdge[i][2];
                node++;
            }
        }
    }

    private static long find(long a) {
        if(parent[(int) a]==a) return a;
        else return parent[(int) a]=find(parent[(int) a]);
    }

    private static void union(int i, int j) {
        long iRoot = find(i);
        long jRoot = find(j);
        if(iRoot!=jRoot) parent[(int) iRoot]=jRoot;
    }
}
