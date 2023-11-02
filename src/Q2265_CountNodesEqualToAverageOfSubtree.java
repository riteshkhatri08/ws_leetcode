
public class Q2265_CountNodesEqualToAverageOfSubtree {

    // Q2265_CountNodesEqualToAverageOfSubtree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        var obj = new Q2265_CountNodesEqualToAverageOfSubtree();

        TreeNode root = obj.new TreeNode();

        int res = obj.new Solution().averageOfSubtree(root);
        System.out.println(res);

    }

    class Pair {
        int sum;
        int count;

        Pair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

    class Solution {
        int count = 0;

        public int averageOfSubtree(TreeNode root) {

            Pair res = calcAvg(root);

            return count;
        }

        public Pair calcAvg(TreeNode node) {

            Pair cur = new Pair(node.val, 1);
            if (node.left != null) {
                Pair left = calcAvg(node.left);
                cur.count = cur.count + left.count;
                cur.sum = cur.sum + left.sum;
            }

            if (node.right != null) {
                Pair right = calcAvg(node.right);
                cur.count = cur.count + right.count;
                cur.sum = cur.sum + right.sum;
            }

            if ((cur.sum / cur.count) == node.val) {
                count++;
            }
            // System.out.println("Returning from " + node.val + " with average = " + avg);
            return cur;

        }
    }
}
