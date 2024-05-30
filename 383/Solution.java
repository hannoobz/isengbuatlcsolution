class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> b = new HashMap<>();
        HashMap<Character,Integer> c = new HashMap<>(); 
        for(Character a : ransomNote.toCharArray()){
            int count = b.getOrDefault(a, 0);
            b.put(a,count+1);
        }

        for (Character a : magazine.toCharArray()){
            int count = c.getOrDefault(a, 0);
            c.put(a,count+1);
        }

        for(Character key : b.keySet()) {
            Integer valueB = b.get(key);
            Integer valueC = c.get(key);
            if(valueB == null || valueC == null || valueB > valueC) {
                return false;
            }
        }
        return true;
    }
}