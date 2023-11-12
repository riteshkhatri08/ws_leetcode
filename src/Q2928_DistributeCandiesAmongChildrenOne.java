import java.util.HashMap;

public class Q2928_DistributeCandiesAmongChildrenOne {
    public static void main(String[] args) {
        var result = new Q2928_DistributeCandiesAmongChildrenOne().new Solution().distributeCandies(3, 2);
        System.out.println("ANSWER = " + result);
    }

    // 18/3 = 6 if 6 < limit return 0

    /*
     * 18 / 3 = 6 (min 6 each) , limit < min return 0
     * else
     * 
     */

    class Solution {

        HashMap<Integer, Integer> previous = new HashMap<Integer, Integer>();

        private int combinations(int num) {
            if (!previous.containsKey(num)) {
                previous.put(num, num * (num - 1) / 2);
            }

            return previous.get(num);
        }

        public int distributeCandies(int n, int limit) {

            // IF num of candies greater than 3 times limit .. so all candies cant be
            // distrbuted
            if (n > 3 * limit) {
                return 0;
            }
            // get of combinations for n+2
            int result = combinations(n + 2);
            if (n > limit) {
                result -= 3 * combinations(n - limit + 1);
            }
            if (n - 2 >= 2 * limit) {
                result += 3 * combinations(n - 2 * limit);
            }
            return result;
        }

    }
}

// 0 1 10
// 1 0 10
// 0 10 1
// 10 0 1
// 10 1 0
/*
 * 
 * 
 * 1 = 3 ===== n * 3
 * 2 = 6 ===== n * 3
 * 3 = 10 ===== n * 3 + 1 = 3 ^0
 * 4 = 15 ====== n * 3 + 3 = 3 ^ 1
 * 5 = 21 ===== n * 3 + 6 =
 * 6 = 28 ====== n * 3 + 10
 * 
 * 
 * solut = distribute(n,n+1) = n*3 + distrbute (n-3);
 * 
 * 
 * 
 * 
 * 
 */