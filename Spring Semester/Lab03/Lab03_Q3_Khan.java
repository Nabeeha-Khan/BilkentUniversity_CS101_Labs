import java.util.Scanner;

public class Lab03_Q3_Khan 
{
    public static void main(String[] args) 
    {
        //Variables
        String string, nLastChar, firstChar;
        int n;
        char lastChar;

        //Take input
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        string = in.next();
        System.out.print("Enter an integer value between 1 and " + string.length() +": ");

        //Check if the number is an integer
        if(in.hasNextInt())
        {
            n = in.nextInt();

            //Check if number is within bound
            if(n < 1 || n > string.length())
            {
                System.out.println("Error - value must be between 1 and " + string.length());
            }
            
            else
            {
                firstChar = string.substring(0, n);
                lastChar = string.charAt(string.length() - 1);
        
                //Check if the last char is a letter
                if(Character.isLetter(lastChar))
                {
                    nLastChar = string.substring(string.length() - n);
                }

                else
                {
                    nLastChar = string.substring(string.length() - n - 1, string.length() - 1);
                }

                //Check if the first and nth last char are same
                if(firstChar.equals(nLastChar))
                {
                    System.out.println("First and last " + n + " characters are the same");
                }

                else
                {
                    System.out.println("First and last " + n + " characters are not the same");
                }
            }
        }

        else
        {
            in.next();
            System.out.println("Error - value must be an integer");
        }

        in.close();
    }    
}
