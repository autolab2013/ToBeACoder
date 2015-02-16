/** 9.8 Given an infinite number of quarters(25 cents), dimes(10 cents), nickels(5 cents)
 *  and pennies(1 cent), write code to calculate the number of ways of representing n cents.
 */
 
/** I think
 *  DP
 *  top-down: n-5, n-10, n-25
 *  Use HashMap<Integer, Integer> ways<value, number>
 *  base: 1=>1, <1 => 0
 *  
 */
 
public static int countWays(int cents){
	int[] coins = {1, 5, 10, 25};
	if(cents < 1)
		return 0;
	else if(cents == 1)
		return 1;
	return countWays(cents-coins[0]) + countWays(cents-coins[1]) + countWays(cents-coins[2])+ countWays(cents-coins[3]);
}

/** Book solution
 *  I do it wrong.
 *  This problem is solving a+5b+10c+25d = n
 *  get the size of set {a,b,c,d}
 *  by choosing the number of a/b/c/d we can get different sets
 */
 
//cached book solution
int makeChange(int n){
	int[] denoms = {25, 10, 5, 1};
	int[][] map = new int[n+1][denoms.length];
	return makeChange(n, denoms, 0, map);
}

int makeChange(int amount, int[] denoms, int index, int[][] map){
	if(map[amount][index]>0)
		return map[amount][index];
	if(index >= denoms.length - 1)
		return 1;
	int denomAmout = denoms[index];
	int ways = 0;
	for(int i=0; i*denomAmout<=amount; i++){
		int amountRemaining = amount - i*denomAmout;
		ways += makeChange(amountRemaining, denoms, index+1, map);
	}
	map[amount][index] = ways;
	return ways;
}