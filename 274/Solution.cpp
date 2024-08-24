class Solution {
public:
    int minim(int a, int b){
        return a>b ? b : a;
    }

    int hIndex(vector<int>& citations) {
        sort(citations.begin(),citations.end(),greater<>());
        int h_index = 0;
        for(int i=0;i<citations.size();++i){
            if(citations[i]>=i+1){
                h_index = min(i+1,citations[i]);
            }
        }
        return h_index;

    }
};