import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //동전 종류의 갯수
        int K = Integer.parseInt(st.nextToken()); //만들어야하는 금액
        int[] A = new int[N]; //동전의 가치를 담을 배열
        for(int i=N-1;i>=0;i--){
            A[i] = Integer.parseInt(br.readLine());
        }

        // 동전을 큰 가치부터 소모
        int num=0;
        for(int i=0;i<N;i++){
            num += K / A[i];
            K %= A[i];
            if(K==0)
                break;
        }

        System.out.println(num);
    }
}
