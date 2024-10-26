import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    static void Func(int depth, boolean[] visited, int[] arr){
        //종료 조건
        if(depth == M){
            for(int i = 0 ; i < M ; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        //순회
        for(int i = 1; i <= N; i++){
            if(visited[i]) continue;

            arr[depth] = i;
            visited[i] = true;
            Func(depth + 1, visited, arr);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M+1];
        boolean[] visited = new boolean[N+1];

        for(int i = 0; i < M; i++){
            visited[i] = false;
        }

        Func(0, visited, arr);


    }
}