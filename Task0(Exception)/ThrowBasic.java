

public class ThrowBasic {
    static void checkAge(int age){
        if(age<18){
            throw new IllegalArgumentException("Age must be graterthan 18"); //runtime excepion that's why throws is not used
        }
    }
    public static void main(String[] args) {
            
        try{
            checkAge(17);
        }
        catch(IllegalArgumentException e){
            e.printStackTrace();
        }
        String k = "kalala";
        String d="5654";
        System.out.println((k+d).equals("kalala5654"));
    }
}
