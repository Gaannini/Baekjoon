import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt(); // 입력한 숫자
		int result = 0; // num과 비교하기위함
		int cons = 0; // 생성자

		for (int i = 0; i <= 63 && i < num; i++) {
			int sum = 0;
			int _cons = num - i; // 생성자인지 확인해보기위한 임시 생성자역할
			String[] numstr = Integer.toString(_cons).split("");
			for (int j = 0; j < numstr.length; j++)
				sum += Integer.parseInt(numstr[j]);
			result = _cons + sum;

			if (result == num)
				cons = _cons;
			else
				continue;

		}
		System.out.println(cons);
	}
}
