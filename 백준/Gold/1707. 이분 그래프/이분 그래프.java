import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean IsEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); //노드
            int E = Integer.parseInt(st.nextToken()); //간선

            // 인접리스트 & 체크 & 방문여부 & 이분그래프 여부
            A = new ArrayList[V+1];
            for(int j=1;j<=V;j++){
                A[j] = new ArrayList<Integer>();
            }
            check = new int[V+1]; // 이분그래프 집합 표현 (0, 1)
            visited = new boolean[V+1]; // 방문 여부 체크 배열
            IsEven = true;

            //인접리스트 데이터 삽입
            for(int j=0;j<E;j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                A[a].add(b);
                A[b].add(a);
            }

            //모든 노드에서 DFS 실행
            for(int j=1;j<=V;j++){
                if(IsEven){
                    DFS(j);
                }else{
                    // 이분그래프가 아닌게 하나라도 있으면 이분그래프가 아닌것ㅇ으로 판단
                    break;
                }
            }
            if(IsEven) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static void DFS(int start) {
        visited[start] = true; //방문한 노드를 체크
        for(int i : A[start]){ //인접리스트 : start에 연결된 모든 노드 탐색
            if(!visited[i]){
                //바로 직전 노드와 다른 집합으로 분류(0, 1)
                check[i] = (check[start] + 1) % 2;
                DFS(i); //재귀
            }else if(check[start] == check[i]){ //만약 방문한 노드인데 시작과 같은 집합일 경우
                IsEven = false; //이분그래프 아님
            }
        }
    }
}
