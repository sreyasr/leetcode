class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        int N = nums.length;
        int iNum;
        for(int i = 0; i < N && i <= max; i++) {
            iNum = i + nums[i];
            if(iNum > max) {
                max = iNum;
            }
            max = Math.max(i + nums[i], max);
        }
        return max >= N - 1;
    }
}