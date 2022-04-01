// https://leetcode.com/problems/delete-and-earn/
class DeleteAndEarn {
    int[] frequency;
    int min;
    int max;

    public int deleteAndEarn(int[] nums) {
        min = java.util.Arrays.stream(nums).min().getAsInt();
        max = java.util.Arrays.stream(nums).max().getAsInt();
        frequency = new int[max - min + 1];
        for (int num : nums) {
            frequency[num - min] += 1;
        }
        return deleteAndEarn();
    }

    int deleteAndEarn() {
        int a = min * frequency[0];
        if(frequency.length == 1) {
            return a;
        }
        int b = Math.max(frequency[1] * (min + 1), a);
        for(int i = min + 2; i <= max; i++) {
            int t = Math.max(b, a + frequency[i - min] * i);
            a = b;
            b = t;
        }
        return Math.max(a, b);
    }
}