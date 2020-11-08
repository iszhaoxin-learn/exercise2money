class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        
        List<Set<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) adj.add(new HashSet<>());
        
        for (int i = 0; i < edges.length; i++) {
            int n1 = edges[i][0], n2 = edges[i][1];
            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
        }
        
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) leaves.add(i);
        }
        
        int leftNodes = n;
        while (!leaves.isEmpty() && leftNodes > 2) {
            int size = leaves.size();
            List<Integer> nextLeaves = new ArrayList<>();
            leftNodes -= size;
            
            for (int i = 0; i < size; i++) {
                int node = leaves.get(i);
                for (int adjNode : adj.get(node)) {
                    adj.get(adjNode).remove(node);
                    if (adj.get(adjNode).size() == 1)
                        nextLeaves.add(adjNode);
                }
            }
            
            leaves = nextLeaves;
        }
        
        return leaves;
    }
}