import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] paper;
    static int blue, white = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dividePaper(0, 0, N);

        System.out.println(white+"\n"+blue);
    }

    public static void dividePaper(int x, int y, int size) {
        boolean sameColor = check(x, y, size);
        if(sameColor) {
            if(paper[x][y] == 1) blue++;
            else white++;
        }else{
            dividePaper(x, y+(size/2), size/2);
            dividePaper(x+(size/2), y, size/2);
            dividePaper(x+(size/2), y+(size/2), size/2);
            dividePaper(x, y, size/2);
        }
    }

    public static boolean check(int x, int y, int size) {
        int first = paper[x][y];
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(paper[i][j]!=first)
                    return false;
            }
        }
        return true;
    }
}
