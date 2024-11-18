import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 최대 n의 범위를 고려한 DP 배열 생성
        int[][] dp = new int[41][2]; // [0]: 0 호출 횟수, [1]: 1 호출 횟수

        // 초기 값 설정
        dp[0][0] = 1; // fibonacci(0) => 0 호출 횟수
        dp[0][1] = 0; // fibonacci(0) => 1 호출 횟수
        dp[1][0] = 0; // fibonacci(1) => 0 호출 횟수
        dp[1][1] = 1; // fibonacci(1) => 1 호출 횟수

        for(int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0]; //0호출횟수
            dp[i][1] = dp[i-1][1] + dp[i-2][1]; //1호출횟수
        }

        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }
        System.out.println(sb);
    }
}
