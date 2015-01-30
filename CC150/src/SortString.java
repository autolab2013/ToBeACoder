import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by yunong on 1/24/2015.
 */
public class SortString {

    static String[] sortStringArray(String[] array){
        HashMap<HashSet<Character>, ArrayList<String>> map = new HashMap<HashSet<Character>, ArrayList<String>>();
        for(String s: array){
            char[] char_arr = s.toCharArray();
            HashSet<Character> char_set = new HashSet<Character>();
            for(Character c: char_arr){
                char_set.add(c);
            }
            if(!map.keySet().contains(char_set)){
                ArrayList<String> str_list = new ArrayList<String>();
                map.put(char_set, str_list);
            }
            map.get(char_set).add(s);
        }
        int j =0;
        for(HashSet<Character> set: map.keySet()){
            for(String str: map.get(set)){
                array[j] = str;
                j++;
            }
        }
        return array;
    }

    static void tester(){
        String[] str = {"abcd", "bde" ,"aee", "ebb", "acdb", "dbca"};
        for(String s: str) {
            System.out.println(s);
        }

        System.out.println("sorted");
        str = SortString.sortStringArray(str);
        for(String s: str) {
            System.out.println(s);
        }
    }
}
