import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Q2933_HighAccess_Employees {
    public static void main(String[] args) {
        // access_times =
        // [["a","0549"],["b","0457"],["a","0532"],["a","0621"],["b","0540"]]
        var result = new Q2933_HighAccess_Employees().new Solution().findHighAccessEmployees(null);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        public List<String> findHighAccessEmployees(List<List<String>> access_times) {

            HashMap<String, PriorityQueue<Integer>> map = new HashMap<String, PriorityQueue<Integer>>();

            for (List<String> entry : access_times) {

                PriorityQueue<Integer> pq = map.getOrDefault(entry.get(0), new PriorityQueue<Integer>());
                pq.add(Integer.parseInt(entry.get(1)));
                map.put(entry.get(0), pq);
            }
            // System.out.println("FINAL MAP = " + map);
            List<String> result = new ArrayList<String>();
            int one, two, three;
            for (String key : map.keySet()) {
                PriorityQueue<Integer> pq = map.get(key);
                if (pq.size() >= 3) {
                    one = pq.poll();
                    two = pq.poll();
                    while (!pq.isEmpty()) {
                        three = pq.poll();
                        if (three - one < 100) {
                            result.add(key);
                            break;
                        }
                        one = two;
                        two = three;
                        // three=pq.poll();
                    }
                }
            }

            return result;

        }
    }
}
