import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] list;
    static int[] parent;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); //노드의 갯수
        parent = new int[N+1]; //부모를 저장하는 배열
        visited = new boolean[N+1];
        Arrays.fill(visited, false); //모두 방문 안한걸로 채움
        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) { //인접리스트
            list[i] = new ArrayList<>();
        }

        // 인접리스트 데이터 저장
        for(int i=1;i<N;i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            list[n1].add(n2);
            list[n2].add(n1);
        }

        saveRoot();
        for(int i=2;i<=N;i++){
            System.out.println(parent[i]);
        }
    }

    private static void saveRoot() {
        for(int i=1;i<N;i++){
            if(!visited[i])
                DFS(i);
        }
    }

    private static void DFS(int i) {
        if(visited[i]) return; //방문한 노드일 때는 return
        visited[i] = true;
        for(int n : list[i]){
            if(!visited[n]){
                parent[n] = i;
                DFS(n);
            }
        }
    }
}
