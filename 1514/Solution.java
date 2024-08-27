class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        HashMap<Integer,ArrayList<Pear>> adjList = new HashMap<>();
        for(int i=0;i<n;++i){
            adjList.put(i,new ArrayList<>());
        }
        for(int i=0;i<edges.length;++i){
            adjList.get(edges[i][0]).add(new Pear(edges[i][1],succProb[i]));
            adjList.get(edges[i][1]).add(new Pear(edges[i][0],succProb[i]));
        }
        double[] result = new double[n];
        Arrays.fill(result, 0.0);
        PriorityQueue<Pear> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.weight, a.weight));
        maxHeap.add(new Pear(start_node,1.0));
        while(!maxHeap.isEmpty()){
            Pear x = maxHeap.poll();
            if(result[x.node]!=0.0){
                continue;
            }
            result[x.node] = x.weight;

            for(Pear item : adjList.get(x.node)) {
                if(result[item.node]==0.0){
                    maxHeap.add(new Pear(item.node, item.weight * x.weight));
                }
            }
        }
        return result[end_node];
    }
}

class Pear{
    public int node;
    public double weight;

    public Pear(int node,double weight){
        this.node = node;
        this.weight = weight;
    }
}