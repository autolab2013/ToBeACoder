/** A child is running up a staircase with n steps and can hop either 1 step, 2 steps or 3 steps at a time.
 *  Implement a method to count how many possible ways the child can run up the stairs.
 */
 
/** I think
 *  easy one
 */
public static int runUpStairs(int stairs){
	if(stairs < 0)
		return 0;
	else if(stairs == 0)
		return 1;
	else 
		return runUpStairs(stairs - 1) +runUpStairs(stairs - 2) + runUpStairs(stairs -3);
}

/** Book solution
 *  runtime exponential O(3^n);
 *  use dynamic programming
 */
 
public static int runUpStairs(int stairs, int[] map){
	if(stairs < 0)
		return 0;
	else if(stairs == 0)
		return 1;
	else if(map[stairs] > -1)
		return map[stairs];
	else{
		map[stairs] = runUpStairs(stairs - 1) +runUpStairs(stairs - 2) + runUpStairs(stairs -3);
		return map[stairs];
	}
}