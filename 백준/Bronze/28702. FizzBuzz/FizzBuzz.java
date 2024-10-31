import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] A = new String[3];
        int result = 0;

        for(int i=0;i<3;i++){
            A[i] = br.readLine();
            if(Character.isDigit(A[i].charAt(0))){
                switch (i){
                    case 0: result = Integer.parseInt(A[i])+3; break;
                    case 1: result = Integer.parseInt(A[i])+2; break;
                    case 2: result = Integer.parseInt(A[i])+1; break;
                }
            }
        }

        if(result%3==0 && result%5==0){
            System.out.println("FizzBuzz");
        }else if(result % 3 == 0){
            System.out.println("Fizz");
        } else if(result % 5 == 0){
            System.out.println("Buzz");
        }else{
            System.out.println(result);
        }
    }
}
