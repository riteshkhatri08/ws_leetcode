public class Q706_DesignHashMap {
    public static void main(String[] args) {

        String[] func = new String[] { "remove", "put", "put", "put", "put", "put", "put", "get", "put", "put" };

        // { "remove", "get", "put", "put", "put", "get", "put", "put", "put", "put" };
        // { "put", "put", "get", "get", "put", "get", "remove", "get" };
        int[][] params = new int[][] { { 2 }, { 3, 11 }, { 4, 13 }, { 15, 6 }, { 6, 15 }, { 8, 8 }, { 11, 0 }, { 11 },
                { 1, 10 }, { 12, 14 } };
        // { { 14 }, { 4 }, { 7, 3 }, { 11, 1 }, { 12, 1 }, { 7 }, { 1, 19 }, { 0, 3 },
        // { 1, 8 }, { 2, 6 } };
        // { { 1, 1 }, { 2, 2 }, { 1 }, { 3 }, { 2, 1 }, { 2 }, { 2 }, { 2 } };
        MyHashMap map = new Q706_DesignHashMap().new MyHashMap();
        int i = 0;
        StringBuilder result = new StringBuilder("[");
        for (; i < func.length; i++) {
            switch (func[i]) {
                case "put": {
                    map.put(params[i][0], params[i][1]);
                    result.append("null, ");
                    break;
                }
                case "get": {

                    result.append(map.get(params[i][0]) + ", ");
                    break;
                }
                case "remove": {

                    map.remove(params[i][0]);
                    result.append("null, ");
                    break;
                }
            }

        }
        result.replace(result.length() - 1, result.length(), "]");
        System.out.println(result);

    }

    class MyHashMap {

        ListNode[] nodes;

        public MyHashMap() {
            nodes = new ListNode[10000];
        }

        public void put(int key, int value) {

            int hashId = getHashId(key);
            ListNode headNode = nodes[hashId];
            if (headNode == null) {
                ListNode sentinelNode = new ListNode(-1, -1);
                headNode = new ListNode(key, value);
                headNode.next = sentinelNode;
                sentinelNode.prev = headNode;
                nodes[hashId] = headNode;
            } else {

                // Check if a mapping already exists
                ListNode tempNode = headNode;

                while (tempNode.key != -1) {
                    if (tempNode.key == key) {
                        tempNode.value = value;
                        return;
                    } else {
                        tempNode = tempNode.next;
                    }
                }

                ListNode newNode = new ListNode(key, value);
                newNode.next = headNode;
                headNode.prev = newNode;
                nodes[hashId] = newNode;

            }
            // print();
        }

        public int get(int key) {
            int hashId = getHashId(key);

            ListNode headNode = nodes[hashId];
            if (headNode == null || headNode.key == -1) {
                return -1;
            } else {

                ListNode tempNode = headNode;

                while (tempNode.key != -1) {
                    if (tempNode.key == key)
                        return tempNode.value;
                    else
                        tempNode = tempNode.next;
                }
                return -1;
            }
        }

        public void remove(int key) {

            int hashId = getHashId(key);
            ListNode headNode = nodes[hashId];

            if (headNode == null || headNode.key == -1) {
                return;
            }

            if (headNode.key == key) {
                nodes[hashId] = headNode.next;
                headNode.next = null;
                return;
            }

            ListNode tempNode = headNode;
            while (tempNode.key != -1) {
                if (tempNode.key == key) {
                    tempNode.prev.next = tempNode.next;
                    tempNode.next.prev = tempNode.prev;
                    tempNode.next = null;
                    tempNode.prev = null;
                    return;
                } else {
                    tempNode = tempNode.next;
                }
            }
        }

        private int getHashId(int key) {
            return Integer.hashCode(key) % 10000;
        }

        // private void print() {
        // System.out.println("START PRINTING");
        // for (var a : nodes) {
        // if (a != null)
        // System.out.print("[" + a.toString() + "]");

        // }
        // System.out.println("END PRINTING");
        // }

    }

    class ListNode {

        int key, value;
        ListNode next;
        ListNode prev;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {

            return "{k=" + key + ",v=" + value + "}" + (next.key != -1 ? next.toString() : "");

        }
    }

}
