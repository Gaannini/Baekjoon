import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 결과를 저장할 배열(0으로 초기화)
		int[] result = new int[26];
		Arrays.fill(result, -1);

		// 문자열 입력받기
		String str = sc.next();
		str = str.toLowerCase();
		String[] strarr = str.split("");

		for (int i = 0; i < strarr.length; i++) {
			int alpindex = (int) (strarr[i].charAt(0)) - 97;
			if (result[alpindex] == -1) {
				result[alpindex] = i;
			} else {
				continue;
			}
		}
		// 배열 출
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}
}