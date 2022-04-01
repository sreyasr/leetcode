import java.util.*;

// https://leetcode.com/problems/flood-fill/
class Solution {
    int m;
    int n;
    int[][] image;
    Queue<Map.Entry<Integer, Integer>> queue;
    Set<Map.Entry<Integer, Integer>> visited;
    int originalColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        queue = new LinkedList<>();
        this.image = image;
        m = image.length;
        n = image[0].length;
        Map.Entry<Integer, Integer> entry = new AbstractMap.SimpleEntry<>(sr, sc);
        originalColor = image[sr][sc];
        queue.add(entry);
        visited = new HashSet<>();
        visited.add(entry);

        while(!queue.isEmpty()) {
            var c = queue.poll();
            image[c.getKey()][c.getValue()] = newColor;
            var v1 = new AbstractMap.SimpleEntry<>(c.getKey() - 1, c.getValue());
            var v2 = new AbstractMap.SimpleEntry<>(c.getKey() + 1, c.getValue());
            var v3 = new AbstractMap.SimpleEntry<>(c.getKey(), c.getValue() + 1);
            var v4 = new AbstractMap.SimpleEntry<>(c.getKey(), c.getValue() - 1);
            addIfValid(v1);
            addIfValid(v2);
            addIfValid(v3);
            addIfValid(v4);
        }
        return image;
    }

    void addIfValid(Map.Entry<Integer, Integer> entry) {
        if(isValid(entry) && image[entry.getKey()][entry.getValue()] == originalColor && !visited.contains(entry)) {
            queue.add(entry);
            visited.add(entry);
        }
    }

    boolean isValid(Map.Entry<Integer, Integer> entry) {
        return entry.getKey() >= 0 && entry.getValue() >= 0 &&
                entry.getKey() < m && entry.getValue() < n;
    }

}