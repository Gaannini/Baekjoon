import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력받기, 필요한 변수와 배열 선언
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N]; // P(i)값
        int[] S = new int[N]; // 누적합
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++)
            A[i] = Integer.parseInt(st.nextToken());

        // 삽입 정렬(Selection Sort)
        for(int i=1;i<N;i++){
            int select = A[i];
            // 이진탐색
            int idx = BinarySearch(A, 0, i-1, select);
            for(int j=i-1;j>=idx;j--)
                A[j+1] = A[j];
            A[idx] = select;
        }

        // 누적합
        for(int i=0;i<N;i++){
            if(i==0)
                S[i] = A[i];
            else
                S[i] = S[i-1]+A[i];
        }

        // 누적합의 합 계산
        int time = 0;
        for(int i=0;i<N;i++)
            time+=S[i];

        // 출력
        System.out.print(time);
    }

    // 이진탐색
    private static int BinarySearch(int[] A, int left, int right, int select) {
        int mid=0;
        while(left<=right){
            mid = (left+right)/2;
            if(A[mid]<=select)
                left = mid+1;
            else if(A[mid]>select)
                right = mid-1;
        }
        return left;
    }
}
