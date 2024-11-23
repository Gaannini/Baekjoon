import java.util.Arrays;
import java.util.Scanner;

//계단 오르기
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stairs = new int[n+1];
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) stairs[i] = sc.nextInt();

        if(n==1){
            System.out.print(stairs[1]);
            return;
        }else if(n==2){
            System.out.print(stairs[1] + stairs[2]);
            return;
        }else if(n==3) {
            int max = Math.max(stairs[3] + stairs[1], stairs[3] + stairs[2]);
            System.out.print(max);
            return;
        }

        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        dp[3] = Math.max(stairs[3] + dp[1], stairs[3] + stairs[2]);

        // 두 계단 전에서 오는 경우 : dp[i-2] + stairs[i]
        // 바로 전에서 오는 경우 : dp[i-3] + stairs[i-1] + stairs[i]
        for(int i=4;i<=n;i++)
            dp[i] = Math.max(dp[i-2], dp[i-3] + stairs[i-1]) + stairs[i];

        System.out.println(dp[n]);
    }
}
