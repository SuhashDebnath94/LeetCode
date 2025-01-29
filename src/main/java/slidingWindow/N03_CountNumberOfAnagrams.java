package slidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class N03_CountNumberOfAnagrams {
    public static void main(String[] args) {
        System.out.println(countNumberOfAnagrams("for", "forxxxofrxxdofr"));
    }

    private static int countNumberOfAnagrams(String target, String str) {
        int i=0;
        int j=0;
        int windowLength=target.length();

        int count=0;
        while(j<str.length()){
            if((j-i)+1<windowLength){
                j++;
            }
            else{
                String checkStr=str.substring(i,j+1);
                if (isAnagram(target, checkStr)) {
                    count++;
                }
                i++;
                j++;
            }
        }
        return count;
    }

    private static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

        HashMap<Character, Integer> map=new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
            else {
                map.put(s.charAt(i), 1);
            }
        }

        for(int i=0;i<t.length();i++){
            if(map.containsKey(t.charAt(i)) && map.get(t.charAt(i))>1){
                map.put(t.charAt(i), map.get(t.charAt(i))-1);
            }
            else {
                map.remove(t.charAt(i));
            }
        }

        if(!map.keySet().isEmpty()){
            return false;
        }

        return true;
    }
}
