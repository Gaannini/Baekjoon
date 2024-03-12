import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		if (num1 >= num2) {
			// 최대공약수
			for (int i = num2; i >= 0; i--) {
				if (num1 % i == 0 && num2 % i == 0) {
					System.out.println(i);
					break;
				}
			}

			// 최소공배수
			for (int i = 1;; i++) {
				if (num1 * i % num2 == 0) {
					System.out.println(num1 * i);
					break;
				}
			}
		} else {
			// 최대공약수
			for (int i = num1; i >= 0; i--) {
				if (num2 % i == 0 && num1 % i == 0) {
					System.out.println(i);
					break;
				}
			}

			// 최소공배수
			for (int i = 1;; i++) {
				if (num2 * i % num1 == 0) {
					System.out.println(num2 * i);
					break;
				}
			}
		}
	}
}
