import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long[] coordinate = new long[N];
        long[] sortedCoordinate = new long[N];
        HashMap<Long, Integer> map = new HashMap<>();

        //좌표 데이터 저장
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            coordinate[i] = Long.parseLong(st.nextToken());
            sortedCoordinate[i] = coordinate[i];
        }
        Arrays.sort(sortedCoordinate); //정렬

        //순위를 저장, 숫자 중복 제거
        int rank = 0;
        for(int i=0;i<N;i++){
            if(!map.containsKey(sortedCoordinate[i])){
                map.put(sortedCoordinate[i], rank);
                rank++;
            }
        }

        //해쉬맵에 저장되어있는 순위 출력을 위해 stringBuilder에 저장
        for(int i=0;i<N;i++){
            sb.append(map.get(coordinate[i])).append(" ");
        }
        
        System.out.println(sb);
    }
}
