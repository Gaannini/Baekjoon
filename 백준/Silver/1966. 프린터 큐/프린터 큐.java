import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //테스트 케이스
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //문서 개수
            int M = Integer.parseInt(st.nextToken()); //몇번째에 놓여있는지

            //문서를 저장
            Queue<int[]> q = new LinkedList<>();
            //우선순윙를 저장
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int x = Integer.parseInt(st.nextToken());
                q.add(new int[]{j,x}); // 인덱스랑 우선순위 저장
                pq.add(x); //우선순위만 저장
            }

            int count = 0;
            while(!q.isEmpty()){
                int[] current = q.poll();

                if(current[1] == pq.peek()){
                    count++;
                    pq.poll();

                    if(current[0]==M){
                        System.out.println(count);
                        break;
                    }
                }else{
                    q.add(current);
                }
            }
        }
    }
}
