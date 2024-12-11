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
        int[] fruit = new int[N];
        HashMap<Integer, Integer> fruitKind = new HashMap<>();

        //과일 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) fruit[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int max = 0;

        for(int right = 0; right < N; right++){
            //getOrDefault : 특정 키가 맵에 존재하면 그 값을 반환하고, 존재하지 않으면 기본값(0)을 반환
            fruitKind.put(fruit[right], fruitKind.getOrDefault(fruit[right], 0) + 1);
            
            //과일 종류가 2개를 초과할 경우
            while(fruitKind.size() > 2){
                //구간 첫번째부터 순회하며 카운트 감소
                fruitKind.put(fruit[left], fruitKind.get(fruit[left]) - 1); 
                //만약 해당 종류의 과일이 0개가 되면 hashmap에서 지움
                if(fruitKind.get(fruit[left]) == 0) fruitKind.remove(fruit[left]);
                //구간축소
                left++;
            }
            // 가장 큰 구간 구하기
            max = Math.max(max, right - left + 1);
        }
        System.out.println(max);
    }
}
