// https://leetcode.com/problems/jump-game-ii/
class Solution {
    public int jump(int[] nums) {
        int N = nums.length;
        int [] minJumps = new int[N];
        java.util.Arrays.fill(minJumps, Integer.MAX_VALUE);
        minJumps[0] = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 1; j < nums[i] + 1 && i + j < N; j++) {
                minJumps[i + j] = Math.min(minJumps[i + j], minJumps[i] + 1);
            }
        }
        return minJumps[N - 1];
    }
}