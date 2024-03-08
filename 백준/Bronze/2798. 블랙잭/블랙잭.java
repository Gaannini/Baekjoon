import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int result = sc.nextInt();
		int[] cardarr = new int[cnt];
		int sum; // 카드 세개를 더한 값
		int max = 0; // 최종 답(제일 큰카드 3장의 합)

		// 카드들을 입력받고 오름차순으로 정렬
		for (int i = 0; i < cnt; i++)
			cardarr[i] = sc.nextInt();
		Arrays.sort(cardarr);

		for (int i = cnt - 1; i > -1; i--) {
			for (int j = i - 1; j > -1; j--) {
				for (int k = j - 1; k > -1; k--) {
					sum = cardarr[i] + cardarr[j] + cardarr[k];
					if (result >= sum && sum > max) {
						max = sum;
					}
				}
			}
		}
		System.out.println(max);
	}
}