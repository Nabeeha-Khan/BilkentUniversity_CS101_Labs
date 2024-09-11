import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab07_Q1_Khan 
{
    //Global Variables
    public static final int CURRENT_YEAR = 2024;
    public static final Month CURRENT_MONTH = Month.valueOf("APRIL");

    /**
     * Main method where menu is displayed and operations are performed until user exits
     * @param args
     */
    public static void main(String[] args) 
    {
        //Variables
        int date, choice ;
        String name, phoneNumber;

        //ArrayList
        ArrayList<LocalDateTime> reservations = ReservationGenerator.getRandomReservationList(10, "APRIL", 1, 30);
        ArrayList<String> customerNames = ReservationGenerator.getRandomNameList(10);
        ArrayList<String> customerPhones = ReservationGenerator.getRandomNumberList(10);

        Scanner in = new Scanner(System.in);
        //Repeats until user enters 4
        do
        {
            System.out.println("\nMenu:");
            System.out.println("1. Search reservations by date");
            System.out.println("2. Cancel reservation");
            System.out.println("3. Display all reservations");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();
            in.nextLine(); 

            //Find reservation by date
            if (choice == 1) 
            {
                System.out.print("Enter date (1-30): ");
                date = in.nextInt();

                ArrayList<Integer> indexes = findReservations(date, reservations);
                if(indexes == null)
                    System.out.println("No reservation found.....");
                else
                {
                    System.out.println("Reservation on " + CURRENT_MONTH + " " + date);
                    printReservations(indexes, reservations, customerNames, customerPhones);   
                } 
            } 
            //Cancel reservation
            else if (choice == 2) 
            {
                System.out.print("Enter customer name: ");
                name = in.nextLine();
                System.out.print("Enter customer phone number: ");
                phoneNumber = in.nextLine();

                boolean canceled = cancelReservation(name, phoneNumber, reservations, customerNames, customerPhones);
                if (canceled)
                    System.out.println("Reservation canceled successfully.");
                else
                    System.out.println("Reservation not found.");
            } 
            //Displays all reservations
            else if (choice == 3) 
            {
                printReservations(null, reservations, customerNames, customerPhones);
            } 
            //Exits
            else if (choice == 4) 
            {
                System.out.println("Exiting...");
            }
            //Display error if wrong index is put 
            else 
            {
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
        while(choice != 4);
        in.close();
    }

    /**
     * The method returns true if the check object is between the start and end LocalDateTime and false if not
     * @param check object
     * @param start start time
     * @param end  end time
     * @return boolean true if object between given time and false otherwise
     */
    public static boolean isBetween(LocalDateTime check, LocalDateTime start, LocalDateTime end)
    {
        return (check.compareTo(start) >= 0) && (check.compareTo(end) <= 0);
    }

    /**
     * The method takes an int date and a list of reservations as parameters and returns an ArrayList containing the indexes of the reservations in the list with the given date
     * @param date to check 
     * @param reservations list of all reservations
     * @return ArrayList containing indexes of reservation
     */
    public static ArrayList<Integer> findReservations(int date, ArrayList<LocalDateTime> reservations) 
    {
        ArrayList<Integer> indexes = new ArrayList<>();
        LocalDateTime startDateTime = LocalDateTime.of(CURRENT_YEAR, CURRENT_MONTH, date, 18, 0);
        LocalDateTime endDateTime = LocalDateTime.of(CURRENT_YEAR, CURRENT_MONTH, date, 22, 0);
        for (int i = 0; i < reservations.size(); i++) 
        {
            if (isBetween(reservations.get(i), startDateTime, endDateTime)) 
            {
                indexes.add(i);
            }
        }
        return indexes;
    }
    
    /**
     * The method finds the matching customer (with the same name and phone number) and removes the customer’s name, phone number and reservation date from the list
     * @param name to check
     * @param phoneNumber to check
     * @param reservations list of reservations
     * @param customerNames list of names
     * @param customerPhones list of numbers
     * @return true if match is found and false otherwise
     */
    public static boolean cancelReservation(String name, String phoneNumber, ArrayList<LocalDateTime> reservations, ArrayList<String> customerNames, ArrayList<String> customerPhones) {
        for (int i = 0; i < customerNames.size(); i++) 
        {
            if (customerNames.get(i).equals(name) && customerPhones.get(i).equals(phoneNumber)) 
            {
                reservations.remove(i);
                customerNames.remove(i);
                customerPhones.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * The method displays the reservation information for the customers with the given indexes
     * @param indexes given indexes
     * @param reservations list of reservations
     * @param customerNames list of names
     * @param customerPhones list of numbers
     */
    public static void printReservations(ArrayList<Integer> indexes, ArrayList<LocalDateTime> reservations, ArrayList<String> customerNames, ArrayList<String> customerPhones) 
    {
        if (indexes == null) 
        {
            for (int i = 0; i < reservations.size(); i++) 
            {
                System.out.println("\t\t" + customerNames.get(i) + "\t" + customerPhones.get(i) + "\t" + reservations.get(i).getMonth() + ", " + reservations.get(i).getDayOfMonth() + " " + reservations.get(i).getHour() + ":" + String.format("%02d", reservations.get(i).getMinute()));
            }
        } 
        else 
        {
            for (int index : indexes) 
            {
                System.out.println("\t\t" + customerNames.get(index) + "\t" + customerPhones.get(index) + "\t" + reservations.get(index).getMonth() + ", " + reservations.get(index).getDayOfMonth() + " " + reservations.get(index).getHour() + ":" + String.format("%02d", reservations.get(index).getMinute()));
            }
        }
    }
}




