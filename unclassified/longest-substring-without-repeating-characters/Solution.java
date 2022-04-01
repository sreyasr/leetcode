import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> a = new HashSet<>();
        int start = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            char iChar = s.charAt(i);
            if (a.contains(iChar)) {
                int pos = i;
                for (int j = start; j < i; j++) {
                    char jChar = s.charAt(j);
                    if (iChar == jChar) {
                        pos = j + 1;
                        break;
                    }
                    a.remove(jChar);
                }
                if (i - start > maxEnd - maxStart) {
                    maxStart = start;
                    maxEnd = i;
                }
                start = pos;
            } else {
                a.add(iChar);
            }
        }
        if (s.length() - start > maxEnd - maxStart) {
            maxStart = start;
            maxEnd = s.length();
        }
        return maxEnd - maxStart;
    }
}