import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(); // A : 올라가는 길이
		int B = sc.nextInt(); // B : 미끌어지는 길이
		int V = sc.nextInt(); // V : 나무막대 길이
		int interval = A - B; // 차이
		int firstday = A; // 올라간 거리
		int day = 1; // 며칠

		if (A >= V) {
			System.out.println(day);
		} else {
			day += (int) Math.ceil((double) (V - firstday) / interval);
			System.out.println(day);
		}
	}
}
