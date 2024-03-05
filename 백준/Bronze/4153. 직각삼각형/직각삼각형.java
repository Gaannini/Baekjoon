import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> rac1 = new ArrayList<Integer>();
		List<Integer> rac2 = new ArrayList<Integer>();
		List<Integer> rac3 = new ArrayList<Integer>();
		boolean T = true;

		// 입력받기
		for (int i = 0; T; i++) {
			rac1.add(sc.nextInt());
			rac2.add(sc.nextInt());
			rac3.add(sc.nextInt());
			if (rac1.get(i) == 0 && rac2.get(i) == 0 && rac3.get(i) == 0) {
				rac1.remove(i);
				rac2.remove(i);
				rac3.remove(i);
				T = false;
			}
		}

		for (int i = 0; i < rac1.size(); i++) {
			int powrac1 = (int) Math.pow((double) rac1.get(i), 2);
			int powrac2 = (int) Math.pow((double) rac2.get(i), 2);
			int powrac3 = (int) Math.pow((double) rac3.get(i), 2);

			boolean ractangle;

			boolean result1 = powrac1 + powrac2 == powrac3 ? true : false;
			boolean result2 = powrac1 + powrac3 == powrac2 ? true : false;
			boolean result3 = powrac2 + powrac3 == powrac1 ? true : false;

			if (rac1.get(i) == 0 || rac2.get(i) == 0 || rac3.get(i) == 0) {
				System.out.println("wrong");
				continue;
			} else if (result1 || result2 || result3) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
	}
}
