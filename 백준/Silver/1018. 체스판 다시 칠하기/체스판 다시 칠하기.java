import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] all;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //가로
        int M = Integer.parseInt(st.nextToken()); //세로
        all = new boolean[N][M]; //흰: true, 검: false

        //기존 체스판
        for (int i = 0; i < N; i++) { //행
            String s = br.readLine();
            for (int j = 0; j <M; j++) { //열
                all[i][j] = s.charAt(j) == 'W'; //흰: true, 검: false
            }
        }

        //최소 칠하기 횟수
        int paint = 9999999;

        for(int i=0;i<=N-8;i++){ //아래로 한칸씩 이동
            for(int j=0;j<=M-8;j++){ //오른쪽으로 한칸씩 이동
                //두 패턴 중 최소값 계산
                int repaintW = countRepaint(i, j, true); //시작이 W인 경우
                int repaintB = countRepaint(i, j, false); //시작이 B인 경우
                //둘중에 작은 값이랑 원래 작은 값이랑 비교
                paint = Math.min(paint, Math.min(repaintW, repaintB));
            }
        }
        System.out.println(paint);
    }

    private static int countRepaint(int x, int y, boolean sc) {
        int repaintCount = 0;

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                boolean expectedColor = (i + j)%2 == 0? sc : !sc;

                //현재 색과 예상 색이 다르면 다시 칠해야 함
                if(all[x+i][y+j] != expectedColor){
                    repaintCount++;
                }
            }
        }
        return repaintCount;
    }
}
