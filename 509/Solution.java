class Solution {
    public int fib(int n) {
        HashMap<Integer,Integer> a = new HashMap<>();
        return truFib(n,a);
    }

    public Integer truFib(Integer n,HashMap<Integer,Integer> a){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(a.containsKey(n)){
            return a.get(n);
        }
        a.put(n,truFib(n-1,a)+truFib(n-2,a));
        return a.get(n);
    }
}