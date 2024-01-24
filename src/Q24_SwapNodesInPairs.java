public class Q24_SwapNodesInPairs {

    public static void main(String[] args) {
        var obj = new Q24_SwapNodesInPairs();

        int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        ListNode head = obj.new ListNode();
        addNodes(obj, head, arr);
        head = head.next;

        head = new Q24_SwapNodesInPairs().new Solution().swapPairs(head);
        System.out.println("ANSWER =" + obj.print(head));
    }

    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            // Replace this placeholder return statement with your code
            ListNode first = null, second = head, third = head.next, temp = null;
            head = head.next;
            // F S T TM
            // null , 1 => 2 => 3 => 4 => 5 => null
            // null , 2 => 1 => 3 => 4 => 5 => null

            while (third != null) {
                temp = third.next;
                third.next = second;
                second.next = temp;
                if (first != null) {
                    first.next = third;
                }

                first = second;
                second = temp;
                third = (temp != null) ? temp.next : null;

            }

            return head;
        }
    }

    private static void addNodes(Q24_SwapNodesInPairs obj, Q24_SwapNodesInPairs.ListNode head,
            int[] arr) {
        ListNode temp;
        for (int val : arr) {
            temp = obj.new ListNode(val);
            head.next = temp;
            head = head.next;
        }

    }

    public String print(Q24_SwapNodesInPairs.ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val).append(" ,");
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
