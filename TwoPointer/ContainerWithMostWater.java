/***
* Date: 01/16/2019
* Type: Two pointers
* 
*
*/

class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            int width = right - left;
            maxArea = Math.max(width*(Math.min(height[left], height[right])), maxArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}