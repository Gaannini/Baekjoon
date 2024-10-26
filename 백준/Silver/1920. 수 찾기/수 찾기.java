import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0;i < M;i++) {
            boolean flag = false;
            int left = 0, right = N - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if(B[i] == A[mid]) {
                    flag = true;
                    break;
                }else if(B[i]<A[mid]){
                    right = mid-1;
                }else if((B[i]>A[mid])){
                    left = mid+1;
                }
            }
            if(flag){
                System.out.println("1");
            }else {
                System.out.println("0");
            }
        }
    }
}
