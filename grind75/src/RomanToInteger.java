import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {


    /*Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000*/


    private int romanToInt(String s) {

        Map<Character,Integer> values = new HashMap<>();

        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        int n = s.length();
        int result = 0;

        for(int i = 0 ; i<n ; i++){
            if( i < n - 1 && values.get(s.charAt(i)) < values.get(s.charAt(i + 1))){
                result -= values.get(s.charAt(i));
            }else{
                result += values.get(s.charAt(i));
            }
        }
        return result;
    }

    public static void main (String[] args){
        String roman = "III" ;
        RomanToInteger solution = new RomanToInteger();
        System.out.println("Integer value of the roman " +roman+ "is " +solution.romanToInt(roman));
    }
}
