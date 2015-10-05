import java.util.HashSet;

/**
 * Created by nathanlrf on 10/1/15.
 */
public class Solution {
    private HashSet<String> dict;

    public Solution(HashSet<String> set) {
       dict = set;
    }

    //suppose the dictionary is implemented as a hashset
    public boolean canRecover(String input) {
        if(encode(input) != -1) return true;
        for(int i=0; i<input.length(); i++) {
           if(Character.isLowerCase(input.charAt(i))) {
               String next = input.substring(0, i) + Character.toUpperCase(input.charAt(i)) + input.substring(i+1);
               if(canRecover(next)) return true;
           }
        }
        return false;
    }

    private int encode(String input) {
        if(dict.contains(input)) return 1;
        return -1;
    }

//    private String decode(int num) {
//    }
}
