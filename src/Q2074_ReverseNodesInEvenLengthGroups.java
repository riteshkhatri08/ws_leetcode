public class Q2074_ReverseNodesInEvenLengthGroups {
    public static void main(String[] args) {
        var obj = new Q2074_ReverseNodesInEvenLengthGroups();

        int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        ListNode head = obj.new ListNode();
        addNodes(obj, head, arr);
        head = head.next;

        head = new Q2074_ReverseNodesInEvenLengthGroups().new Solution().reverseEvenLengthGroups(head);
        System.out.println("ANSWER =" + obj.print(head));
    }

    class Solution {
        public ListNode reverseEvenLengthGroups(ListNode head) {

            if (head.next == null) {
                return head;
            }

            // go to second node
            ListNode groupend, prevgrouptail = null, groupstart;
            int targetgroupsize = 0, currentgroupsize = 0;
            groupend = head;
            while (groupend != null) {
                targetgroupsize++;
                currentgroupsize = 0;
                groupstart = prevgrouptail;
                // Find first group
                while (groupend != null && currentgroupsize < targetgroupsize) {
                    prevgrouptail = groupend;
                    groupend = groupend.next;
                    currentgroupsize++;
                }

                if (currentgroupsize % 2 == 0) {
                    ListNode temporary = groupstart.next;
                    groupstart.next = reverse(temporary, groupend);
                    // 1 .next = 3
                    temporary.next = groupend;
                    prevgrouptail = temporary;
                    // 2.next = 4

                }
            }
            return head;
        }

        private static ListNode reverse(ListNode start, ListNode end) {
            ListNode follower = null, temp = null;
            while (start != end) {
                temp = start.next;
                start.next = follower;
                follower = start;
                start = temp;
            }
            return follower;
        }
    }

    private static void addNodes(Q2074_ReverseNodesInEvenLengthGroups obj,
            Q2074_ReverseNodesInEvenLengthGroups.ListNode head,
            int[] arr) {
        ListNode temp;
        for (int val : arr) {
            temp = obj.new ListNode(val);
            head.next = temp;
            head = head.next;
        }

    }

    public String print(Q2074_ReverseNodesInEvenLengthGroups.ListNode head) {
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
