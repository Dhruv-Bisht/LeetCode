import java.util.*;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> ones1 = new ArrayList<>();
        List<int[]> ones2 = new ArrayList<>();
        
        // 1. Collect coordinates of all 1s in both images
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) ones1.add(new int[]{i, j});
                if (img2[i][j] == 1) ones2.add(new int[]{i, j});
            }
        }
        
        // 2. Map to count the frequencies of each unique shift vector
        Map<String, Integer> deltaCount = new HashMap<>();
        int maxOverlap = 0;
        
        // 3. Compare every 1 in img1 with every 1 in img2
        for (int[] p1 : ones1) {
            for (int[] p2 : ones2) {
                // Calculate the row and column differences (the shift vector)
                int deltaRow = p1[0] - p2[0];
                int deltaCol = p1[1] - p2[1];
                
                // Create a unique hash key for this vector
                String key = deltaRow + "," + deltaCol;
                
                // Update the count for this specific translation vector
                deltaCount.put(key, deltaCount.getOrDefault(key, 0) + 1);
                maxOverlap = Math.max(maxOverlap, deltaCount.get(key));
            }
        }
        
        return maxOverlap;
    }
}
