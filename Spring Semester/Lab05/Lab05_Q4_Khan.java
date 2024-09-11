import java.util.Scanner;
import java.util.Random;

public class Lab05_Q4_Khan 
{
    public static void main(String[] args) 
    {
        //Constants
        final int NO_OF_DIGITS = 3;

        //Variables
        int digit, actualNo, guessedNo, noOfGuess, placeCount, digitCount;
        String num1, num2;

        Random random = new Random();

        //Generates random number
        actualNo = 0;
        for(int i = 1; i <= NO_OF_DIGITS; i++)
        {
            digit = random.nextInt(10);

            if(i == 1 && digit == 0)
            {
                do
                {
                    digit = random.nextInt(10);
                }
                while(digit == 0);
            }

            actualNo = actualNo * 10 + digit;
        }

        Scanner in = new Scanner(System.in);
        noOfGuess = 0;
        //Repeats until both numbers match
        do
        {
            System.out.print("Your guess : ");
            guessedNo = in.nextInt();

            //Checks if the number is three digits or not
            int noOfDigits = 0;
            int num = guessedNo;
            do 
            {
                num /= 10;
                noOfDigits++;
            }
            while(num != 0);

            if(noOfDigits != NO_OF_DIGITS)
            {
                System.out.println("Enter a " + NO_OF_DIGITS + " digit number!");
            }
            else
            {
                num1 = "" + actualNo;
                num2 = "" + guessedNo;
                placeCount = 0;
                digitCount = 0;

                //Checks for digit count
                for(int i = 0; i < NO_OF_DIGITS; i++)
                {
                    if(num2.contains("" + num1.charAt(i)))
                    {
                        digitCount++;
                    }
                }

                //Checks for placement count
                for(int j = 0; j < NO_OF_DIGITS; j++)
                {
                    if(num1.charAt(j) == num2.charAt(j))
                    {
                        placeCount++;
                    }
                }

                System.out.println("Correct digits:\t" + digitCount + " Correct Place:\t" + placeCount);
                noOfGuess++;
            }
        }
        while(actualNo != guessedNo);

        //Output no of guesses
        System.out.println("Correctly guessed in " + noOfGuess + " tries");

        in.close();
    }    
}
