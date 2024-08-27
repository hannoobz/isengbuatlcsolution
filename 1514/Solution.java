class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        HashMap<Integer,ArrayList<Pair<Integer,Double>>> adjList = new HashMap<>();
        for(int i=0;i<n;++i){
            adjList.put(i,new ArrayList<>());
        }
        for(int i=0;i<edges.length;++i){
            adjList.get(edges[i][0]).add(new Pair(edges[i][1],succProb[i]));
            adjList.get(edges[i][1]).add(new Pair(edges[i][0],succProb[i]));
        }
        HashMap<Integer,Double> result = new HashMap<>();
        PriorityQueue<Pair<Integer, Double>> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));
        maxHeap.add(new Pair<>(start_node,1.0));
        while(!maxHeap.isEmpty()){
            Pair<Integer,Double> x = maxHeap.poll();
            if(result.containsKey(x.getKey())){
                continue;
            }
            result.put(x.getKey(),x.getValue());

            for(Pair<Integer, Double> item : adjList.get(x.getKey())) {
                if(!result.containsKey(item.getKey())){
                    maxHeap.add(new Pair<>(item.getKey(), item.getValue() * x.getValue()));
                }
            }
        }
        if(result.containsKey(end_node)){
            return result.get(end_node);
        }
        return 0;
    }

}