/*
For backtracking questions, consider the follow questions:
1. how to keep the current track?
2. how to output the current track?
*/

public List<List<Integer>> subsets(int[] nums) {
	List<List<Integer>> results = new ArrayList<>();
	Arrays.sort(nums);
	helper(results, new ArrayList<>(), nums, 0);
	return results;
}

//define the recursion: find all the subset start with the nums[start] and output to results
private void helper(List<List<Integer>> results, 
										List<Integer> subset, 
										int[] nums, 
										int start) {
	//2. 递归的拆解 deep copy -> create new subset ArrayList
	results.add(new ArrayList(subset));
	for (int i = 0; i < nums.length; i++) {
		//[] -> [1] or [1] -> [1, 2] 
		subset.add(nums[i]);
		helper(results, subset, nums, i + 1);
		subset.remove(subset.size() - 1);
	}
}