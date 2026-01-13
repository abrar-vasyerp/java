
import java.util.*;

public class Student {
    int id;
    String name;
    int age;

    public Student(int id,String name,int age) {
        this.id=id;
        this.name=name;
        this.age=age;
    }
    public static void main(String[] args) {
        List<Student> list=new ArrayList<>();
        list.add(new Student(1,"Abrar",20));
        list.add(new Student(2,"Dhruv",25));
        list.add(new Student(3,"Falak",23));
        list.add(new Student(4,"Parth",30));
        list.add(new Student(5,"Jay",40));

        // Collections.sort(list,new Comparator<Student>(){
            
        //     public int compare(Student s1,Student s2){
        //         return s2.age-s1.age;
        //     }
        // });
        Collections.sort(list,(s1,s2)->s1.age-s2.age);
        // Collections.sort(list,(s1,s2)->s1.name.compareTo(s2.name));
        // for(Student s:list){
        //     System.out.println(s.id+" "+s.name+" "+s.age);
        // }
        List<Student> listNew= Collections.EMPTY_LIST;
            // .forEach(s->System.out.println(s.name));

        
    }
    
}
