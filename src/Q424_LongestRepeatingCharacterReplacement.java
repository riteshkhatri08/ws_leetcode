public class Q424_LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "ABBB";
        int k = 2;
        System.out.println("ANSWER = " + longestRepeatingCharacterReplacement(s, k));
    }

    public static int longestRepeatingCharacterReplacement(String s, int k) {

        int[] charcount = new int[91];

        int left = 0, right = 0, maxsofar = 0;

        // System.out.println("STRING = " + s);
        char[] charray = s.toCharArray();
        char maxchar = charray[left];

        // charcount.put(charray[left], 1);
        maxchar = charray[left];
        for (; right < charray.length; right++) {

            // System.out.println("NEW CHAR CAME IN - " + charray[right] + " , right=" +
            // right);

            // Increment count of current character
            charcount[charray[right]]++;

            // System.out.println("CHAR COUNT = " + charcount);

            // Check if current character same as max character
            if (maxchar != charray[right]) {

                // Check if there's change in max char due to new character
                if (charcount[maxchar] < charcount[charray[right]]) {
                    maxchar = charray[right];
                    // System.out.println(" New max xhar " + maxchar);
                } else {
                    // Check how many characters have we replaced already
                    // System.out.println("Replaced = " + replaced);
                    while ((right - left - charcount[maxchar] + 1) > k) {

                        // time to shrink window
                        charcount[charray[left]]--;
                        left++;

                        // System.out.println("decrease window, char count" + charcount + " , left=" +
                        // left);

                        // Now get the new max char
                        maxchar = getMostRecurringCharacter(charcount);

                    }
                }

            } else {
                // Then no issue, we as we are not increasing replace count
                if ((right - left) > maxsofar) {
                    maxsofar = right - left;
                }

            }

        }
        if (right == charray.length) {
            if (right - left > maxsofar) {
                maxsofar = right - left;
            }
        }
        return maxsofar;
    }

    public static char getMostRecurringCharacter(int[] charcount) {
        int maxindex = 65;
        for (int curindex = 65; curindex < charcount.length; curindex++) {
            if (charcount[maxindex] < charcount[curindex]) {
                maxindex = curindex;
            }
        }
        return (char) (maxindex);
    }
}
