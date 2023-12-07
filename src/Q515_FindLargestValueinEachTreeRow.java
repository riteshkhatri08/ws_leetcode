import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q515_FindLargestValueinEachTreeRow {

    public static void main(String[] args) {
        Q515_FindLargestValueinEachTreeRow obj = new Q515_FindLargestValueinEachTreeRow();
        // int[] nums = new int[] { 1, 2, 3, 1, 1, 3 };
        System.out.println(obj.new Solution().largestValues(obj.new TreeNode(0)));
    }

    class TreeNode {
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

    class Solution {

        HashMap<Integer, Integer> maxMap = new HashMap<Integer, Integer>(10);

        public List<Integer> largestValues(TreeNode root) {
            if (root == null) {
                return new ArrayList<Integer>();
            }
            traverseNode(root, 0);
            return new ArrayList(maxMap.values());
        }

        public void traverseNode(TreeNode node, int currentLevel) {

            if (node.val >= maxMap.getOrDefault(currentLevel, Integer.MIN_VALUE)) {
                maxMap.put(currentLevel, node.val);
            }
            if (node.left != null)
                traverseNode(node.left, currentLevel + 1);
            if (node.right != null)
                traverseNode(node.right, currentLevel + 1);

        }
    }

}