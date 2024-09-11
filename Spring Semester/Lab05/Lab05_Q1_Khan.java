import java.util.Scanner;

public class Lab05_Q1_Khan 
{
    public static void main(String[] args) 
    {
        //Variables
        String string;
        char ch;
        int sum, digit;
        boolean containsNumber;

        //Taking input string
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        string = in.nextLine();
        in.close();

        containsNumber = false;  //Test condition for checking for numeric values

        //Taking each char, checking if numeric and the adding in sum
        sum = 0;
        for (int i = 0; i < string.length(); i++) 
        {
            ch = string.charAt(i);
            if (Character.isDigit(ch)) {
                digit = Character.getNumericValue(ch);
                sum += digit;
                containsNumber = true;
            }
        }
        
        //Prints prompt acc to test condition
        if(containsNumber)
        {
            System.out.println("The sum of the digits is: " + sum);
        }
        else
        {
            System.out.println("No numeric characters exist in the input string");
        }
    }
   
}
