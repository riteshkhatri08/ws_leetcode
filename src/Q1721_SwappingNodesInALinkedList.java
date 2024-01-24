public class Q1721_SwappingNodesInALinkedList {
    public static void main(String[] args) {
        var obj = new Q1721_SwappingNodesInALinkedList();

        int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        int k = 3;
        ListNode head = obj.new ListNode();
        addNodes(obj, head, arr);
        head = head.next;

        new Q1721_SwappingNodesInALinkedList().new Solution().swapNodes(head, k);
        System.out.println("ANSWER =" + obj.print(head));
    }

    class Solution {
        public ListNode swapNodes(ListNode head, int k) {
            if (head.next == null) {
                return head;
            }
            ListNode slow = head, fast = head, left = null;
            // Reach k'th Node

            while (k > 1) {
                fast = fast.next;
                k--;
            }
            // System.out.println("kth Node left= " + fast.data);
            left = fast;

            // reach kth node from right;
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            // right =slow;
            // System.out.println("kth Node right= " + right.data);
            int temp = left.val;
            left.val = slow.val;
            slow.val = temp;
            return head;
        }
    }

    private static void addNodes(Q1721_SwappingNodesInALinkedList obj, Q1721_SwappingNodesInALinkedList.ListNode head,
            int[] arr) {
        ListNode temp;
        for (int val : arr) {
            temp = obj.new ListNode(val);
            head.next = temp;
            head = head.next;
        }

    }

    public String print(Q1721_SwappingNodesInALinkedList.ListNode head) {
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
