class InvalidAgeException extends Exception{
    InvalidAgeException(String msg){
        super(msg);
    }
}
public class CustomException{
    static void checkAge (int age) throws InvalidAgeException{
        if(age<18){
            throw new InvalidAgeException("Age must be graterthan 18");
        }
        else{
            System.out.println("Correct Age");
        }
    }
    public static void main(String[] args) throws InvalidAgeException{
        checkAge(18);
    }
}

