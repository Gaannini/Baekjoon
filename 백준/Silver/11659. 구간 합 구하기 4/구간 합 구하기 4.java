import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 주어질 숫자의 갯수
        int M = sc.nextInt();   // 구간합 연산 갯수

        int[] A = new int[N];   // 숫자들 배열
        int[] S = new int[N];   // 구간 합 배열
        int[][] Gugan = new int[M][2]; // 구간 저장

        // 배열 채우기
        for(int i=0;i<N;i++){
          A[i] = sc.nextInt();
        }

        // 구간 합 배열 채우기
        for(int i=0;i<N;i++){
            if(i==0) S[i] = A[i];
            else S[i] = S[i-1] + A[i];
        }

        // 구간 받기
        for(int i=0;i<M;i++){
            Gugan[i][0] = sc.nextInt();
            Gugan[i][1] = sc.nextInt();
        }

        // 구간 합 구하고 출력 S[j] - S[i-1]
        for(int i=0;i<M;i++){
            int fir = Gugan[i][0]-1;
            int end = Gugan[i][1]-1;
            if(fir==0) System.out.println(S[end]);
            else System.out.println(S[end] - S[fir-1]);
        }

    }
}
