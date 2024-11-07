import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visitArr; //방문여부를 저장하는 배열
    static ArrayList<Integer>[] A; //노트의 인접리스트를 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 인접리스트, 방문여부 배열
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //노드의 갯수
        int M = Integer.parseInt(st.nextToken()); //간선의 갯수
        visitArr = new boolean[N+1];      //방문여부를 저장하는 배열
        A = new ArrayList[N+1];

        // N+1만큼의 ArrayList 만들기
        for(int i=1;i<N+1;i++){
            A[i] = new ArrayList<Integer>();
        }

        // 인접리스트에 데이터 채움
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken()); //줄에 첫번째 노드
            int node2 = Integer.parseInt(st.nextToken()); //줄에 두번째 노드
            A[node1].add(node2); // 방향성이 없기때문에 양방향으로 다 저장해준다.
            A[node2].add(node1);
        }

        int count = 0; // 결과값: 연결요소의 갯수

        // DFS실행
        for(int i=1;i<=N;i++){
            if(!visitArr[i]){
                count++;
                DFS(i);
            }
        }
        System.out.print(count);
    }

    private static void DFS(int v) {
        // 현재 노드가 방문 노드일때 리턴
        if(visitArr[v])
            return;
        visitArr[v] = true;
        for(int i : A[v]){
            if(!visitArr[i])
                DFS(i);
        }

    }
}
