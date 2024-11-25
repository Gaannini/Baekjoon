import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //연산개수
        int N = Integer.parseInt(br.readLine());
        //최소힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //최대힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(minHeap.isEmpty()) sb.append("0").append("\n");
                else sb.append(minHeap.poll()).append("\n");
            }else minHeap.add(x);
        }
        System.out.println(sb);
    }
}
