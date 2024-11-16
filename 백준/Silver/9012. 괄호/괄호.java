import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Boolean> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            stack.clear();
            for(int j=0; j < s.length(); j++) {
                char a = s.charAt(j);
                if(a == '(') stack.push(true);
                else if(a == ')') {
                    if(stack.isEmpty()){
                        System.out.println("NO");
                        break;
                    }
                    stack.pop();
                }
                if(j==s.length()-1){
                    if(stack.isEmpty()) System.out.println("YES");
                    else System.out.println("NO");
                }
            }
        }
    }
}
