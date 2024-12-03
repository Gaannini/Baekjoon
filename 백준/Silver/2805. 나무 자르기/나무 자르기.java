import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        long[] trees = new long[(int) N];
        long bottom = 0, top = 0, mid = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            trees[i] = Integer.parseInt(st.nextToken());
            top = Math.max(top, trees[i]);
        }

        while(top>bottom){
            mid = (top + bottom)/2;
            long count=0;
            for(long tree : trees){
                if(tree>mid) count += tree - mid;   //나무의 길이가 자를 높이보다 큰 경우(자른 길이를 더함)
            }
            if(count>=M) bottom = mid + 1; //자른 길이가 필요한 길이보다 긴 경우
            else top = mid; //자른 길이가 필요한 길이보다 작은 경우
        }
        System.out.println(bottom-1);
    }
}
