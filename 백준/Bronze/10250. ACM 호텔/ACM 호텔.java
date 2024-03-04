import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트케이스 입력
		int T = sc.nextInt();
		int[] H = new int[T]; // 층수
		int[] W = new int[T]; // 방수
		int[] N = new int[T]; // N번째 손님

		for (int i = 0; i < T; i++) {
			H[i] = sc.nextInt();
			W[i] = sc.nextInt();
			N[i] = sc.nextInt();
		}
		String F; // 층
		String R; // 호
		for (int i = 0; i < T; i++) {
			if (H[i] == N[i]) {
				String FR_01 = Integer.toString(H[i]) + "01";
				System.out.println(FR_01);
			} else {
				if (N[i] % H[i] != 0) {
					F = Integer.toString(N[i] % H[i]);
					R = String.format("%02d", N[i] / H[i] + 1);
				} else {
					F = Integer.toString(H[i]);
					R = String.format("%02d", N[i] / H[i]);
				}

				System.out.println(F + R);
			}
		}
	}
}
