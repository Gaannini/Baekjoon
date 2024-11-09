import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack<Integer> sort = new Stack();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //학생 수
        int M = Integer.parseInt(st.nextToken()); //비교할 수

        // 진입차수배열 & 인접리스트
        int[] D = new int[N + 1];
        ArrayList<Integer>[] A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        // 비교할 횟수만큼 반복
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[b].add(a); //내 앞에 오는 사람으로 연결
            D[a]++; //진입차수 더해줌
        }

        Topology(A, D);

        for(int i = 0; i < N; i++) {
            System.out.print(sort.pop()+" ");
        }
    }

    private static void Topology(ArrayList<Integer>[] a, int[] d) {
        //진입차수가 0이면 배열에 추가
        for(int i = 1; i < d.length; i++) {
            if(d[i] == 0) {
                sort.add(i);
            }
        }

        int idx = 0;
        while(idx < sort.size()) {
            int curr = sort.get(idx); //정렬된 리스트에서 현재 노드 가져오기
            idx++;

            //현재 노드와 연결된 노드들의 진입 차수를 줄이고 0이 되면 추가
            for(int next : a[curr]) {
                d[next]--;
                if(d[next] == 0) {
                    sort.add(next);
                }
            }
        }
    }
}
