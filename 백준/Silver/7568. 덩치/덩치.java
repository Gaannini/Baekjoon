import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] table = new int[2][N];
        int[] rank = new int[N];
        Arrays.fill(rank, 1);

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            table[0][i] = Integer.parseInt(st.nextToken());
            table[1][i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i==j){
                    continue;
                }else{
                    if(table[0][i]<table[0][j] && table[1][i]<table[1][j])
                        rank[i]++;
                }
            }
        }
        for(int i=0;i<N;i++){
            System.out.print(rank[i]+" ");
        }
    }
}
