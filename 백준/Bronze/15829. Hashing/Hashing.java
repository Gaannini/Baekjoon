import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// r = 31; M = 1234567891;
		final int r = 31;
		final int M = 1234567891;

		// 입력받기
		int L = sc.nextInt(); // 문자열의 길이
		String str = sc.next();

		// 문자열 입력 배열, 결과값 변수
		char[] str_char = str.toCharArray(); // 문자열을 나눠서 char형배열에 삽입
		int[] str_int = new int[L];
		int result_multi = 0; // 시그마계산값 저장
		int hash;

		// 각 문자열 수열로 변환해서 저장(a=97)
		for (int i = 0; i < L; i++)
			str_int[i] = (int) str_char[i] - 96;

		// 시그마 계산
		for (int i = 0; i < L; i++) {
			int multi = str_int[i] * (int) Math.pow(r, i);
			result_multi += multi;
		}
		System.out.println(result_multi);

	}
}
