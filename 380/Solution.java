class RandomizedSet {

    private int lastIndex;
    private HashMap<Integer,Integer> mapper;
    private ArrayList<Integer> access;
    private HashSet<Integer> removed;

    public RandomizedSet() {
        this.lastIndex = 0;
        this.mapper = new HashMap<>();
        this.removed = new HashSet<>();
        this.access = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(!this.mapper.containsKey(val)){
            this.mapper.put(val,this.lastIndex);
            this.access.add(val);
            this.lastIndex++;
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean remove(int val) {
        if(this.mapper.containsKey(val)){
            this.removed.add(this.mapper.get(val));
            this.mapper.remove(val);
            return true;
        }
        else{
            return false;
        }
    }
    
    public int getRandom() {
        Random rand = new Random();
        int res = rand.nextInt(this.lastIndex);
        while(this.removed.contains(res)){
            res = rand.nextInt(this.lastIndex);
        }
        return this.access.get(res);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */