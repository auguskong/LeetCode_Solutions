public int climbStairs(int n) {
	if (n <= 0) return 0;
	if (n == 1) return 1;
	if (n == 2) return 2;

	int all_ways = 0;
	int one_step_before = 2;
	int two_steps_before = 1;
	//use for loop from stairs == 3
	for (int i = 3; i <= n; i++) {
		all_ways = one_step_before + two_steps_before;

		//update for the next level stair
		//first update two_steps_before -> one_step_before 
		//because the one_step_before used the two_steps_before
		two_steps_before = one_step_before;
		one_step_before = all_ways;
	}

	return all_ways;
}