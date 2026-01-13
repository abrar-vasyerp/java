import java.util.*;
class InvalidAgeException extends RuntimeException{
    InvalidAgeException(String name,int age){
        super("Student name is "+name+"and age is "+age);
    }
}
public class StudentValidator {
    
    static void checkAge(String name,int age){
        if(age<18){
            throw new InvalidAgeException(name,age);
        }
    }
    public static void main(String[] args){
        HashMap<String,Integer> map=new HashMap<>();
        map.put("Abrar",20);
        map.put("Nawaz",24);
        map.put("Parth",15);
        map.put("Owesh",14);

        List<String> list=new ArrayList<>();
        for(String name:map.keySet()){     // for()
            int age=map.get(name);
            try{
                checkAge(name,age);
            }
            catch(InvalidAgeException e){
                list.add(name);
            }
            
        }
        System.out.println("Students who are under age is below :");
        for(String name:list){
            System.out.print(" "+name);
        }
    }


}
