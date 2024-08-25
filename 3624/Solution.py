class Solution:
    def getFinalState(self, nums: List[int], k: int, multiplier: int) -> List[int]:
        for i in range(k):
            id = nums.index(min(nums))
            nums[id] *= multiplier
        return nums