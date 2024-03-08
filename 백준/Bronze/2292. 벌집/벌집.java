import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		if (num == 1) // 입력받은 숫자가 1일경우 1을 출력
			System.out.println("1");
		else {
			// 1, 6, 12, 18, 24 -> 1 , 6의 배수로
			for (int i = 0; num > 0; i++) {
				if (i == 0) { // 맨 처음은 1로 시작하기때문에 i가 0일 경우를 따로 작성
					num -= 1;
				} else {
					num = num - (6 * i); // num-1에서 6의 배수를 차례로 뺌
					if (num <= 0) {
						System.out.println(i + 1);
						break;
					} else
						continue;
				}
			}
		}
	}
}