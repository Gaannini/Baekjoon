import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] A = s.split("-");
        int result = 0;

        // '-'를 기준으로 나눈다
        for(int i=0;i<A.length;i++){
            if(i==0){ //첫번째나오는 숫자는 무조건 더해줌
                result += SumFun(A[i]);
            }else{ //이 외에 수식이나 숫자는 계산해서 빼줌
                result -= SumFun(A[i]);
            }
        }
        System.out.println(result);
    }

    // 문자열을 +기준으로 나누고 다 더해서 반환한다.
    private static int SumFun(String s) {
        String[] nums = s.split("\\+");
        int sum = 0;
        for (String num : nums)
            sum += Integer.parseInt(num);
        return sum;
    }
}
