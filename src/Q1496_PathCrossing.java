import java.util.HashSet;

public class Q1496_PathCrossing {

    class Solution {

        public boolean isPathCrossing(String path) {
            int x = 0, y = 0;
            HashSet<String> set = new HashSet<String>();
            set.add("0,0");
            StringBuilder point = new StringBuilder();
            for (char c : path.toCharArray()) {
                switch (c) {
                    case 'N': {
                        y++;
                        break;
                    }
                    case 'S': {
                        y--;
                        break;
                    }
                    case 'E': {
                        x++;
                        break;
                    }
                    case 'W': {
                        x--;
                        break;
                    }
                }
                point = point.append(x).append(",").append(y);
                if (set.contains(point.toString())) {
                    return true;
                } else {
                    set.add(point.toString());
                }
                point.setLength(0);

            }
            return false;

        }
    }

}
