import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int N, M;
    static boolean[][] visited;
    static char[][] campus;
    static Queue<int[]> q = new LinkedList<>();
    static int meet = 0; //만난사람
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로
        visited = new boolean[N][M]; //방문 배열
        campus = new char[N][M]; //캠퍼스 배열
        int dox = 0, doy = 0;

        //캠퍼스 배열 저장
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = s.charAt(j);
                if(campus[i][j] == 'I') {
                    dox = i;
                    doy = j;
                }
            }
        }
        BFS(dox, doy);
        System.out.println(meet!=0 ? meet : "TT");
    }

    private static void BFS(int dox, int doy) {
        q.add(new int[]{dox, doy});
        visited[dox][doy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            if(campus[curX][curY] == 'P') meet++; //사람을 만났을경우

            //상하좌우 탐색
            for(int k = 0; k < 4; k++) {
                int x = curX + dx[k];
                int y = curY + dy[k];

                //1. 범위를 벗어난 경우, 2. 방문한 경우, 3. 벽인 경우
                if(x < 0 || x >= N || y < 0 || y >= M || visited[x][y] || campus[x][y] == 'X') continue;

                q.offer(new int[]{x, y});
                visited[x][y] = true;
            }
        }

    }
}
