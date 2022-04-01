// https://leetcode.com/problems/jump-game/
class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        int N = nums.length;
        for(int i = 0; i < N && i <= max; i++) {
            max = Math.max(i + nums[i], max);
        }
        return max >= N - 1;
    }
}