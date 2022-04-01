import java.util.*;

// https://leetcode.com/problems/max-area-of-island/
class Solution {
    int m;
    int n;
    int[][] grid;
    int max = 0;
    Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
    Queue<Map.Entry<Integer, Integer>> queue;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    countIsland(i, j);
                }
            }
        }
        return max;
    }

    void countIsland(int i, int j) {
        queue = new LinkedList<>();
        Map.Entry<Integer, Integer> entry = new AbstractMap.SimpleEntry<>(i, j);
        queue.add(entry);
        int count = 0;
        while(!queue.isEmpty()) {
            var c = queue.poll();
            visited.add(c);
            count++;
            var v1 = new AbstractMap.SimpleEntry<>(c.getKey() - 1, c.getValue());
            var v2 = new AbstractMap.SimpleEntry<>(c.getKey() + 1, c.getValue());
            var v3 = new AbstractMap.SimpleEntry<>(c.getKey(), c.getValue() + 1);
            var v4 = new AbstractMap.SimpleEntry<>(c.getKey(), c.getValue() - 1);
            addIfValid(v1);
            addIfValid(v2);
            addIfValid(v3);
            addIfValid(v4);
        }
        this.max = Math.max(max, count);
    }

    void addIfValid(Map.Entry<Integer, Integer> entry) {
        if(isValid(entry) && grid[entry.getKey()][entry.getValue()] == 1 && !visited.contains(entry)) {
            queue.add(entry);
            visited.add(entry);
        }
    }

    boolean isValid(Map.Entry<Integer, Integer> entry) {
        return entry.getKey() >= 0 && entry.getValue() >= 0 &&
                entry.getKey() < m && entry.getValue() < n;
    }
}