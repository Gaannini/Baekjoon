import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); //전체 도시 수
        int M = Integer.parseInt(br.readLine()); //여행할 도시 수
        parent = new int[N+1];
        Arrays.setAll(parent, i -> i);

        //도시 연결
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                int x = Integer.parseInt(st.nextToken());
                if(x == 1){
                    Union(i, j); // 연결된거끼리 union연산
                }
            }
        }

        boolean possible = true;
        // 여행할 곳 배열
        int[] travel = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            travel[i] = Integer.parseInt(st.nextToken());
        }
        // 여행이 가능한지 판단 차례대로 find연산해서 root가 모두 같으면 YES
        for(int i=0;i<M-1;i++){
            if(find(travel[i])!=find(travel[i+1])){
                possible = false;
                break;
            }
        }
        if(possible) System.out.println("YES");
        else System.out.println("NO");

    }

    private static void Union(int i, int j) {
        int iL = find(i);
        int jL = find(j);
        if(iL != jL){
            parent[iL] = jL;
        }
    }

    private static int find(int i) {
        if(parent[i]==i)
            return i;
        return parent[i] = find(parent[i]);
    }
}
