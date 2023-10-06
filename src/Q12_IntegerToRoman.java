import java.util.HashMap;

public class Q12_IntegerToRoman {

    public static void main(String[] args) {
        var obj = new Q12_IntegerToRoman();
        int num = 1994;
        String result = obj.new Solution().intToRoman(num);
        System.out.println(result);
    }

    class Solution {
        HashMap<Integer, String> map = new HashMap<Integer, String>();

        public String intToRoman(int num) {

            if (map.containsKey(num)) {
                return map.get(num);
            }
            String result = "";
            int div = 10;
            int k;
            while (num > div) {

                k = num % div;
                if (k != 0) {
                    result = map.get(k) + result;
                }
                num = num - k;
                div = div * 10;

            }
            result = map.get(num) + result;
            return result;

        }

        public Solution() {
            map.put(1, "I");
            map.put(2, "II");
            map.put(3, "III");
            map.put(4, "IV");
            map.put(5, "V");
            map.put(6, "VI");
            map.put(7, "VII");
            map.put(8, "VIII");
            map.put(9, "IX");
            map.put(10, "X");
            map.put(20, "XX");
            map.put(30, "XXX");
            map.put(40, "XL");
            map.put(50, "L");
            map.put(60, "LX");
            map.put(70, "LXX");
            map.put(80, "LXXX");
            map.put(90, "XC");
            map.put(100, "C");
            map.put(200, "CC");
            map.put(300, "CCC");
            map.put(400, "CD");
            map.put(500, "D");
            map.put(600, "DC");
            map.put(700, "DCC");
            map.put(800, "DCCC");
            map.put(900, "CM");
            map.put(1000, "M");
            map.put(2000, "MM");
            map.put(3000, "MMM");
        }

    }

}
