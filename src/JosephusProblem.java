
// ! QUESTION ON GFG
// ? https://practice.geeksforgeeks.org/problems/game-of-death-in-a-circle1840/1
import java.io.IOException;
import java.util.ArrayList;

class JosephusProblem {
    public static void main(String args[]) throws IOException {
        // BufferedReader read =
        // new BufferedReader(new InputStreamReader(System.in));
        // int t = Integer.parseInt(read.readLine());
        // while (t-- > 0) {
        // String S[] = read.readLine().split(" ");

        int n = 40;
        int k = 7;
        // EXpected is 24

        Solution ob = new JosephusProblem().new Solution();
        System.out.println("ANSWER  = " + ob.safePos(n, k));
        // }
    }

    class Solution {
        int killed;
        ArrayList<Integer> people = new ArrayList<Integer>();

        int safePos(int n, int k) {

            for (int i = 1; i <= n; i++) {
                people.add(i);
            }

            helper(0, n, k - 1);

            return people.get(0);
        }

        private void helper(int startPosition, int n, int k) {
            if (n == 1) {
                return;
            }

            killed = (startPosition + k) % n;
            people.remove(killed);
            helper(killed, n - 1, k);

        }
    }
}
