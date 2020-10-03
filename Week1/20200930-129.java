/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        
        Deque<TreeNode> nodes = new LinkedList<>();
        Deque<Integer> nums = new LinkedList<>();
        int sum = 0;
        nodes.push(root);
        nums.push(root.val);
        
        while (!nodes.isEmpty()) {
            TreeNode tempNode = nodes.pop();
            int tempNum = nums.pop();
            
            if (tempNode.left == null && tempNode.right == null) sum += tempNum;
            
            if (tempNode.right != null) {
                nodes.push(tempNode.right);
                nums.push(10 * tempNum + tempNode.right.val);
            }
            
            if (tempNode.left != null) {
                nodes.push(tempNode.left);
                nums.push(10 * tempNum + tempNode.left.val);
            }
        }
        
        return sum;
    }
}