public class Q606_ConstructStringfromBinaryTree {

    public static void main(String[] args) {
        var obj = new Q606_ConstructStringfromBinaryTree();
        TreeNode root = obj.new TreeNode(1);

        var result = obj.new Solution().tree2str(root);
        System.out.println("ANSWER = " + result);
    }

    class Solution {
        StringBuilder result = new StringBuilder();

        public String tree2str(TreeNode root) {
            helper(root);
            result.length();
            result.deleteCharAt(0);
            result.deleteCharAt(result.length() - 1);
            return result.toString();
        }

        public void helper(TreeNode node) {

            if (node == null) {

                return;
            }

            result.append("(");
            result.append(node.val);

            if (node.left == null && node.right != null) {
                result.append("()");
            }
            helper(node.left);
            helper(node.right);

            result.append(")");

        }

    }

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

}
