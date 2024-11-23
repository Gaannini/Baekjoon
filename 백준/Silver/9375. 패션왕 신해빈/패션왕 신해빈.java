import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); //테스트케이스

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); //의상갯수
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String wearName = st.nextToken();
                String wearType = st.nextToken();
                if(map.containsKey(wearType)) map.put(wearType, map.get(wearType) + 1);
                else map.put(wearType, 1);
            }

            int result = 1;
            for(int num : map.values())
                result *= (num+1);

            System.out.println(result - 1);
        }

    }
}
