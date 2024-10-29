import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 재료의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // 갑옷을 만드는데 필요한 수
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        // 재료들 배열
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A); // 정렬 O(nlogn)

        int count = 0;
        int start_idx = 0;
        int end_idx = N-1;
        int sum = 0;

        while(start_idx<end_idx){
            sum = A[start_idx]+A[end_idx];
            if(sum<M){
                start_idx++;
            }else if(sum>M) {
                end_idx--;
            }else{
                count++;
                start_idx++;end_idx--;
            }
        }
        System.out.println(count);
    }
}
