import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int M = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch (s) {
                case "add":
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    if(set.contains(Integer.parseInt(st.nextToken()))) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "toggle":
                    int num = Integer.parseInt(st.nextToken());
                    if(set.contains(num)) set.remove(num);
                    else set.add(num);
                    break;
                case "all":
                    set.clear();
                    for(int j=1;j<=20;j++) set.add(j);
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        System.out.println(sb);
    }
}