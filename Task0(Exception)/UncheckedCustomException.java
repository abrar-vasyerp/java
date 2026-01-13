class NegativeNumberException extends RuntimeException{
    NegativeNumberException(String msg){
        super(msg);
    }
}
public class UncheckedCustomException {
    static void checkAge(int age){
        if(age<0){
            throw new NegativeNumberException("Age must be in positive");

        }
    }
    public static void main(String[] args){
        checkAge(-5);
    }
    
}
