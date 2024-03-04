import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int num = sc.nextInt();

		String strarr[] = str.split("");
		System.out.println(strarr[num - 1]);

	}
}
