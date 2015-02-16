/** 9.5 Write a method to compute all permutation of a string of unique characters.
 *  
 */
 
public static void StringPerm(String str, String result,int length){
	if(length == result.length()){
		System.out.println(result);
		return;
	}
	for(int i=0;i <str.length();i++){
		StringPerm(str.substring(0,i)+str.substring(i+1), result+str.charAt(i), length);
	}
}