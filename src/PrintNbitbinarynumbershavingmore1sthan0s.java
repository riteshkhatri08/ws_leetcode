
// ! QUESTION ON GFG
// ? https://practice.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1

import java.io.IOException;
import java.util.ArrayList;

public class PrintNbitbinarynumbershavingmore1sthan0s {
    public static void main(String args[]) throws IOException {
        // BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        // int t = Integer.parseInt(read.readLine());
        // while (t-- > 0) {
        // int n = Integer.parseInt(read.readLine());
        int n = 4;
        Solution ob = new Solution();
        ArrayList<String> result = ob.NBitBinary(n);
        for (String value : result) {
            System.out.print(value + " ");
        }
        System.out.println();
        // }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    ArrayList<String> answers = new ArrayList<String>();
    int n;

    ArrayList<String> NBitBinary(int N) {
        n = N;
        helper("", 0, 0);
        return answers;
    }

    private void helper(String s, int ones, int zeroes) {
        if (zeroes + ones == n) {
            // if (ones>=zeroes)
            answers.add(s);
            return;
        }

        helper(s + "1", ones + 1, zeroes);
        if (ones > zeroes)
            helper(s + "0", ones, zeroes + 1);
    }

}