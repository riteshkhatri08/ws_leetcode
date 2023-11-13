import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;

public class Q2785_SortVowelsInAString {
    public static void main(String[] args) {

    }

    class Solution {
        private static final char[] charray = new char[] { 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u' };
        private final ArrayDeque<Integer> vowelPositions = new ArrayDeque<Integer>();
        private final LinkedHashMap<Character, Integer> vowelCounts = new LinkedHashMap<Character, Integer>();

        private int val;
        private char vowel;

        {
            for (char v : charray) {
                vowelCounts.put(v, 0);
            }
        }

        public String sortVowels(String s) {
            // Store vowel count in sorted order
            // store position to insert at later
            // pick woels from sorted order
            char[] chars = s.toCharArray();
            s = null;
            {
                for (int i = 0; i < chars.length; i++) {
                    if (vowelCounts.containsKey(chars[i])) {

                        vowelPositions.add(i);
                        vowelCounts.put(chars[i], vowelCounts.get(chars[i]) + 1);

                    }
                }

                if (vowelPositions.size() > 1) {

                    for (Map.Entry<Character, Integer> entry : vowelCounts.entrySet()) {

                        if ((val = entry.getValue()) > 0) {
                            vowel = entry.getKey();
                            while (val-- > 0) {
                                chars[vowelPositions.poll()] = vowel;

                            }

                        }
                    }

                }

            }
            return new String(chars);
        }
    }
}
