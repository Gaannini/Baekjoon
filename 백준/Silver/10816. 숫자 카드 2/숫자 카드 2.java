import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            long key = Long.parseLong(st.nextToken());
            if(map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            }else{
                map.put(key, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            long key = Long.parseLong(st.nextToken());
            //찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환
            sb.append(map.getOrDefault(key, 0)).append(" ");
        }
        System.out.println(sb);
    }
}
