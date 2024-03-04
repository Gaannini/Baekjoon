import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[8];

		// 1-8 숫자 8개 입력받
		for (int i = 0; i < 8; i++) {
			arr[i] = sc.nextInt();
		}

		// ascending여부
		if (arr[0] == 1) {
			for (int i = 0; i < arr.length; i++) {
				if (i == arr.length - 1 && arr[i] == i + 1)
					System.out.println("ascending");
				else if (arr[i] == i + 1) {
					continue;
				} else {
					System.out.println("mixed");
					break;
				}
			}
		}
		// descending여부
		else if (arr[0] == 8) {
			int num = arr.length;
			for (int i = 0; i < arr.length; i++) {
				if (i == arr.length - 1 && arr[i] == num) {
					System.out.println("descending");
				} else if (arr[i] == num) {
					num--;
					continue;
				} else {
					System.out.println("mixed");
					break;
				}
			}
		} else {
			System.out.println("mixed");
		}
	}
}
