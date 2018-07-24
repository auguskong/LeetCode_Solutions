class Colution {
	public int climbStairs(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		if (n == 2) return 2;

		int oneStepBefore = 2; //stair == 2
		int twoStepsBefore = 1; //stair == 1
		int allSteps = 0;
		for (int i = 2; i < n; i++) {
			//start from the stair 3
			allSteps = oneStepBefore + twoStepsBefore; //current state

			//next state
			twoStepsBefore = oneStepBefore; 
			oneStepBefore = allSteps; 
		}
		return allSteps;
	}
}