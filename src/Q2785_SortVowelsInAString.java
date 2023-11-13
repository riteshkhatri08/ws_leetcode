public class Q2785_SortVowelsInAString {
    public static void main(String[] args) {
        String s = "lEetcOde";

        var result = new Q2785_SortVowelsInAString().new Solution().sortVowels(s);
        System.out.println("ANSWER = " + result);
    }

    class Solution {

        public String sortVowels(String s) {
            // Store vowel count in sorted order
            // store position to insert at later
            // pick woels from sorted order
            char[] chars = s.toCharArray();
            char[] vowels = new char[10];

            for (char c : chars) {
                switch (c) {
                    case 'A': {
                        vowels[0]++;
                        break;
                    }
                    case 'E': {
                        vowels[1]++;
                        break;
                    }
                    case 'I': {
                        vowels[2]++;
                        break;
                    }
                    case 'O': {
                        vowels[3]++;
                        break;
                    }
                    case 'U': {
                        vowels[4]++;
                        break;
                    }
                    case 'a': {
                        vowels[5]++;
                        break;
                    }
                    case 'e': {
                        vowels[6]++;
                        break;
                    }
                    case 'i': {
                        vowels[7]++;
                        break;
                    }
                    case 'o': {
                        vowels[8]++;
                        break;
                    }
                    case 'u': {
                        vowels[9]++;
                        break;
                    }
                }

            }
            int j = 0;
            for (int i = 0; i < vowels.length; i++) {
                while (vowels[i] > 0) {
                    char c = '_';
                    switch (i) {
                        case 0: {
                            c = 'A';
                            break;
                        }
                        case 1: {
                            c = 'E';
                            break;
                        }
                        case 2: {
                            c = 'I';
                            break;
                        }
                        case 3: {
                            c = 'O';
                            break;
                        }
                        case 4: {
                            c = 'U';
                            break;
                        }
                        case 5: {
                            c = 'a';
                            break;
                        }
                        case 6: {
                            c = 'e';
                            break;
                        }
                        case 7: {
                            c = 'i';
                            break;
                        }
                        case 8: {
                            c = 'o';
                            break;
                        }
                        case 9: {
                            c = 'u';
                            break;
                        }
                    }
                    boolean flag = true;
                    for (; j < chars.length && flag; j++) {
                        switch (chars[j]) {
                            case 'a':
                            case 'e':
                            case 'i':
                            case 'o':
                            case 'u':
                            case 'A':
                            case 'E':
                            case 'I':
                            case 'O':
                            case 'U': {
                                chars[j] = c;
                                vowels[i]--;
                                flag = false;

                            }
                        }
                    }
                }
            }

            return new String(chars);
        }
    }
}
