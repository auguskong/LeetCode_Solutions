/**
* Date: 1/30/19
* Type: 3-way partitioning
*
*/ 

class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = 0;
        int left = 0;
        int right = nums.length - 1;
        while (i <= right) { // here must use the i pointer 
            if (nums[i] < 1) {
                swap(nums, left++, i++);
            } else if (nums[i] > 1) {
                swap(nums, i, right--);
            } else {
                i++;
            }
        }
        
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}