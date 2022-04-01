// https://leetcode.com/problems/jump-game/
class Solution {
    boolean[] can;
    public boolean canJump(int[] nums) {
        int N = nums.length;
        can = new boolean[N];
        Arrays.fill(can, false);
        can[0] = true;
        for(int i = 0; i < N; i++) {
            boolean iCan =  can[i];
            for(int j = 1; j <= nums[i] && i + j < N; j++) {
                can[i + j] |= iCan;
            }
        }
        return can[N - 1];
    }
}