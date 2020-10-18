class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> itinerary = new LinkedList<>();
        if (tickets == null || tickets.size() == 0) return itinerary;
        
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            List<String> edges = graph.get(ticket.get(0));
            if (edges == null) {
                edges = new LinkedList<>();
                graph.put(ticket.get(0), edges);
            }
            edges.add(ticket.get(1));
        }
        
        for (String from : graph.keySet()) {
            graph.get(from).sort(null);
        }
        
        String from = "JFK";
        dfs(graph, itinerary, from);
        return itinerary;
    }
    
    private void dfs(Map<String, List<String>> graph, List<String> itinerary, String from) {
        List<String> tos = graph.get(from);
        while (tos != null && tos.size() != 0) {
            String to = tos.remove(0);
            dfs(graph, itinerary, to);
        }
        itinerary.add(0, from);
    }
}