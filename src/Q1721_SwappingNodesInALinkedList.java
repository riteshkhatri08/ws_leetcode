public class Q1721_SwappingNodesInALinkedList {
    public static void main(String[] args) {
        var obj = new Q1721_SwappingNodesInALinkedList();

        int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        ListNode head = obj.new ListNode();
        addNodes(obj, head, arr);
        head = head.next;

        new Q1721_SwappingNodesInALinkedList().new Solution().reorderList(head);
        System.out.println("ANSWER =" + obj.print(head));
    }

    class Solution {

        public void reorderList(ListNode head) {

            if (head == null || head.next == null) {
                return;
            }
            ListNode pointertwo = head, pointerone = head, temp = null;

            // FIND MIDDLE
            while (pointertwo != null && pointertwo.next != null) {
                pointertwo = pointertwo.next.next;
                temp = pointerone;
                pointerone = pointerone.next;
            }
            // Break it in the middle with middle as head for list two
            temp.next = null;

            // NOW Reverse list two
            pointertwo = null;
            while (pointerone != null) {
                temp = pointerone.next;
                pointerone.next = pointertwo;
                pointertwo = pointerone;
                pointerone = temp;
            }

            // Merge both lists
            pointerone = head;

            while (pointerone.next != null) {
                temp = pointerone.next;
                pointerone.next = pointertwo;
                pointerone = temp;
                temp = pointertwo.next;
                pointertwo.next = pointerone;
                pointertwo = temp;

            }
            pointerone.next = pointertwo;

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
