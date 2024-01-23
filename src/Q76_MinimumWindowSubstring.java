public class Q76_MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "cbbbacccccbbbacbabbabacbabbbabaacbaccccbcbcbcca";
        String t = "abcbcabaacccababacbabcacbc";
        System.out.println("ANSWER = " + minWindow(s, t));
    }

    public static String minWindow(String s, String t) {

        // Replace this placeholder return statement with your code
        // TARGET find shortest substring of s which contains all letters of t matching
        // their count as in t;
        // aif a character from t is not present in s return ""
        // So minimum window is of either size t.length or 0

        int[] tcharcount = new int[123]; // for 65 -123 a-Z
        int[] scharcount = new int[123]; // for 65 -123 a-Z
        int[] charcount = new int[123]; // for 65 -123 a-Z
        char[] charray = s.toCharArray();
        int tsize = t.length();

        int left = 0, right = 0, requiredchars = tsize, minleft = 0, minright = Integer.MAX_VALUE;

        // Count frequency of s
        for (int c : charray)
            scharcount[c]++;

        // Count frequency of characters in T;
        for (int c : t.toCharArray())
            if (scharcount[c] == 0) {
                return "";
            } else {
                tcharcount[c]++;
            }
        // Make sure s has all characters with freq matchas required in t
        for (int c : t.toCharArray()) {
            if (scharcount[c] < tcharcount[c]) {
                return "";
            }
        }

        // Start iterating "s"
        for (; right < charray.length; right++) {
            // System.out.println(" New character" + charray[right]);

            charcount[charray[right]]++;

            // System.out.println("char count = " + print(charcount));

            // check if current character is required in t and we dont have enough of that
            // character
            if (charcount[charray[right]] <= tcharcount[charray[right]]) {

                // decrement required characters
                requiredchars--;
                // if required characters reached zero record substring index
                if (requiredchars == 0 && (right - left) < (minright - minleft)) {

                    minright = right;
                    minleft = left;
                    // Minimum possible substirng length
                    if ((minright - minleft + 1) == tsize) {
                        break;
                    }
                }
            } else {
                // now we have more than enough of this character, time to slide

                while (charcount[charray[left]] > tcharcount[charray[left]]) {
                    //
                    charcount[charray[left]]--;
                    left++;
                    // System.out.println("Sliding window - left=" + left);
                    // System.out.println("charcount - " + print(charcount));
                }

                if (requiredchars == 0 && ((right - left) < (minright - minleft))) {
                    minright = right;
                    minleft = left;
                }

            }

        }
        if ((right - left) < (minright - minleft)) {
            minright = right;
            minleft = left;
        }
        if (minright != charray.length)
            minright++;
        return s.substring(minleft, minright);
    }

    public static String print(int[] charcount) {
        // StringBuidler sb = new StringBuidler();
        String s = "[";
        for (int c = 65; c < 91; c++) {
            if (charcount[c] != 0)
                s += (char) c + "=" + charcount[c] + ", ";

        }
        for (int c = 97; c < 123; c++) {
            if (charcount[c] != 0)
                s += (char) c + "=" + charcount[c] + ", ";

        }
        s += "]";
        return s;
    }
}
