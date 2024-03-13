import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] count = new int[10001]; // 입력값의 범위를 기준으로 배열 크기 지정

		// 입력값의 출현 빈도수를 카운팅
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			count[num]++;
		}

		// 카운팅된 값들을 순서대로 출력
		for (int i = 1; i <= 10000; i++) {
			while (count[i] > 0) {
				bw.write(i + "\n");
				count[i]--;
			}
		}

		br.close();
		bw.close();
	}
}
