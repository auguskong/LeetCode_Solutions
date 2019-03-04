public class Solution {

	public int findKthLargest(int[] nums, int k) {
		return partition(nums, k, 0, nums.length - 1);
	}

	private int partition(int[] nums, int k, int start, int end) {

		int pivot = nums[start];
		int left = start;
		int right = end;

		while (left <= right) {
			while (left <= right && nums[left] >= pivot) left++;
			while (left <= right && nums[right] <= pivot) right--;
			if (left < right) swap(nums, left, right);
		}

		swap(nums, start, right);

		if (k == right + 1) return nums[right];
		if (k > right + 1) {
			return partition(nums, k, right + 1, end);
		} else {
			return partition(nums, k, start, right -1);
		}
	}

	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}