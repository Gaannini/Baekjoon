import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int bag = 0;

        bag += N / 5;
        N %= 5;
        if(N%3 != 0){
            int Fbag = bag;
            for (int i = 0; i <Fbag; i++) {
                N+=5;
                bag--;
                if(N%3 == 0){
                    break;
                }else{
                    if(i == Fbag-1){
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }

        bag += N / 3;
        N %= 3;

        if(N>0) System.out.println("-1");
        else System.out.println(bag);

    }
}
