import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력받을 숫자의 개수, 숫자들을 저장할 배열만들기
		int N = sc.nextInt();
		int[] arr = new int[N];

		// 숫자 입력받기
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		int demical = 0;// 소수의 개수
		for (int i = 0; i < N; i++) {
			int num = (int) Math.sqrt(arr[i]);// 주어진 숫자의 제곱근
			// 2~3은 소수(예외)
			if (arr[i] == 1) // 1은 소수X
				continue;
			else if (num == 1) // 2~3 (예외)
				demical++;
			else {
				for (int j = 2; j <= num; j++) {
					int result = arr[i] % j;
					if (result == 0)
						break;
					else if (result != 0 && j < num)
						continue;
					else
						demical++;
				}
			}
		}
		System.out.println(demical);
	}
}
