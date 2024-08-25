class Solution:
    def countPairs(self, nums: List[int]) -> int:
        sum = 0
        clone = nums[:]
        maxlen = len(str(max(nums)))
        for i in range(len(nums)):
            if(len(str(nums[i]))<maxlen):
                nums[i] = str(('0'*(maxlen-len(str(nums[i]))))+str(nums[i]))
            else:
                nums[i] = str(nums[i])
            clone[i] = ''.join(sorted(nums[i]))

        for i in range(len(nums)-1):
            for j in range(i+1,len(nums)):
                if clone[i]==clone[j]:
                    misplaced = 0
                    for k in range(min(len(nums[i]),len(nums[j]))):
                        if(nums[i][k]!=nums[j][k]):
                            misplaced += 1
                    if misplaced<=2:
                        sum +=1
        return sum