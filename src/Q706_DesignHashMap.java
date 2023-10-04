public class Q706_DesignHashMap {
    public static void main(String[] args) {

        String[] func = new String[] { "put", "put", "get", "get", "put", "get", "remove", "get" };
        int[][] params = new int[][] { { 1, 1 }, { 2, 2 }, { 1 }, { 3 }, { 2, 1 }, { 2 }, { 2 }, { 2 } };
        MyHashMap map = new MyHashMap();
        int i = 0;
        for (; i < func.length; i++) {
            switch (func[i]) {
                case "put": {
                    map.put(params[i][0], params[i][1]);
                    break;
                }
                case "get": {
                    map.get(params[i][0]);
                    break;
                }
                case "remove": {
                    map.remove(params[i][0]);
                    break;
                }
            }

        }

    }

}

class MyHashMap {
    Integer[] storage;

    public MyHashMap() {
        this.storage = new Integer[1000001];

    }

    public void put(int key, int value) {
        // System.out.println("PUT - " + key);
        // int position = key % 10000;
        this.storage[key] = value;
    }

    public int get(int key) {
        // System.out.println("GET - " + key);
        // System.out.println(this.storage[key % 10000]);
        return this.storage[key] != null ? this.storage[key] : -1;

    }

    public void remove(int key) {
        this.storage[key] = null;
    }
}