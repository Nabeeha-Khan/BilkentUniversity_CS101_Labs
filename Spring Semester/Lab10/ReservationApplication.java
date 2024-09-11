import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

public class ReservationApplication
{
    //Global Variables
    private static final int CURRENT_YEAR = 2024;
    private static final Month CURRENT_MONTH = Month.valueOf("MAY");

    public static void main(String[] args) 
    {
        ArrayList<Reservation> reservations = ReservationGenerator.getRandomReservationList(10, "MAY", 1, 30);

        Scanner in = new Scanner(System.in);
        int choice ;
        do
        {
            //Options
            System.out.println("\nMenu:");
            System.out.println("1. Search reservations by date");
            System.out.println("2. Cancel reservation");
            System.out.println("3. Display all reservations");
            System.out.println("4. Sort Reservations");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();
            in.nextLine(); 

            //Searches for reservation based on date
            if (choice == 1) 
            {
                System.out.print("Enter date (1-30): ");
                int date = in.nextInt();
                ArrayList<Integer> indexes = findReservations(date, reservations);

                if(indexes.size() == 0)
                    System.out.println("No reservation found.....");
                else
                {
                    System.out.println("Reservation on " + CURRENT_MONTH + " " + date);
                    printReservations(indexes, reservations);   
                } 
            } 
            //Cancels reservation
            else if (choice == 2) 
            {
                System.out.print("Enter customer name: ");
                String name = in.nextLine();
                System.out.print("Enter customer phone number: ");
                String phoneNumber = in.nextLine();

                boolean canceled = cancelReservation(name, phoneNumber, reservations);

                if (canceled)
                    System.out.println("Reservation canceled successfully.");
                else
                    System.out.println("Reservation not found.");
            } 
            //Prints all reservations
            else if (choice == 3) 
            {
                printReservations(null, reservations);
            } 
            //Sorts reservations
            else if(choice == 4)
            {
                bubbleSort(reservations);
            }
            //Exits
            else if (choice == 5) 
            {
                System.out.println();
            } 
            //Display error message if invalid choice is added
            else 
            {
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
        while(choice != 5);
        in.close();
    }

    //Private method that checks if a dateTime is between two dateTime objects
    private static boolean isBetween(LocalDateTime check, LocalDateTime start, LocalDateTime end)
    {
        return (check.compareTo(start) >= 0) && (check.compareTo(end) <= 0);
    }

    //Returns an ArrayList of indexes for all reservation on that day
    private static ArrayList<Integer> findReservations(int date, ArrayList<Reservation> reservations) 
    {
        ArrayList<Integer> indexes = new ArrayList<>();
        LocalDateTime startDateTime = LocalDateTime.of(CURRENT_YEAR, CURRENT_MONTH, date, 0, 0);
        LocalDateTime endDateTime = LocalDateTime.of(CURRENT_YEAR, CURRENT_MONTH, date, 23, 59);
        for (int i = 0; i < reservations.size(); i++) 
        {
            if (isBetween(reservations.get(i).getLocalDateTime(), startDateTime, endDateTime)) 
            {
                indexes.add(i);
            }
        }
        return indexes;
    }
    
    //Method to removes a reservation which returns a boolean to tell if it were successful
    private static boolean cancelReservation(String name, String phoneNumber, ArrayList<Reservation> reservations) {
        for (int i = 0; i < reservations.size(); i++) 
        {
            if (reservations.get(i).getCustomer().getName().equals(name) && reservations.get(i).getCustomer().getNumber().equals(phoneNumber)) 
            {
                reservations.remove(i);
                return true;
            }
        }
        return false;
    }

    //Prints all reservations
    private static void printReservations(ArrayList<Integer> indexes, ArrayList<Reservation> reservations) 
    {
        //For displaying all reservations
        if (indexes == null) 
        {
            for (Reservation reservation: reservations) 
            {
                System.out.println(reservation.toString());
            }
        }
        //For displaying required reservations 
        else 
        {
            for (int index : indexes) 
            {
                System.out.println(reservations.get(index).toString());
            }
        }
    }

    //Sorts the ArrayList of reservations using bubble sort
    private static void bubbleSort(ArrayList<Reservation> reservations)
    {
        int n = reservations.size();

        for (int i = 0; i < n-1; i++) 
        {
            for (int j = 0; j < n-i-1; j++) 
            {
                if (reservations.get(j).getLocalDateTime().compareTo(reservations.get(j+1).getLocalDateTime()) > 0) 
                {
                    // Swap arr[j] and arr[j+1]
                    Reservation temp = reservations.get(j);
                    reservations.set(j, reservations.get(j+1));
                    reservations.set(j+1, temp);
                }
            }
        }
    }
}






