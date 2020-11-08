class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        
        List<Integer> leafList1 = new ArrayList<>(), leafList2 = new ArrayList<>();
        dfs(root1, leafList1);
        dfs(root2, leafList2);
        
        return leafList1.equals(leafList2);
    }
    
    private void dfs(TreeNode root, List<Integer> leafList) {
        if (root == null) return ;
        if (root.left == null && root.right == null) leafList.add(root.val);
        
        dfs(root.left, leafList);
        dfs(root.right, leafList);
    }
}