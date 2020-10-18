// Given a binary tree, find its maximum depth.

// The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

// Note: A leaf is a node with no children.

// Example:

// Given binary tree [3,9,20,null,null,15,7],

//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its depth = 3.

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

//我的答案
class Solution {
    
    int max = 1;
    int cur = 1;
    
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return findMaxDepth(root);
    }
    
    public int findMaxDepth(TreeNode t) {
        if (t.left != null) {
            cur +=1;
            findMaxDepth(t.left);
        }
        if (t.right != null) {
            cur += 1;
            findMaxDepth(t.right);
        }
        
        max = max > cur? max : cur;
        cur -= 1;
        return max;
        
        
        
    }
}

//别人的答案 
public int maxDepth(TreeNode root) {
    if(root==null){
            return 0;
    }
    return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
}
