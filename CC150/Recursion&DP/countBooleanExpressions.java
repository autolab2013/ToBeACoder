/** 9.11 Given a boolean expression consisting of the symbols 0, 1, &, |, and ^,
 *  and a desired boolean result value result, implement a function to count the 
 *  number of ways of parenthesizing the expression such that it evaluates to result.
 *  EG
 *  expression: 1^0|0|1
 *  desire: false(0)
 *  output: 2 ways. 1^((0|0)|1) and 1^(0|(0|1))
 */
 
//11:08pm
/** I think
 *  try all the possible ways of combination symbols: 
 *  start:
 *  remove all the non-digits, now have a digital string 1 0 0 1
 *  select any of them as the first symbol of an operation, this means the last digit can not be chosen
 *  digit string length n
 *  try 0~n-2
 *  next: group with left symbol or right symbol
 *  
 *  in a word
 *  original string: select a digit to start
 *  group left or group right
 *  reduce (a operator b) to a char until the string length is 1
 *  terminate?
 */
 
public int countBooleanExpressions(String s, boolean desire, ArrayList<String> expressions, String exp){
	//base
	String str;
	if(s.length() == 1 ){
		if(s == "1" && desired || s== '0' && !desired)
			return 1;
		else
			return 0;
	}
	for(int i=0; i<s.length(); i++){
		//I convert the digit to boolean, combine with left or right, get the expression boolean, and convert it back to char
		if(i-2>0){
			str = s.substring(0, i-2) + parseBooleanStr(s.substring(i-2, i+1)) + s.substring(i+1);
			cnt += countBooleanExpressions(str, desire, expressions, exp );
		}
		if(i+2<s.length()){
			str = s.substring(0, i) + parseBooleanStr(s.substring(i, i+3)) + s.substring(i+3);
			cnt += countBooleanExpressions(str, desire, expressions, exp );
		}
	}
	return cnt;
}

private char parseBooleanStr(String s){
	if(s.length()>3)
		return false;
	boolean first;
	boolean result;
	boolean second;
	if(s.charAt(1) == '1')
		second = true;
	else 
		second = false;
	switch(s.charAt(0)){
		case '&': result = first & second;break;
		case '|': result = first | second;break;
		case '^': result = first ^ second;break;
		default: System.out.println("illegal operator");
	}
	
	return (result)?'1':'0';
}