class Solution {
    public int maxArea(int[] height) {
        int area = 0, maxArea = 0;
        int left = 0, right = height.length - 1;

        while(left < right){
            int width = right - left;
            int length = Math.min(height[left], height[right]);
            area = width * length;
            maxArea = Math.max(area, maxArea);
            if(height[left] < height[right]){left++;}
            else{right--;}
        }
        return maxArea;
    }
}