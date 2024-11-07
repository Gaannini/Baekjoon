import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 상하좌우로 이동할 수 있는 좌표
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static boolean[][] visited;
    static int[][] A;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력받고 배열 저장
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        A = new int[N][M];
        // 데이터 조기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j=0;j<M;j++){
                A[i][j] = Integer.parseInt(s.substring(j,j+1));
            }
        }

        // BFS
        BFS(0, 0);

        //출력
        System.out.println(A[N-1][M-1]);

    }

    private static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y}); //좌표를 큐에 추가
        while(!q.isEmpty()){
            int[] cur = q.poll(); // 큐에 저장한 좌표를 뽑아서 방문처리하고
            visited[x][y] = true; //현재 노드

            //상하좌우 탐색
            for(int k=0;k<4;k++){
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];
                if(nx>=0 && ny>=0 && nx<N && ny<M){ // 배열을 넘어가면 안되고
                    if(!visited[nx][ny] && A[nx][ny]!=0){ // 0이 아니고 방문 안했을 때
                        // 이미 상하좌우 탐색으로 큐에 추가했던 좌표를 중복으로 넣는걸 방지한다.
                        visited[nx][ny] = true;
                        A[nx][ny] = A[cur[0]][cur[1]] + 1; //depth
                        q.add(new int[] {nx, ny}); //큐에 상하좌우 유효한 좌효표 추가
                    }
                }
            }
        }
    }
}
