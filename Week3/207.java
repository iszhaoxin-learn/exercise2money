class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        
        for (int i = 0; i < prerequisites.length; i++) {
            int w = prerequisites[i][0], v = prerequisites[i][1];
            adj.get(v).add(w);
            inDegree[w]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int noIndegree = 0;
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                noIndegree++;
            }
        }
        
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : adj.get(v)) {
                if (--inDegree[w] == 0) {
                    queue.offer(w);
                    noIndegree++;
                }
            }
        }
        
        return noIndegree == numCourses;
    }
}