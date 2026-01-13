
import java.util.ArrayList;
import java.util.List;

interface Calculator{
    int add(int a,int b);
    // int mul(int a,int b);
}
public class Lambda {
    public static void main(String[] args) {
        Calculator x=(a,b)->a+b;

        System.out.println(x.add(10,9));
        List<String> list=new ArrayList<>();
        list.add("apple");
        list.add("orange");
        list.add("pineapple");
        list.add("watermelon");
        list.forEach(f->System.out.println(f));
        //for(String s:list){System.out.println(s);}
    }
}
