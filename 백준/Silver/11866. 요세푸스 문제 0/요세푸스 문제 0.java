import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //사람수
        int K = sc.nextInt(); //제거수
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++) q.add(i);

        for(int i=0;i<N;i++) {
            for(int j=1;j<K;j++) {
                q.add(q.poll());
            }
            if(q.size()==1) sb.append(q.poll());
            else sb.append(q.poll()).append(", ");
        }

        System.out.print("<"+sb+">");
    }
}
