class Solution {
public:
    int minimum(int a, int b){
        return a>b ? b : a;
    }
    int rangeBitwiseAnd(int left, int right) {
        int step = 0;
        while(step<32){
            if((left>>(step))!=(right>>(step))){
                step++;
            }
            else{
                break;
            }
        }
        return (minimum(left,right)>>step)<<step;
    }
};