/** 9.6 Implement an algorithm to print all valid (i.e., properly opened and closed) combinations 
 *  of n-pairs of parentheses.
 *  Example
 *  input: 3
 *  Output: ((()))), (()()), (())(), ()(()), ()()()
 */
 
//9:41
 
/** I think
 *  {{{{{}}}}}}
 *  pair from inner
 *  dfs until reach }
 *  suppose it s a linked list
 *  call next until }
 *  how to insert (): 
 *  ()
 *  (()) ()()
 *  ((()))-inside (()())-next to ()()()-outside
 */
 
public static void printParentheses(String result, int input, int left, int right){
	// if curr is '(', then next can be '(' or ')'
	// if curr is ')', then next must be '('
	// if set is empty, initialize to '('
	if(result.isEmpty())
		printParentheses(result+'(', input, left+1, right);
	else if(result.length() == 2*input){
		System.out.println(result);
		return;
	}else if(left < input){
		printParentheses(result+'(', input, left+1, right);
		if(left > right)
			printParentheses(result+')', input, left, right+1);
	}else{
		printParentheses(result+')', input, left, right+1);
	}
}