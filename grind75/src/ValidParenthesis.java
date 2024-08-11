import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValid(String input){
        Stack<Character> s = new Stack<>();
        for(char c : input.toCharArray()){
            if(c == '('){
                s.push(')');
            }else if(c == '{'){
                s.push('}');
            } else if(c == '['){
                s.push(']');
            } else if (s.isEmpty() || s.pop() != c) {
                return false;
            }
        }
        return s.isEmpty();
    }

    public static void main (String[] args){
        String input = "()";
        System.out.println("The output is " +isValid(input));
    }
}
