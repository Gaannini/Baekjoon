import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //듣도 못한 사람
        int M = Integer.parseInt(st.nextToken()); //보도 못한 사람
        HashSet<String> noHear = new HashSet<>();
        List<String> noHearSee = new ArrayList<>();

        for(int i = 0; i < N; i++)
            noHear.add(br.readLine());

        for(int i = 0; i < M; i++) {
            String s = br.readLine();
            if(noHear.contains(s)) {
                noHearSee.add(s);
            }
        }

        Collections.sort(noHearSee);

        System.out.println(noHearSee.size());
        for (String s : noHearSee) System.out.println(s);

    }
}
