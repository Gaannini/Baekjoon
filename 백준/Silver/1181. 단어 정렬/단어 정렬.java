import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		// 단어들 리스트에 저장
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}

		// 선택 정렬
		for (int i = 0; i < N; i++) {
			if (list.get(i) == null) { // 해당 index의 내용이 null일 경우 다음 index로 넘어감
				continue;
			}
			String minword = list.get(i); // 작은 단어
			int min = list.get(i).length(); // 작은 단어의 길이
			int minidx = i; // 작은 단어의 index
			String swap = ""; // 자리를 바꿀때 쓸 변수

			// 가장 작은 값 찾기 -> i의 다음부터 배열의 길이만큼 비교
			for (int j = i + 1; j < N; j++) {
				// 비교할 대상이 null이면 다음 index로 넘어감
				if (list.get(j) == null) {
					continue;
				}
				// 비교대상이 저장된 단어보다 더 짧을경우
				else if (min > list.get(j).length()) {
					minword = list.get(j);
					min = list.get(j).length();
					minidx = j;
				}
				// 비교대상이 저장된 단어와 길이가 같을경우(사전적으로 정렬, 같은 단어인 경우 해당 인덱스 null처리)
				else if (min == list.get(j).length()) {
					// 같은 단어일 경우
					if (minword.compareTo(list.get(j)) == 0) {
						list.set(j, null);
					}
					// minword가 사전적으로 뒤에 있을경우
					else if (minword.compareTo(list.get(j)) > 0) {
						minword = list.get(j);
						min = list.get(j).length();
						minidx = j;
					}
				}
			}
			// 가장 작은 값 찾은 후 단어 위치 바꾸기
			swap = list.get(minidx);
			list.set(minidx, list.get(i));
			list.set(i, swap);
		}

		// list에서 null값 제거
		list.removeAll(Collections.singletonList(null));

		// 출력
		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i) + "\n");
		}

		br.close();
		bw.close();
	}
}
