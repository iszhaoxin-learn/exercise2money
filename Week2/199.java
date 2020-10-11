class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new LinkedList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.remove();
                
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
                if (i == size - 1) res.add(tmp.val);
            }
        }
        
        return res;
    }
}