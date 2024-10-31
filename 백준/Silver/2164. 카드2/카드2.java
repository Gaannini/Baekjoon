import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Queue<Integer> Que = new LinkedList<>();
        for(int i=1;i<=N;i++){
            Que.add(i);
        }

        while(Que.size()>1){
            Que.remove();
            int floor = Que.poll();
            Que.add(floor);
        }
        System.out.print(Que.poll());
    }
}
