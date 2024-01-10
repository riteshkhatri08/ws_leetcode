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

    class Solution {
        HashMap<Integer, TreeNode> parentMap = new HashMap<Integer, TreeNode>();
        TreeNode patientzero = null;

        public int amountOfTime(TreeNode root, int patientid) {
            traverseTreeAndLookForPatientZero(root, patientid);
            // System.out.println(parentMap);
            // Now look for the node which farthest from parent Map

            int time = 0;
            int maxDist = 0;
            TreeNode current;
            ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
            HashMap<Integer, Integer> distances = new HashMap<Integer, Integer>();
            distances.put(patientid, 0);
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

                if (parentMap.containsKey(current.val)) {
                    if (!distances.containsKey(parentMap.get(current.val).val)) {
                        // has not been visited
                        distances.put(parentMap.get(current.val).val, distances.get(current.val) + 1);
                        queue.add(parentMap.get(current.val));
                    }
                }

                if (distances.get(current.val) > maxDist) {
                    // System.ou
                    maxDist = distances.get(current.val);
                }

            }

            // System.out.println(distances);

            return maxDist;
        }

        public void traverseTreeAndLookForPatientZero(TreeNode node, int patientid) {
            if (node.val == patientid) {
                patientzero = node;
            }

            if (node.left == null && node.right == null) {
                return;
            }

            if (node.left != null) {
                parentMap.put(node.left.val, node);
                traverseTreeAndLookForPatientZero(node.left, patientid);
            }
            if (node.right != null) {
                parentMap.put(node.right.val, node);
                traverseTreeAndLookForPatientZero(node.right, patientid);
            }

        }
    }
}
