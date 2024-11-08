import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //시작
        int M = sc.nextInt(); //끝
        int[] A = new int[M+1];
        Arrays.setAll(A, i -> i); //1~m까지 숫자 채우기

        // 에라토스테네스 원리
        for(int i=1;i<=Math.sqrt(M);i++) {
            if(A[i]==1) { //1은 제외
                A[i] = 0; // 배열에서 지우는걸 0으로 대체
                continue;
            }else if(A[i]==0){ //이미 제거된건 제외
                continue;
            }else{
                for(int j=2;;j++){
                    if(i*j<=M){
                        A[i*j] = 0; //본인을 제외하고 배수들을 제거
                    }else{
                        break;
                    }
                }
            }
        }
        for(int i=N;i<=M;i++) {
            if(A[i]!=0) {
                System.out.println(A[i]);
            }
        }
    }
}
