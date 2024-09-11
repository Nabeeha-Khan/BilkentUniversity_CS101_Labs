public class Lab05_Q2_Khan 
{
    public static void main(String[] args) 
    {
        //Constants
        final int MIN_NUMBER = 100;
        final int MAX_NUMBER = 999;
        final int NO_OF_DIGITS = 3;

        //Variables
        int number, digit;
        double sumOfDigits, sumOfNumbers;

        sumOfNumbers = 0;
        //Checks all number from 100-999
        for(int i = MIN_NUMBER; i <= MAX_NUMBER; i++)
        {
            number = i;
            sumOfDigits = 0;

            //Takes each digit and adds its cube into sum of digits
            for(int j = 1; j <= NO_OF_DIGITS; j++)
            {
                digit = number % 10;
                number /= 10;
                sumOfDigits += Math.pow(digit, NO_OF_DIGITS);
            }

            //Checks if no is narcissistic
            if(i == sumOfDigits)
            {
                System.out.println(i + " is a narcissistic number");
                sumOfNumbers += i;
            }
        }

        //Prints sum of narcissistic numbers
        System.out.println("Sum of three-digit narcissistic numbers: " + (int)sumOfNumbers);
    }    
}
