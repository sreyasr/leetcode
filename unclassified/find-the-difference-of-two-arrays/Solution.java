// https://leetcode.com/problems/find-the-difference-of-two-arrays/
class FindDifference {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set a = new HashSet<>();
        Set b = new HashSet<>();
        List x = new ArrayList<>();
        List y = new ArrayList<>();
        for(var num: nums1) {
            a.add(num);
        }
        for(var num: nums2) {
            b.add(num);
        }
        var z = new HashSet(a);
        z.removeAll(b);
        x.addAll(z);
        b.removeAll(a);
        y.addAll(b);
        return List.of(x, y);
    }
}