import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ReservationGenerator {

    private static String[] arrayOfNames = {"Derin","Ali","Ergem","Fikret","Zana","Ela","Birce","Ceylan","Selin","Timur","Engin","Alara","Berra","Okan", "Mert","Serdar", "Aylin", "Lara", "Can", "Aslan","Kaya","Eda"};
    private static ArrayList<String> custNames = new ArrayList<String>( Arrays.asList( arrayOfNames ));

    private static String[] arrayOfNumbers = {"(511) 617 34 32","(521) 762 33 32","(541) 892 33 32","(531) 542 33 32","(598) 394 33 32","(543) 922 33 32","(531) 977 33 32","(504) 872 33 32","(530) 776 33 32","(503) 542 22 32","(532) 544 33 32"};
    private static ArrayList<String> custNumbers = new ArrayList<String>( Arrays.asList( arrayOfNumbers ));

    private static int currentYear = LocalDate.now().getYear();
    
    /**
     * Takes the month and start and end date as parameters, and returns an ArrayList of random LocalDateTime
     * object representing random reservations between the given dates for the month. Reservations will be between
     * 18:00 and 22:00.
     * @param num (how many reservations to generate)
     * @param month (generates date for the given month)
     * @param startDate (the day of the month to start. For example, generate reservations starting from the 15th)
     * @param endDate (the day of the month to end. For example, generate reservations ending on the 20th)
     * @return ArrayList<LocalDateTime> containing reservation dates/times.
     */
    public static ArrayList<LocalDateTime> getRandomReservationList( int num, String month, int startDate, int endDate ){

        Month resMonth = Month.valueOf(month);
        int date;
        int hour;
        int minute;
        LocalDateTime dateTime;

        ArrayList<LocalDateTime> randomDates = new ArrayList<LocalDateTime>();
        
        Random rand = new Random();
        
        for(int i = 0; i < num; i++) {    
            date = rand.nextInt( endDate - startDate ) + startDate; 
            hour = rand.nextInt(4) + 18;
            minute = rand.nextInt(2);
            minute = minute == 1 ? 30 : 0;
            dateTime = LocalDateTime.of(currentYear, resMonth, date, hour, minute);
            randomDates.add( dateTime );
        }
        return randomDates;
    }
    /**
     * Returns an ArrayList of random String names of the given length.
     * @param num: how many nanes in the list.
     * @return ArrayList of names.
     */
    public static ArrayList<String> getRandomNameList( int num ){
        ArrayList<String> randomNames = new ArrayList<String>();
        int randInd;
        Random rand = new Random();
        int nameCount = 0; 
        if( custNames.size() < num ) {
            num = custNames.size();
        }
        while (  nameCount < num ){    
            randInd = rand.nextInt( custNames.size() );
            //if name not already added to list
            if( !randomNames.contains( custNames.get(randInd) ) ){
                randomNames.add( custNames.get(randInd) );
                nameCount++;
            }
        }
        return randomNames;
    }
    /**
     * Returns an ArrayList of random String phone numbers of the given length.
     * @param num: how many phone numbers in the list.
     * @return ArrayList of String phone numbers.
     */
    public static ArrayList<String> getRandomNumberList( int num ){
        ArrayList<String> randomNumber = new ArrayList<String>();
        int randInd;
        Random rand = new Random();
        int numCount = 0; 
        if( custNumbers.size() < num ) {
            num = custNumbers.size();
        }
        while (  numCount < num ){    
            randInd = rand.nextInt( custNumbers.size() );
            //if name not already added  to list
            if( !randomNumber.contains( custNumbers.get(randInd) ) ){
                randomNumber.add( custNumbers.get(randInd) );
                numCount++;
            }
        }
        return randomNumber;
    }
}
