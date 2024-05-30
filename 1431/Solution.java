import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        Integer maximum = 0;
        List<Boolean> list = new ArrayList<>();
        for (int i : candies) {
            if(i>maximum){
                maximum = i;
            }
        }
        for (int i : candies) {
            if(i+extraCandies>=maximum){
                list.add(true);
            }
            else{
                list.add(false);
            }
        }
        return list;
    }
}