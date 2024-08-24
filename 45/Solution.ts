function jump(nums: number[]): number {
    let id = 0;
    let maxpoint = 0;
    let select = 0;
    let step = 0;
    while(id<nums.length-1){
        for(let i=id+1;i<=id+nums[id];++i){
            if(nums[i]+(i-id)>=maxpoint){
                maxpoint = nums[i]+(i-id);
                select = i;
            }
            if(i==nums.length-1){
                select = i;
                break;
            }
        }
        maxpoint = 0;
        id = select;
        step++;
    }
    return step;
};