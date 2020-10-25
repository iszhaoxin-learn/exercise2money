class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            int j = manager[i];
            if (!graph.containsKey(j)) {
                graph.put(j, new ArrayList<>());
            }
            
            graph.get(j).add(i);
        }
        
        return dfs(graph, headID, informTime);
    }
    
    public int dfs(Map<Integer, List<Integer>> graph, int node, int[] informTime) {
        if (!graph.containsKey(node)) return 0;
        
        List<Integer> children = graph.get(node);
        int max = 0;
        for (int i = 0; i < children.size(); i++) {
            max = Math.max(max, dfs(graph, children.get(i), informTime));
        }
        
        return informTime[node] + max;
    }
}