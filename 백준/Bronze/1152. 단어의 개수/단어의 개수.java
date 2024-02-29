import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine();
		String[] wordarr = sentence.split(" ");
		int num = 0;
		String[] resentence;
		for (int i = 0; i < wordarr.length; i++) {
			if (wordarr[i] != "")
				num++;
		}

		System.out.print(num);
		sc.close();

	}
}
