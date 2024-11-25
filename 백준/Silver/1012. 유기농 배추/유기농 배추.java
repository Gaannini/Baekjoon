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

    static boolean[][] field;
    static boolean[][] visited;
    static int M, N, K; // 가로, 세로, 배추
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); //테스트케이스

        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); //가로
            N = Integer.parseInt(st.nextToken()); //세로
            K = Integer.parseInt(st.nextToken()); //배추개수
            field = new boolean[M][N]; //밭
            visited = new boolean[M][N]; //방문여부
            int count = 0; //집합개수

            for(int j=0;j<K;j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = true;
            }

            for(int a=0;a<M;a++){
                for(int b=0;b<N;b++){
                    if(field[a][b] && !visited[a][b]){ //배추가 있고 방문 안한곳
                        count++;
                        BFS(a,b);
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y}); // 좌표를 큐에 추가
        visited[x][y] = true; //현재 노드 방문 처리

        while(!q.isEmpty()){
            int[] cur = q.poll(); // 큐에 저장한 좌표를 뽑아서 방문처리하고
            int curX = cur[0];
            int curY = cur[1];

            //상하좌우 탐색
            for(int k=0;k<4;k++){
                int nx = curX + dx[k];
                int ny = curY + dy[k];
                if(nx>=0 && ny>=0 && nx<M && ny<N){ // 배열을 넘어가면 안되고
                    if(!visited[nx][ny] && field[nx][ny]){ // 0이 아니고 방문 안했을 때
                        // 이미 상하좌우 탐색으로 큐에 추가했던 좌표를 중복으로 넣는걸 방지한다.
                        visited[nx][ny] = true;
                        q.add(new int[] {nx, ny}); //큐에 상하좌우 유효한 좌효표 추가
                    }
                }
            }
        }
    }
}
