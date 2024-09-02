import java.util.Stack;

public class ERPN {
    public int evalRPN(String[] tokens) {
        //["2","1","+","3","*"]
        int n = tokens.length;
        Stack<Integer> result = new Stack<>();
        int a, b;
        for (int i = 0; i < n; i++) {
            switch (tokens[i]) {
                case "+":
                    result.push(result.pop() + result.pop());
                    break;
                case "*":
                    result.push(result.pop() * result.pop());
                    break;
                case "-":
                    b = result.pop();
                    a = result.pop();
                    result.push(a - b);
                    break;
                case "/":
                    b = result.pop();
                    a = result.pop();
                    result.push(a / b);
                default:
                    result.push(Integer.parseInt(tokens[i]));
            }
        }
        return result.pop();
    }
}
