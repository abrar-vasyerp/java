import java.util.*;
public class LCS {
    //Longest Substring Without Repeating Characters

    public static void main(String[] args) {
        String longestString="";
        Set<Character> set=new HashSet<>();
        String str="abrar";

        String temp="";
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);

            if(set.contains(ch)){
                if(temp.length()>longestString.length()){
                    longestString=temp;
                    temp="";
                    set.clear();
                }
                
            }
                set.add(ch);
                temp+=ch;
                
        }
        System.out.println(longestString);
    }
    
}
