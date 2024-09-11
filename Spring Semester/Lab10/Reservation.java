import java.time.LocalDateTime;

public class Reservation 
{
    //Instance variables
    private LocalDateTime dateTime;
    private Customer customer;

    //Constructor method
    public Reservation(String name, String number, LocalDateTime dateTime)
    {
        setCustomer(name, number);
        setDateTime(dateTime);
    }

    //Setter method for customer
    public void setCustomer(String name, String number)
    {
        this.customer = new Customer(name, number);
    }

    //Setter method for dateTime
    public void setDateTime(LocalDateTime dateTime)
    {
        this.dateTime = dateTime;
    }
    
    //Getter method for customer
    public Customer getCustomer()
    {
        return this.customer;
    }

    //Getter method for dateTime
    public LocalDateTime getLocalDateTime()
    {
        return this.dateTime;
    }

    //toString Implementation
    public String toString()
    {
        return customer.toString() + ": " + dateTime.getDayOfMonth() + " " + dateTime.getMonth() + " " + dateTime.getHour() + ":" + String.format("%02d", dateTime.getMinute());
    }
}
