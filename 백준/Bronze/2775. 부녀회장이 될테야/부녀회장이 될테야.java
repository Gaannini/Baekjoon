import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[] karr = new int[T];
		int[] narr = new int[T];

		// 입력받기
		for (int i = 0; i < T; i++) {
			karr[i] = sc.nextInt();
			narr[i] = sc.nextInt();
		}

		int[] downfloor = new int[14]; // 0번째 층 = 1~14명 넣기 + 아래층으로 쓸 배열
		int[] currentfloor = new int[14]; // 현재층

		for (int i = 0; i < T; i++) { // 테스트케이스만큼 반복 i : 테스트케이스
			for (int r = 1; r <= downfloor.length; r++) { // 0번째 층 초기화
				downfloor[r - 1] = r;
			}
			for (int j = 0; j < karr[i]; j++) { // j : 층수만클 반복
				int sum = 0;
				for (int k = 0; k < narr[i]; k++) { // k : 호수만큼 반복
					sum += downfloor[k]; // 같은층 전 호수의 값에 아래층 같은 호수 값 더함
					currentfloor[k] = sum;
					// System.out.println((j + 1) + "층" + (k + 1) + "호 : " + currentfloor[k]);
				}
				downfloor = currentfloor;
			}
			System.out.println(currentfloor[narr[i] - 1]);
		}
	}
}
