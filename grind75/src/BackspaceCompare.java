public class BackspaceCompare {
    public boolean backspaceCompare(String s, String t) {
        return buildValidString(s).equals(buildValidString(t));
    }

    private String buildValidString(String input) {
        StringBuilder result = new StringBuilder();
        int n = input.length() - 1 ;
        int backspace = 0;
        for(int i = n ;i>=0 ;i--){
            char ch = input.charAt(i);
            if(ch == '#'){
                backspace++;
            }else{
                if(backspace > 0){
                    backspace--;
                }else{
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        String s = "ab#c";
        String t = "ad#c";

        BackspaceCompare solution = new BackspaceCompare();
        System.out.println("The String are same "+solution.backspaceCompare(s,t));
    }
}
