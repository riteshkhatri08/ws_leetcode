public class Q2849_DetermineIfCellIsReachableAtAGivenTime {
    public static void main(String[] args) {
        var result = new Q2849_DetermineIfCellIsReachableAtAGivenTime().new Solution().isReachableAtTime(2, 4, 7, 7, 6);
        System.out.println(result);
    }

    class Solution {
        public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
            sx = sx < 0 ? -1 * sx : sx;
            fx = fx < 0 ? -1 * fx : fx;
            sy = sy < 0 ? -1 * sy : sy;
            fy = fy < 0 ? -1 * fy : fy;

            int diffx, diffy;

            diffx = sx > fx ? sx - fx : fx - sx;
            diffy = sy > fy ? sy - fy : fy - sy;
            int minSteps = diffx > diffy ? diffx : diffy;
            if (minSteps == 0 && t == 1) {
                // Because we are already at destination and cannot move around and come back to
                // with only 1 step
                return false;
            }
            // System.out.println(diffx +" " + diffy +" "+minSteps);
            return minSteps <= t ? true : false;
        }
    }
}
