import java.util.*;

public class Main{
    static int N, M;
    static boolean[] visited;
    static ArrayList<Integer>[] lists;
    static int count;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //초기 세팅
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N+1];
        lists = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            lists[i] = new ArrayList<>();
        }
        //데이터 추가
        for(int i = 1; i <= M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            lists[a].add(b);
            lists[b].add(a);
        }

        BFS(1);

        System.out.println(count-1); //1번 컴퓨터 제외

    }

    private static void BFS(int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = true;

        while(!queue.isEmpty()){
            int top = queue.poll();
            count++;
            for(int linked : lists[top]){
                if(!visited[linked]){
                    visited[linked] = true;
                    queue.add(linked);
                }
            }
        }
    }
}
