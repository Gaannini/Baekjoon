import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        int[] A = new int[(int) N];
        int sum = 0;
        long exclude = Math.round(N*0.15); //절사평균에서 제외되는...

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
            sum+=A[i];
        }
        Arrays.sort(A);
        for(int i=0;i<exclude;i++){
            sum-=A[i];
            sum-=A[(int) (N-1-i)];
        }

        int result = (int) Math.round((double) sum / (N-exclude*2));
        System.out.println(result);
    }
}
