import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> nums = new ArrayList<Integer>();
		// int[] nums = null;

		// 숫자들을 각 줄에 입력
		for (int i = 0; true; i++) {
			nums.add(sc.nextInt());
			if (nums.get(i) == 0) {
				nums.remove(i);
				break;
			}
		}

		boolean pel;

		for (int i = 0; i < nums.size(); i++) {
			if (nums.get(i) < 10) {
				System.out.println("yes");
				continue;
			}
			pel = false;
			String[] splitnum;
			// 줄의 숫자를 숫자 하나하나 나눠서 저장
			splitnum = Integer.toString(nums.get(i)).split("");
			for (int j = 0; j < splitnum.length / 2; j++) {
				if (splitnum[j].equals(splitnum[splitnum.length - j - 1])) {
					pel = true;
				} else {
					pel = false;
					break;
				}
			}
			if (pel)
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
}
