import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] rearr = new int[T];
		String[] strarr = new String[T];

		for (int i = 0; i < T; i++) {
			rearr[i] = sc.nextInt();
			strarr[i] = sc.next();
		}
		String[] splitstr;

		for (int i = 0; i < T; i++) {
			splitstr = strarr[i].split("");
			for (int j = 0; j < splitstr.length; j++) {
				for (int a = 0; a < rearr[i]; a++) {
					System.out.print(splitstr[j]);
				}
			}
			System.out.println();
			splitstr = null;
		}
	}
}
