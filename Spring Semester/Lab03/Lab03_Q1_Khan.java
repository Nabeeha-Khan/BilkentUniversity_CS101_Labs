import java.util.Scanner;

public class Lab03_Q1_Khan 
{
    public static void main(String args[])
    {
        //Variables
        int num1, num2, rounded1, rounded2;

        //Taking numbers as input
        Scanner in = new Scanner(System.in);
        System.out.print("Enter 2 numbers: ");
        num1 = in.nextInt();
        num2 = in.nextInt();
        in.close();

        //Applying conditional statements to round off numbers
        //Condtion for first number
        if(num1 % 10 < 5)
        {
            rounded1 = (num1 / 10) * 10;
        }
        else
        {
            rounded1 = ((num1 / 10) + 1) * 10;
        }

        //Condtion for second number

        if(rounded1 % 3 == 0)
        {
            rounded2 = num2;
        }
        else
        {
            if(num2 % 10 < 5)
            {
                rounded2 = (num2 / 10) * 10;
            }
            else
            {
                rounded2 = ((num2 / 10) + 1) * 10;
            }
        }

        //Display result
        System.out.println("The sum of the rounded values of " + num1 + " and " + num2 + ": " + (rounded1 + rounded2));
    }
}
