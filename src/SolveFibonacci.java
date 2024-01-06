public class SolveFibonacci {

    private static long[] topdowndp = null;
    private static long[] bottomupdp = null;
    private static long[] bottomupdpback = null;

    public static void main(String[] args) {
        int n = 10;
        topdowndp = new long[n + 1];
        bottomupdp = new long[(int) n + 1];
        bottomupdpback = new long[(int) n + 2];
        long res = 0;
        // Solve using regular recursion
        long startTime = System.nanoTime();
        res = fibRegular(n);
        long endTime = System.nanoTime();
        System.out.println("REGULAR - " + res + " : " + (endTime - startTime));

        // Solve using Top Down approach
        startTime = System.nanoTime();
        res = fibTopDown(n);
        endTime = System.nanoTime();
        System.out.println("TOP DOWN - " + res + " : " + (endTime - startTime));

        // Solve using Bottom Up FORWARD approach
        startTime = System.nanoTime();
        res = fibBottomUpForwrad(n);
        endTime = System.nanoTime();
        System.out.println("BOTTOM UP FORWARD - " + res + " : " + (endTime - startTime));

        // Solve using Bottom Up BACKWARD approach
        startTime = System.nanoTime();
        res = fibBottomUpBackward(n);
        endTime = System.nanoTime();
        System.out.println("BOTTOM UP BACKWARD  - " + res + " : " + (endTime - startTime));
    }

    // Iteration + memoization
    private static long fibBottomUpForwrad(long n) {

        if (n == 0)
            return 0;

        if (n <= 2)
            return 1;

        bottomupdp[0] = 0;
        bottomupdp[1] = 1;
        for (int i = 2; i <= n; i++) {
            bottomupdp[i] = bottomupdp[i - 1] + bottomupdp[i - 2];
        }
        return bottomupdp[(int) n];
    }

    // Iteration + memoization
    private static long fibBottomUpBackward(long n) {

        if (n == 0)
            return 0;

        if (n <= 2)
            return 1;

        bottomupdpback[0] = 0;
        bottomupdpback[1] = 1;
        for (int i = 1; i < n; i++) {
            bottomupdpback[i + 1] += bottomupdpback[i];
            bottomupdpback[i + 2] += bottomupdpback[i];
        }

        return bottomupdpback[(int) n];
    }

    // Recursion + Memoization
    private static long fibTopDown(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        if (topdowndp[n] != 0)
            return topdowndp[n];

        topdowndp[n] = fibTopDown(n - 1) + fibTopDown(n - 2);
        return topdowndp[n];
    }

    // Just Recursion
    private static long fibRegular(int n) {
        return (n <= 2) ? 1 : fibRegular(n - 1) + fibRegular(n - 2);
    }
}
