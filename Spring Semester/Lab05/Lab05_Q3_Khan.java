import java.util.Scanner;

public class Lab05_Q3_Khan 
{
    public static void main(String[] args)
    {
        //Variables
        String sequence, encodedSequence;
        char ch;
        int count;

        //Takes nucleic acid sequence
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a nucleic acid sequence: ");
        sequence = in.next();
        in.close();

        encodedSequence = "";
        do
        {
            count = 0;
            ch = sequence.charAt(0);

            //Counts each nucleic acid component
            for(int j = 0; j < sequence.length(); j++)
            {
                if(ch == sequence.charAt(j))
                {
                    count++;
                }
            }

            //Adds in encoded sequence
            encodedSequence += ch + "" + count;
            //Removes that sequence from actual sequence to avoid repeatition
            sequence = sequence.replaceFirst(sequence.substring(0, count), "");
        }
        while(!sequence.isEmpty());

        //Prints encoded sequence
        System.out.println("Encoded Sequence: " + encodedSequence);
    }
}
