class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        return maxDepth(root,1);
    }
    
    private int maxDepth(Node root, int depth) {
        if (root.children == null || root.children.size() == 0) return depth;
        
        int max = 0;
        for (Node node : root.children) {
            int childDepth = maxDepth(node, depth + 1);
            max = Math.max(max, childDepth);
        }
        
        return max;
    }
}