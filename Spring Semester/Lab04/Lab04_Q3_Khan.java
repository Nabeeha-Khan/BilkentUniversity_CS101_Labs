import java.util.Scanner;

public class Lab04_Q3_Khan 
{
    public static void main(String[] args) 
    {
        //Variables
        String word, lowerCaseWord;
        int count;
        boolean isPairWord;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a word: ");
        word = in.next();
        in.close();

        //To ignore case sensitivity
        lowerCaseWord = word.toLowerCase();

        isPairWord = true;  //Test condition
        int i = 0;

        //Takes each char of given word
        while(i < lowerCaseWord.length() && isPairWord)
        {
            count = 0;
            int j = 0;

            //Tests the current char with other chars
            while(j < lowerCaseWord.length())
            {
                if(lowerCaseWord.charAt(i) == lowerCaseWord.charAt(j))
                {
                    count++;
                }
                j++;
            } 
            i++;

            //Checks test condition (i.e. if count is 2 or not)
            if(count != 2)
            {
                isPairWord = false;
            }
        }

        //Output
        if(isPairWord)
        {
            System.out.println(word + " is a pair word!");
        }
        else
        {
            System.out.println(word + " is not a pair word!");
        }
    }
}
