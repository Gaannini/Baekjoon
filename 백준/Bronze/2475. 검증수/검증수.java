import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int sum = 0;

		String[] arr = str.split(" ");
		for (int i = 0; i < arr.length; i++) {
			sum += Math.pow(Integer.valueOf(arr[i]), 2);
		}
		int result = sum % 10;
		// System.out.println(sum);
		System.out.println(result);
	}
}
