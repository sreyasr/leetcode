// https://leetcode.com/problems/permutation-in-string/
class Solution {
    Set<Character> characterSet;
    public boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        if(s1Length > s2Length) {
            return false;
        }
        characterSet = new HashSet<>();
        int[] fMap = new int[256];
        for(int i = 0; i < s1Length; i++) {
            char iChar = s1.charAt(i);
            characterSet.add(iChar);
            fMap[iChar]+= 1;
        }

        for(int i = 0; i < s1Length; i++) {
            char iChar = s2.charAt(i);
            characterSet.add(iChar);
            fMap[iChar]-= 1;
        }
        if(checkAll0(fMap)) {
            return true;
        }
        for(int i = s1Length; i < s2Length; i++) {
            char iChar = s2.charAt(i);
            char tChar = s2.charAt(i - s1Length);
            fMap[iChar] -= 1;
            fMap[tChar] += 1;
            if(checkAll0(fMap)) {
                return true;
            }
        }
        return false;
    }

    boolean checkAll0(int[] nums) {
        for(Character character: characterSet) {
            if(nums[character] != 0) {
                return false;
            }
        }
        return true;
    }
}