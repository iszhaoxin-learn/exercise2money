class Solution {
    public int rob(TreeNode root) {
        return Math.max(rob(root, true), rob(root, false));
    }
    
    private int rob(TreeNode root, boolean isRobbed) {
        if (root == null) return 0;
        
        if (isRobbed == true) {
            return rob(root.left, !isRobbed) + rob(root.right, !isRobbed) + root.val;
        } else {
            int selectLeft = rob(root.left, !isRobbed);
            int ignoreLeft = rob(root.left, isRobbed);
            int selectRight = rob(root.right, !isRobbed);
            int ignoreRight = rob(root.right, isRobbed);
            return Math.max(Math.max(Math.max(selectLeft + selectRight, selectLeft + ignoreRight), ignoreLeft + selectRight), ignoreLeft + ignoreRight);
        }
    }
}