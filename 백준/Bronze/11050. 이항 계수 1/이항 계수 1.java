import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //조합 점화식 : A[i][j] = A[i-1][j] + A[i-1][j-1]
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] DP = new int[N+1][N+1];

        //기본 초기화
        for (int i = 0; i <= N; i++) {
            DP[i][1] = i;
            DP[i][0] = 1;
            DP[i][i] = 1;
        }
        for(int i=3;i<=N;i++){
            for(int j=2;j<=i;j++){
                DP[i][j] = DP[i-1][j-1] + DP[i-1][j];
            }
        }

        System.out.println(DP[N][K]);
    }
}
