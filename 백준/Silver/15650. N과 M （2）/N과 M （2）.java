import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    static void Func(int start, int depth, int[] arr){
        //종료 조건
        if(depth == M){
            for(int i = 0 ; i < M ; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        //순회
        for(int i = start; i <= N; i++){
            arr[depth] = i;
            Func(i + 1, depth + 1, arr);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M+1];

        Func(1, 0, arr);


    }
}