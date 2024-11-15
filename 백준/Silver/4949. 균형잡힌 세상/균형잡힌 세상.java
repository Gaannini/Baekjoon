import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>(); //( : 0, [ : 1

        while(true){
            String s = br.readLine();
            stack.clear();
            if(s == null || s.equals(".")) break;
            if(s.isEmpty()) System.out.print("yes");
            else{
                for(int i=0;i<s.length();i++){
                    if(s.charAt(i)=='(') stack.push(0);
                    else if(s.charAt(i)=='[') stack.push(1);
                    else if(s.charAt(i)==')') {
                        if(stack.isEmpty()) {
                            System.out.println("no");
                            break;
                        }else if(stack.pop()!=0) {
                            System.out.println("no");
                            break;
                        }
                    }else if(s.charAt(i)==']') {
                        if(stack.isEmpty()) {
                            System.out.println("no");
                            break;
                        }else if(stack.pop()!=1) {
                            System.out.println("no");
                            break;
                        }
                    }
                    if(s.charAt(i)=='.' && stack.isEmpty())
                        System.out.println("yes");
                    else if(s.charAt(i)=='.' && !stack.isEmpty())
                        System.out.println("no");
                }
            }
        }
    }
}
