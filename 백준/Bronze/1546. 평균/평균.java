import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] score = new int[N];
		float[] newscore = new float[N];
		float sum = 0;

		for(int i=0;i<N;i++) {
			score[i] = sc.nextInt();
		}//점수 저장
		int max = score[0];//최댓값

		for(int i=1;i<N;i++) {
			if(score[i]>=max) {
				max = score[i];
			}
		}//최댓값

		for(int i=0;i<N;i++) {
			newscore[i] = (float)score[i]/max*100;
			sum+=newscore[i];
		}
		System.out.print(sum/N);
	}
}