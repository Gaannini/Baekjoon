import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫번째 배열 입력 받기 & 정렬
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int left;
        int right;
        int mid;

        // 찾기
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boolean exist = false;
            left = 0;
            right = N-1;
            // 각각을 검사할거임
            int x = Integer.parseInt(st.nextToken());
            for(int j=0;left<=right;j++){
                mid = (left+right)/2;
                if(x>A[mid]){
                    left = mid+1;
                }else if(x<A[mid]){
                    right = mid-1;
                }else{
                    exist = true;
                    break;
                }
            }
            if(exist)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
