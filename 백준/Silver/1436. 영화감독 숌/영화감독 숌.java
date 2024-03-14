import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wt = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int count = 1;
		int title = 666;

		while (true) {
			if (count == N) {
				System.out.println(title);
				break;
			} else {
				title++;
				if (Integer.toString(title).contains("666")) {
					count++;
				}
			}
		}
	}
}