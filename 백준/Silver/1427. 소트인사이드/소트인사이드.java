import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        String str = sc.next();
        int[] A = new int[str.length()];
        for(int i=0;i<str.length();i++){
            A[i] = Integer.parseInt(str.substring(i, i+1));
        }

        // 선택 정렬(Selection Sort)
        for(int i=0;i<str.length();i++){
            int idx = i;
            for(int j=i;j<str.length();j++){
                if (A[idx] < A[j]) {
                    idx = j;
                }
            }
            int temp = A[idx];
            A[idx] = A[i];
            A[i] = temp;
        }
        
        // 출력
        for(int i=0;i<str.length();i++)
            System.out.print(A[i]);
    }
}

