import java.util.Scanner;

//1, 2, 3 더해서 숫자 만들기(순열)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] dp = new int[11]; // 최대 숫자가 10
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            for(int j = 4; j <= N; j++) 
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];

            System.out.println(dp[N]);
        }
    }
}