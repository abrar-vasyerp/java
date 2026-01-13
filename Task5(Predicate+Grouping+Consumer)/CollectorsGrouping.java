import java.util.*;
import java.util.stream.Collectors;

class CollectorsGrouping{
    public static void main(String[] args) {
        Map<String,List<Integer>> result=List.of(1,2,3,4,5,6).stream().collect(Collectors.groupingBy(n-> n%2 == 1?"ODD":"Even"));
        for(String str:result.keySet()){
            System.out.print(str+":");
            System.out.println(result.get(str));
        }
    }
}