import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2)->{
            // 정렬 로직
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            // 절댓값이 같으면 음수 우선
            if(first_abs == second_abs){
                return o1 > o2 ? 1 : -1;
            }
            // 절댓값 작은 데이터
            return first_abs - second_abs;
        });

        for(int i=0;i<N;i++){
            int request = Integer.parseInt(br.readLine());
            if(request == 0){
                if(que.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(que.poll());
            }else{
                que.add(request);
            }
        }

    }
}
