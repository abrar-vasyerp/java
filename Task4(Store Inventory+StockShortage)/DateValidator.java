import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import MyException.InvalidDateException;


public class DateValidator {
    private static final DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static LocalDate validateExpiry(String datStr){
        try {
            LocalDate date=LocalDate.parse(datStr,formatter);
            if(date.isBefore(LocalDate.now())){
                throw new InvalidDateException("Can't Add Expired Products...");
            }
            return date;
        } catch (DateTimeParseException e) {
            throw new InvalidDateException("Please provide Correct Date format like this ->yyyy-MM-dd");
        }
        catch (RuntimeException e){
            throw new RuntimeException();
        }
        
    }
}
