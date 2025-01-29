package strings;

public class N01_Anagram {
//    Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//
//    An blind75.Strings.Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

    //    Input: s = "anagram", t = "nagaram"
//    Output: true
    public static void main(String[] args) {
        System.out.println(checkAnagramPrac("anagram", "nagaram"));
    }

    private static boolean checkAnagramPrac(String s, String t){
        int a=s.length();
        int b=t.length();

        if(a!=b) return false;

        int[] arr=new int[26];

        for(int i=0;i<a;i++){
            int ch=s.charAt(i);
            int index=ch-'a';
            arr[index]++;
        }
        for(int i=0;i<a;i++){
            int ch=t.charAt(i);
            int index=ch-'a';
            arr[index]--;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                return false;
            }
        }

        return true;
    }

























    private static boolean checkAnagram(String s, String t) {
        int a=s.length();
        int b=t.length();

        if(a!=b){
            return false;
        }

        int[] arr=new int[26];

        for(int i=0;i<a;i++){
            char ch=s.charAt(i);
            int index=ch-'a';
            arr[index]++;
        }
        for(int i=0;i<b;i++){
            char ch=t.charAt(i);
            int index=ch-'a';
            arr[index]--;
        }
        for(int i:arr){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
