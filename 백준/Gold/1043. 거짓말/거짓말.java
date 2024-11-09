import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] parent; //부모배열
    static boolean[] truth; //진실을 아는 사람 여부
    static ArrayList<int[]> parties; //각 파티에 참석한 사람
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //사람수
        int m = sc.nextInt(); //파티수
        int num = sc.nextInt(); //진실아는사람수

        parent = new int[n+1]; //유니온파인드
        truth = new boolean[n+1]; //진실을 아는사람
        parties = new ArrayList<>(); // 각 파티에 참석한 사람들

        Arrays.setAll(parent, i->i);

        //진실아는사람
        int[] truthPeople = new int[num];
        for (int i = 0; i < num; i++) {
            truthPeople[i] = sc.nextInt();
            truth[truthPeople[i]] = true;
        }

        //파티에 참석한 사람 저장 & 정보 입력
        for(int i=0;i<m;i++){
            int x = sc.nextInt();
            int[] party = new int[x];
            for(int j=0;j<x;j++){
                party[j] = sc.nextInt();
                if(j>0){
                    union(party[0], party[j]); //0번과 j번 union연산 : 0번과 모두 연결하면 모두 같은 집합이 된다.
                }
            }
            parties.add(party);
        }

        // 진실을 아는 사람들과 연결된 모든 사람
        for(int person : truthPeople){
            int root = find(person);
            for(int i=1;i<=n;i++){
                if(find(i) == root)
                    truth[i] = true; //같은 그룹 사람들은 모두 진실을 안다.
            }
        }

        int count = 0;
        for(int[] party : parties){
            boolean canLie = true;
            for(int person : party){
                if(truth[find(person)]){
                    canLie = false;
                    break;
                }
            }
            if(canLie) count++;
        }
        System.out.println(count);
    }

    private static void union(int i, int j) {
        if(find(i) != find(j))
            parent[find(j)] = find(i);
    }
    private static int find(int x) {
        if(x != parent[x])
            parent[x] = find(parent[x]);
        return parent[x];
    }
}
