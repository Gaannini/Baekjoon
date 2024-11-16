import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] DP = new int[N]; //해당
        Arrays.fill(DP, 1);
        Arrays.setAll(A, i -> sc.nextInt());

        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(A[i]>A[j]){
                    DP[i] = Math.max(DP[i], DP[j]+1);
                }
            }
        }
        int max = DP[0];
        for(int i=0;i<N;i++){
            if(DP[i]>max){
                max = DP[i];
            }
        }
        System.out.println(max);
    }
}
