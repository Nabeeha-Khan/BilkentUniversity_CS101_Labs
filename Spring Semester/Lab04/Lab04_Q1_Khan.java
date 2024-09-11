import java.util.Scanner;

public class Lab04_Q1_Khan
{
    public static void main(String[] args) 
    {
        //Variables
        String string1, string2, test;
        boolean isExit;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter strings (exit to stop): ");
        string1 = in.next();  //First string alphabetically
        string2 = "";   //Second string alphabetically
        test = "";
        isExit = false;   //Test condition

        //Iterates until condtion is true (i.e String is "exit")
        while(!isExit)
        {
            test = in.next();

            //Checks if the test string is not "exit"
            if(!test.equals("exit"))
            {  
                //Checks if the first string is larger than the second string
                if(string1.compareTo(test) > 0)
                {
                    string2 = string1;
                    string1 = test;
                }
                else
                {
                    string2 = test;
                }
            }
            else
            {
                isExit = true;
            }
        }
        in.close();

        //Outputs prompt
        if(!string1.equals(string2) && !string2.isEmpty())
        {
            System.out.println("String that comes second alphabetically: " + string2);
        }
        else
        {
            System.out.println("Not enough input data...");
        }
    }
}