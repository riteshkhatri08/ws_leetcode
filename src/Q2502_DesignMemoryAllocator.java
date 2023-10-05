public class Q2502_DesignMemoryAllocator {
    public static void main(String[] args) {

        String[] func = new String[] { "allocate", "allocate", "allocate", "free", "allocate", "allocate", "allocate",
                "free", "allocate", "free" };

        int[][] params = new int[][] { { 1, 1 }, { 1, 2 }, { 1, 3 }, { 2 }, { 3, 4 }, { 1, 1 }, { 1, 1 }, { 1 },
                { 10, 2 }, { 7 } };

        Allocator allocator = new Q2502_DesignMemoryAllocator().new Allocator();
        int i = 0;
        StringBuilder result = new StringBuilder("[");
        for (; i < func.length; i++) {
            switch (func[i]) {
                case "allocate": {
                    result.append(allocator.allocate(params[i][0], params[i][1]) + ", ");
                    break;
                }
                case "free": {

                    result.append(allocator.free(params[i][0]) + ", ");
                    break;
                }

            }
        }
        result.replace(result.length() - 1, result.length(), "]");
        System.out.println(result);

    }

    class Allocator {

        public int allocate(int requiredSize, int mID) {

            return -1;

        }

        public int free(int mID) {

            return -1;
        }

    }
}
