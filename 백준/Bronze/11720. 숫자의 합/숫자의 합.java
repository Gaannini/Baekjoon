import java.util.Scanner;

public class Main {
    // 11720 : 숫자의 합 구하기
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // N값 입력받기
        int N = sc.nextInt();

        // N값 길이만큼의 String형 변수 저장
        String Snum = sc.next();

        // String 변수를 char[] 배열에 저장
        char[] cNum = Snum.toCharArray();

        // 배열의 각 값을 더한다.
        int sum = 0; // 숫자의 합을 저장할 변수

        for(int i = 0; i < N ; i++){
            sum += cNum[i] - '0'; // '1' = 49, '0' = 48
        }
        System.out.print(sum);
    }
}
