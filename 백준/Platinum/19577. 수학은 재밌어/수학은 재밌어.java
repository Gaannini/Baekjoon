import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static ArrayList<Long> divisors;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        //수학적으로 i * 𝝓(i) = N을 만족하려면 i는 N의 약수여야 한다.
        Divisors(N);

        for(long i : divisors){
            if(i*EulersPhi(i)==N){
                System.out.println(i);
                return;
            }
        }

        System.out.println("-1");
    }

    private static void Divisors(long n) {
        divisors = new ArrayList<>();
        for(long i = 1;i<=Math.sqrt(n);i++) {
            if(n%i==0) {
                divisors.add(i);
                if(i!=n/i){ //제곱수가 아니면
                    divisors.add(n/i); //수와 곱해지는 수 또한 약수
                }
            }
        }
    }

    private static long EulersPhi(long N) {
        long res = N;
        for(long i = 2;i*i<=N;i++) {
            if(N%i==0) {
                res -= res/i;
                while(N%i==0) 
                    N /= i;
            }
        }
        if(N>1) res = res - res/N; //마지막 남은 소인수 처리
        return res;
    }
}
