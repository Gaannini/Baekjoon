import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long res=N;

        for(int i=2;i<=Math.sqrt(N);i++) {
            if(N%i==0){ //i가 N의 소인수인지 확인
                res = res - (res/i); // 결과 갱신
                while(N%i==0){ // n에서 i의 배수 제거
                    N /= i;
                }
            }
            if(i>Math.sqrt(N)) break;
        }

        if(N>1){
            res = res - (res/N);
        }

        System.out.println(res);
    }
}
