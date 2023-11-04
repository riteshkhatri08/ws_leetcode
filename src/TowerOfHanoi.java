import java.util.ArrayList;

public class TowerOfHanoi {
    public static void main(String[] args) {
        var movelist = new TowerOfHanoi().towerOfHanoi(8);
        // Output should be 8
        System.out.println("NO OF MOVES  = " + movelist.size());
        // movelist.forEach(move -> System.out.println(move));
    }

    public static ArrayList<ArrayList<Integer>> moves;

    public static ArrayList<ArrayList<Integer>> towerOfHanoi(int n) {
        moves = new ArrayList<ArrayList<Integer>>();

        // Move N disks from 1(src) to 3(dest) with 2 as aux tower
        hanoi(n, 1, 2, 3);

        return moves;
    }

    public static void hanoi(int n, int source, int aux, int dest) {
        // System.out.println("Request to move "+ n + " disks from "+ source + " to " +
        // dest + " with " + aux +" as aux." );
        if (n == 1) {
            // actually record a move
            System.out.println("Move " + source + " ===> " + dest);
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(source);
            list.add(dest);
            moves.add(list);
            return;
        }

        // To move n disks from source to dest we need to move n-1 disk from src to aux
        hanoi(n - 1, source, dest, aux);

        // Now move top at src which is nth disk basically from src to dest
        hanoi(1, source, aux, dest);

        // Now move n-1 disks which are currently at original aux from aux to dest
        hanoi(n - 1, aux, source, dest);

    }
}