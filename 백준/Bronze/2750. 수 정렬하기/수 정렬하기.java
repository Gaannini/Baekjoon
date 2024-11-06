import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++){
            A[i] = sc.nextInt();
        }

        // 정렬하기
        for(int i=0;i<N;i++){
            int num = 0;
            for(int j = 0;j<N-i-1;j++){
                if(A[j]<A[j+1]){
                    continue;
                }else{
                    int swap = A[j];
                    A[j] = A[j+1];
                    A[j+1] = swap;
                    num++;
                }
            }
            if(num==0)
                break;
        }

        // 출력
        for(int i=0;i<N;i++){
            System.out.println(A[i]);
        }
    }
}
