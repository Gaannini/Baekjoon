import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        long[] dp = new long[101];

        dp[1] = 1; dp[2] = 1; dp[3] = 1; dp[4] = 2; dp[5] = 2;
        for(int j=6; j<=100; j++) dp[j] = dp[j-5] + dp[j-1];

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}
