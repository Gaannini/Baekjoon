import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        int[] dp = new int[N + 1];
        dp[0] = dp[1] = 0;

        for(int i = 2; i <= N; i++) {
            // DP[i] = DP[i-1] + 1
            dp[i] = dp[i - 1] + 1; //i-1의 연산에 -1을 한거 -> +1
            //2로 나누어 떨어지는 경우
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
                //3으로 나누어 떨어지는 경우
            }if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        /*6의 경우
        6-1을 1로 만들기 위해서는 dp[5] + 1(1을 더하는 연산)
        6/2를 1로 만들기 위해서는 dp[3] + 1(2를 곱하는 연산)
        6/3을 1로 만들기 위해서는 dp[2] + 1(3을 곱하는 연산)
        */

        System.out.println(dp[N]);
    }
}
