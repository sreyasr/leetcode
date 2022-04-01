// https://leetcode.com/problems/maximum-subarray/
class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var maximum: Int = nums[0];
        var currentSum = 0;
        for(i in 0..nums.size - 1) {
            currentSum += nums[i];
            maximum = java.lang.Math.max(currentSum, maximum);
            if(currentSum < 0) {
                currentSum = 0;
            }
        }
        return maximum;
    }
}