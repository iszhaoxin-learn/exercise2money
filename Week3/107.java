class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        
        Deque<List<Integer>> reverseRes = new LinkedList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> curLevel = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = nodes.poll();
                curLevel.add(curNode.val);
                if (curNode.left != null) nodes.offer(curNode.left);
                if (curNode.right != null) nodes.offer(curNode.right);
            }
            reverseRes.push(curLevel);
        }
        
        for (List<Integer> level : reverseRes) res.add(level);
        return res;
    }
}