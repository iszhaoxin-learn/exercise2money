class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] topOrder = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) graph.add(new LinkedList<>());
        
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            graph.get(from).add(to);
            indegree[to]++;
        }
        
        Queue<Integer> zeroIn = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) zeroIn.offer(i);
        }
        
        int idx = 0;
        while (!zeroIn.isEmpty()) {
            int node = zeroIn.poll();
            for (int adjNode : graph.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) zeroIn.offer(adjNode);
            }
            topOrder[idx++] = node;
        }
        
        if (idx != numCourses) return new int[0];
        return topOrder;
    }
}