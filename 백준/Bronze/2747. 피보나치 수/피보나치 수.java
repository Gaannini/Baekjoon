import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] D;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        D = new int[N+1];
        Arrays.fill(D, -1);
        D[0] = 0;
        D[1] = 1;
        fib(N);
        System.out.print(D[N]);
    }
    //피보나치 배열 채우기
    public static int fib(int n) {
        if(D[n] != -1) return D[n]; //계산을 이미 했으면 그냥 리턴
        return D[n] = fib(n-1) + fib(n-2);
    }
}
