import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long B;
    static int[][] block;
    static int time, height;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로
        B = Long.parseLong(st.nextToken()); //가지고 있는 블록
        time = Integer.MAX_VALUE;
        height = 0;
        int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE;
        block = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                block[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, block[i][j]);
                min = Math.min(min, block[i][j]);
            }
        }
        int diff = max - min;

        for(int i = 0; i <= diff; i++) {
            int t = 0;
            long b = B;
            for(int j = 0; j < N; j++) {
                for(int a : block[j]) {
                    if(a > min) {
                        t += (a - min) * 2;
                        b += (a-min);
                    }else if(a < min){
                        b-= min - a;
                        t += (min - a);
                    }
                }
            }
            if(t < time && b >= 0){
                time = t;
                height = min;
            }else if(t == time && b >= 0){
                height = Math.max(height, min);
            }
            min++;
        }

        System.out.println(time + " " + height);
    }
}
