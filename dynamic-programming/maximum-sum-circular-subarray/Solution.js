/**
 * @param {number[]} nums
 * @return {number}
 */
 // https://leetcode.com/problems/maximum-sum-circular-subarray/
var maxSubarraySumCircular = function(nums) {
  let firstSum = null;
  let maximum = nums[0];
  let minimum = nums[0];
  let count = 0;
  let minCount = 0;
  let total = 0;
  for(let i = 0; i < nums.length; i++) {
    total += nums[i];
    count += nums[i];
    minCount+= nums[i];
    maximum = Math.max(maximum, count);
    minimum = Math.min(minCount, minimum);
    if(minCount > 0) {
      minCount = 0;
    }
    if(count < 0) {
      if(firstSum == null) {
        firstSum = maximum;
      }
      count = 0;
    }
  }
  if(total === minimum) {
      return Math.max(maximum, firstSum + count);
  } else {
      return Math.max(maximum, firstSum + count, total - minimum);
  }
};
