import java.util.*;
public class GroupAnagram {
    //HashMap<String, List<String>>


    public static void main(String[] args) {
       
        String[] arr={"apple","banana","orange","grapes","pineapple","alepp","bannaa","egnaor", "pplae"};
        Map<String,List<String>> map=new HashMap<>();

        for(String word:arr){
            char[] chars=word.toCharArray();
            Arrays.sort(chars);
            String key=new String(chars);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(word);
            
        }
        System.out.println(map.values());
    }
    
}
