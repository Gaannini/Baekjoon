import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long swap = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력받기
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            A[i] = Integer.parseInt(st.nextToken());

        // 병합정렬
        mergeSort(A, 0, N-1);

        // 결과 출력 (정렬된 배열 확인)
//        for (int i = 0; i < N; i++) {
//            System.out.print(A[i] + " ");
//        }
//        System.out.print("swap : "+swap);
        System.out.print(swap);
    }
    private static void mergeSort(int[] A, int S, int E){
        if(S<E){
            int mid = (S+E)/2;
            mergeSort(A, S, mid);
            mergeSort(A, mid+1, E);

            Merge(A, S, mid, E);
        }
    }

    private static void Merge(int[] A, int s, int mid, int e) {
        int[] sorted = new int[e-s+1];
        // 투포인터 사용
        int i = s;
        int j = mid+1;
        int idx = 0; //sorted배열 인덱스
        while(i<=mid && j<=e){
            if(A[i]<=A[j]) {
                sorted[idx++] = A[i++];
            }
            else{
                if(idx<j){
                    swap += (mid-i+1); //mid값은 첫번째 배열의 마지막 인덱스임
                }
                sorted[idx++] = A[j++];
            }
        }
        while(i<=mid){
            sorted[idx++] = A[i++];
        }
        while(j<=e){
            sorted[idx++] = A[j++];
        }
        // 원본 배열에 복사
        for(i = s, idx=0;i<=e;i++, idx++) {
            A[i] = sorted[idx];
        }
    }
}
