import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];

        for(int i=1;i<=N;i++){
            dp[i] = i;
            for(int j=1;j*j<=i;j++){
                //어떤 수에 제곱수를 더하는 게 제일 작은가 판별
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        System.out.println(dp[N]);
    }
}
