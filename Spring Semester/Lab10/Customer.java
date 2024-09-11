public class Customer 
{
    //Instance variables
    private String name, number;

    //Constructor
    public Customer(String name, String number)
    {
        setName(name);
        setNumber(number);
    }

    //Setter method for name
    public void setName(String name)
    {
        this.name = name;
    }

    //Setter number for number
    public void setNumber(String number)
    {
        this.number = number; 
    }

    //Getter method for name
    public String getName()
    {
        return this.name;
    }

    //Getter method for number
    public String getNumber()
    {
        return this.number;
    }

    //toString implementation
    public String toString()
    {
        return this.name + " " + this.number;
    }
}

