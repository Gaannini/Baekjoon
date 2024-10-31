import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] myCondition; // 현재 검사하는 문자열이 충족하는 조건
    static int[] condition; // 비밀번호 조건
    static int checkSecret; // 4가지 조건중 몇개가 맞는지
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken()); // 전체 문자열 크기
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열 크기
        int result = 0; // 비밀번호 종류의 수
        checkSecret = 0; // 조건 4개중에 맞은 수

        // 전체 문자열
        char[] A = new char[S];
        A = br.readLine().toCharArray();

        // 체크할 배열과 비밀번호를 실제 체크한 배열
        myCondition = new int[4];
        condition = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            condition[i] = Integer.parseInt(st.nextToken());
            if(condition[i]==0){
                checkSecret++;
            }
        }
        
        for(int i=0;i<P;i++){
            Add(A[i]);
        }

        if(checkSecret == 4) result++;

        // 슬라이딩 윈도우
        for(int i=P;i<S;i++){
            int j = i-P;
            Add(A[i]);
            Sub(A[j]);
            if(checkSecret == 4) result++;
        }

        System.out.println(result);
        br.close();
    }

    private static void Sub(char c) {
        switch (c){
            case 'A':
                if(myCondition[0]==condition[0])
                    checkSecret--;
                myCondition[0]--;
                break;
            case 'C':
                if(myCondition[1]==condition[1])
                    checkSecret--;
                myCondition[1]--;
                break;
            case 'G':
                if(myCondition[2]==condition[2])
                    checkSecret--;
                myCondition[2]--;
                break;
            case 'T':
                if(myCondition[3]==condition[3])
                    checkSecret--;
                myCondition[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch (c){
            case 'A':
                myCondition[0]++;
                if(myCondition[0]==condition[0])
                    checkSecret++;
                break;
            case 'C':
                myCondition[1]++;
                if(myCondition[1]==condition[1])
                    checkSecret++;
                break;
            case 'G':
                myCondition[2]++;
                if(myCondition[2]==condition[2])
                    checkSecret++;
                break;
            case 'T':
                myCondition[3]++;
                if(myCondition[3]==condition[3])
                    checkSecret++;
                break;
        }
    }
}
