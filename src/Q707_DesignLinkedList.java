import java.util.Objects;

public class Q707_DesignLinkedList {

    public static void main(String[] args) {

        String[] func = new String[] { "addAtHead", "addAtHead", "addAtHead", "addAtIndex", "deleteAtIndex",
                "addAtHead", "addAtTail", "get", "addAtHead", "addAtIndex", "addAtHead" };

        // { "addAtHead", "deleteAtIndex", "addAtHead", "addAtHead", "addAtHead",
        // "addAtHead", "addAtHead", "addAtTail",
        // "get", "deleteAtIndex", "deleteAtIndex" };
        // { "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get" };

        int[][] params = new int[][]

        { { 7 }, { 2 }, { 1 }, { 3, 0 }, { 2 }, { 6 }, { 4 }, { 4 }, { 4 }, { 5, 0 }, { 6 } };

        // { { 2 }, { 1 }, { 2 }, { 7 }, { 3 }, { 2 }, { 5 }, { 5 }, { 5 }, { 6 }, { 4 }
        // };
        // { { 1 }, { 3 }, { 1, 2 }, { 1
        // }, { 1 }, { 1 } };

        MyLinkedList myList = new Q707_DesignLinkedList().new MyLinkedList();
        int i = 0;
        StringBuilder result = new StringBuilder("[");
        for (; i < func.length; i++) {
            System.out.println(myList + "    = " + myList.size);
            System.out.println("\n" + func[i] + "  " + params[i][0]);
            switch (func[i]) {
                case "get": {

                    result.append(myList.get(params[i][0]) + ", ");
                    break;
                }
                case "addAtHead": {
                    myList.addAtHead(params[i][0]);
                    result.append("null, ");
                    break;
                }
                case "addAtTail": {

                    myList.addAtTail(params[i][0]);
                    result.append("null, ");
                    break;
                }

                case "addAtIndex": {

                    myList.addAtIndex(params[i][0], params[i][1]);
                    result.append("null, ");
                    break;
                }
                case "deleteAtIndex": {

                    myList.deleteAtIndex(params[i][0]);
                    result.append("null, ");
                    break;
                }
            }
        }
        result.replace(result.length() - 1, result.length(), "]");
        System.out.println(result);

    }

    // Inner Class
    class MyLinkedList {
        int size = 0;
        Node headNode;
        Node tailNode;

        public MyLinkedList() {
            // Left sentinel
            headNode = new Node(-1);
            // right sentinel
            tailNode = new Node(-1);
            headNode.next = tailNode;
            tailNode.prev = headNode;
        }

        public int get(int index) {
            Node nodeAtIndex = getNodeAtIndex(index);

            return Objects.isNull(nodeAtIndex) || nodeAtIndex.value == -1 ? -1 : nodeAtIndex.value;

        }

        public void addAtHead(int val) {
            Node newNode = new Node(val, headNode.next, headNode);
            headNode.next.prev = newNode;
            headNode.next = newNode;
            size++;
        }

        public void addAtTail(int val) {

            Node newNode = new Node(val, tailNode, tailNode.prev);
            tailNode.prev.next = newNode;
            tailNode.prev = newNode;
            size++;
        }

        public void addAtIndex(int index, int val) {

            Node nodeAtIndex = getNodeAtIndex(index);

            if (Objects.isNull(nodeAtIndex)) {
                return;
            } else {
                Node newNode = new Node(val, nodeAtIndex, nodeAtIndex.prev);
                nodeAtIndex.prev.next = newNode;
                nodeAtIndex.prev = newNode;
                size++;
            }

        }

        public void deleteAtIndex(int index) {
            Node nodeAtIndex = getNodeAtIndex(index);
            if (Objects.isNull(nodeAtIndex) || nodeAtIndex.value == -1) {
                return;
            } else {
                nodeAtIndex.prev.next = nodeAtIndex.next;
                nodeAtIndex.next.prev = nodeAtIndex.prev;
                nodeAtIndex.next = null;
                nodeAtIndex.prev = null;
                size--;
            }
        }

        private Node getNodeAtIndex(int index) {
            // System.out.print("LOOKING FOR " + index );
            if (index > size) {
                return null;
            }
            Node temp = headNode.next;
            while (index-- > 0) {
                temp = temp.next;
            }
            // System.out.println( " got " + temp.value);
            return temp;

        }

        public String toString() {
            return "LIST = [ " + headNode.toString() + " ]";
        }
    }

    class Node {

        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;

        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public String toString() {
            return "v=" + value + " " + (next != null ? next.toString() : "");
        }
    }

}
