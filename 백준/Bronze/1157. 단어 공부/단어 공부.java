import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// alp배열에 알파벳 넣기
		char[] alp = new char[26];
		for (int i = 0; i < 26; i++) {
			alp[i] = (char) (65 + i);
		}

		// 결과를 저장할 배열(0으로 초기화)
		int[] result = new int[26];
		Arrays.fill(result, 0);

		// 단어 입력받기
		String str = sc.nextLine();
		str = str.toUpperCase();
		String[] strarr = str.split("");

//		alp : 알파벳 저장
//		result : 알파벳 판별
//		strarr : 입력받은 문자

		// result배열에 결과 넣기
		for (int i = 0; i < strarr.length; i++) {
			char asc = strarr[i].charAt(0);
			int ascnum = (int) asc - 65;
			result[ascnum]++;
		}

		// 최댓값 찾기
		int max = result[0];
		int maxIndex = 0;

		for (int i = 1; i < result.length; i++) {
			if (max < result[i]) {
				max = result[i];
				maxIndex = i;
			}
		}
		boolean same = false;

		if (maxIndex == 25) {
			System.out.println((char) (maxIndex + 65));
		} else {
			for (int i = maxIndex + 1; i < result.length; i++) {
				if (max == result[i]) {
					System.out.println("?");
					same = true;
					break;
				}
			}
			if (!same)
				System.out.println((char) (maxIndex + 65));
		}
	}
}
