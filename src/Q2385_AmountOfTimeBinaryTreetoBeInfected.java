import java.util.ArrayDeque;
import java.util.HashMap;

public class Q2385_AmountOfTimeBinaryTreetoBeInfected {
    public static void main(String[] args) {
        var obj = new Q2385_AmountOfTimeBinaryTreetoBeInfected();
        TreeNode root = obj.new TreeNode(3);
        root.left = obj.new TreeNode(1);
        root.right = obj.new TreeNode(2);

        var result = obj.new Solution().amountOfTime(root, 3);
        System.out.println("ANswer = " + result);
    }

    class Solution {
        TreeNode patientzero = null;

        int pid = -1;
        int mdepth = -1;
        int pidtoroot = -1;

        public int amountOfTime(TreeNode root, int patientid) {
            pid = patientid;
            boolean isPresentInLeftSubtree = false;
            int leftdepth = 0, rightdepth = 0;
            if (root.left != null) {
                getTreeDepth(root.left, 1);
                leftdepth = mdepth;
                mdepth = -1;
                if (pidtoroot > -1) {
                    isPresentInLeftSubtree = true;
                }
            }
            if (root.right != null) {
                getTreeDepth(root.right, 1);
                rightdepth = mdepth;
                mdepth = -1;
            }

            System.out.println("isPresentInLeftSubtree = " + isPresentInLeftSubtree + ", leftdepth=" + leftdepth
                    + ", rightdepth = " + rightdepth + " pidtoroot = " + pidtoroot);
            // Now if patient zero is root return max of left and right depth
            if (root.val != patientid) {
                if (isPresentInLeftSubtree) {
                    // Look for farthest node in left tree then return max of this vs dist root +
                    // rightDepth;

                    // distance from patientzero to farthest node in right subtreee
                    rightdepth = pidtoroot + rightdepth;

                    // No look for node that is th farthest in left subtree
                    root.right = null;
                    leftdepth = doBfs(patientzero);

                } else {
                    leftdepth = pidtoroot + leftdepth;

                    root.left = null;
                    rightdepth = doBfs(patientzero);

                }
            }

            return leftdepth > rightdepth ? leftdepth : rightdepth;

        }

        private void getTreeDepth(TreeNode node, int curdepth) {

            if (pid == node.val) {
                patientzero = node;
                pidtoroot = curdepth;
            }

            if (node.left == null && node.right == null) {
                if (curdepth > mdepth) {
                    mdepth = curdepth;
                }
                return;
            }
            curdepth++;

            if (node.left != null) {
                node.left.parent = node;
                getTreeDepth(node.left, curdepth);
            }
            if (node.right != null) {
                node.right.parent = node;
                getTreeDepth(node.right, curdepth);
            }
        }

        private int doBfs(TreeNode patientzero) {

            int maxDist = 0;
            TreeNode current;
            ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
            HashMap<Integer, Integer> distances = new HashMap<Integer, Integer>();
            distances.put(patientzero.val, 0);
            queue.add(patientzero);

            while (!queue.isEmpty()) {
                current = queue.poll();
                // System.out.println("AT Node - " + current.val);
                // check left node
                if (current.left != null) {
                    if (!distances.containsKey(current.left.val)) {
                        // has not been visited
                        distances.put(current.left.val, distances.get(current.val) + 1);
                        queue.add(current.left);
                    }
                }

                if (current.right != null) {
                    if (!distances.containsKey(current.right.val)) {
                        // has not been visited
                        distances.put(current.right.val, distances.get(current.val) + 1);
                        queue.add(current.right);
                    }
                }

                if (current.parent != null) {
                    if (!distances.containsKey(current.parent.val)) {
                        // has not been visited
                        distances.put(current.parent.val, distances.get(current.val) + 1);
                        queue.add(current.parent);
                    }
                }

                if (distances.get(current.val) > maxDist) {
                    // System.ou
                    maxDist = distances.get(current.val);
                }

            }
            return maxDist;
        }

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

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
