class Solution {
public:
    int candy(vector<int>& ratings) {
        vector<int> result = {1};
        int inresult = 0;
        int current = 1;
        for(int i=0;i<ratings.size()-1;i++){
            if(ratings[i+1]>ratings[i]){
                current++;
            }
            else{
                current = 1;
            }
            result.push_back(current);
        }
        for(int i=ratings.size()-1;i>0;i--){
            if(ratings[i]<ratings[i-1] && result[i]>=result[i-1]){
                result[i-1] = result[i]+1;
            }
            inresult += result[i];
        }
        
        inresult += result[0];

        return inresult;
    }
};