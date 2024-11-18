import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++){
            map1.put(i, br.readLine());
            map2.put(map1.get(i), i);
        }


        for (int i = 1; i <= M; i++) {
            String s = br.readLine();
            if(!s.matches("[+-]?\\d*(\\.\\d+)?")) //숫자 형식인지
               sb.append(map2.get(s)).append("\n");
            else
                sb.append(map1.get(Integer.parseInt(s))).append("\n");

        }
        System.out.println(sb);
    }
}
