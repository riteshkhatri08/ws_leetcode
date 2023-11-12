import java.util.HashMap;
import java.util.HashSet;

public class Q815_BusRoutes {
    public static void main(String[] args) {

    }

    class Solution {
        HashMap<Integer, HashSet<Integer>> routemap = new HashMap<Integer, HashSet<Integer>>();
        HashSet<Integer> visited = new HashSet<Integer>();
        int shortRoute = Integer.MAX_VALUE;

        public int numBusesToDestination(int[][] routes, int source, int target) {
            // Create a map from stop a ==== > all possible direct routes
            fillrouteMap(routes);

            System.out.println(routemap);

            if (!routemap.containsKey(source) || !routemap.containsKey(target)) {
                return -1;
            }
            // Do recursion
            solve(source, 0, target);

            return shortRoute;
        }

        private void solve(int current, int stops, int target) {

            if (current == target) {
                if (stops < shortRoute)
                    shortRoute = stops;
            }
            visited.add(current);
            System.out.println("visiting neighbours of " + current + " : " + routemap.get(current));
            for (int a : routemap.get(current)) {
                if (!visited.contains(a)) {

                    solve(a, stops + 1, 3);

                }

            }

        }

        private void fillrouteMap(int[][] routes) {
            for (int[] route : routes) {
                for (int i = 0; i < route.length; i++) {
                    HashSet<Integer> routeStopsA = routemap.getOrDefault(route[i], new HashSet<Integer>());
                    for (int j = i + 1; j < route.length; j++) {
                        HashSet<Integer> routeStopsB = routemap.getOrDefault(route[j], new HashSet<Integer>());
                        routeStopsA.add(route[j]);
                        routeStopsB.add(route[i]);
                        routemap.put(route[j], routeStopsB);
                    }
                    routemap.put(route[i], routeStopsA);
                }
            }
        }
    }
}
