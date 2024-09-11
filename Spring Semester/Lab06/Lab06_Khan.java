import java.util.Scanner;

public class Lab06_Khan 
{
    /**
     * Checks if word contains only alphabets and returns false if it spots a single non0 alphabetic character
     * @param word which we are checking
     * @return boolean which shows if word contains other characters
     */
    public static boolean isAlphaWord(String word) 
    {
        for(int i = 0; i < word.length(); i++)
        {
            if(!Character.isLetter(word.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Encodes given character according to the guide (1 for B, F, V and P; 2 for C, G, J, K, Q, S, X, Z; 3 for D and T; 4 for L; 5 for M and N; 6 for R; skip vowels A, E, I, O, U, H, W, Y) 
     * @param c given character
     * @return encoded code for char (-1 for characters that are to be skipped)
     */
    public static int getCode(char c) 
    {
        char upperCaseChar = Character.toUpperCase(c);

        if ("BFVP".indexOf(upperCaseChar) != -1) 
            return 1;
        if ("CGJKQSXZ".indexOf(upperCaseChar) != -1) 
            return 2;
        if ("DT".indexOf(upperCaseChar) != -1) 
            return 3;
        if (upperCaseChar == 'L') 
            return 4;
        if ("MN".indexOf(upperCaseChar) != -1) 
            return 5;
        if (upperCaseChar == 'R')
            return 6;
        
        return -1;
    }

    /**
     * Creates encoded string by taking encoded form of each character of word and add the characters with -1 code as it as
     * @param word
     * @return encoded string (minus repeatitions and skip letters)
     */
    public static String buildCode(String word) 
    {
        String code = "" + word.toUpperCase().charAt(0);

        for (int i = 1; i < word.length(); i++) 
        {
            if (getCode(word.charAt(i)) != -1) 
            {
                code += getCode(word.charAt(i));
            } 
            else 
            {
                code += word.charAt(i);
            }
        }
        return code;
    }

    /**
     * Removes adjacent characters 
     * @param word with repetition
     * @return string without repetitions
     */
    public static String removeAdjacentDuplicates(String word) 
    {
        if (word.isEmpty()) 
        {
            return word;
        }
    
        String result = String.valueOf(word.charAt(0)); 
    
        for (int i = 1; i < word.length(); i++) 
        {
            char currentChar = word.charAt(i);
            char previousChar = word.charAt(i - 1);
    
            if (currentChar != previousChar) 
            {
                result += currentChar;
            }
        }
        return result;
    }
    
    /**
     * Removes the specified characters from a word by taking a string of chars to be removed and checking each charcter using indexOf method that checks if the character is one of the letters to be removed
     * If its not in the string of chars to be removed then it is left as it as
     * @param word string from which characters are to be removed
     * @param letters string of charcters to be removed
     * @return string after removal of characters 
     */
    public static String removeLetters(String word, String letters) 
    {
        if (word.isEmpty()) 
        {
            return word;
        }
    
        String result = "" + word.charAt(0);
        for (int i = 1; i < word.length(); i++) 
        {
            char c = word.toUpperCase().charAt(i);
            if (letters.indexOf(c) == -1) 
            {
                result += c;
            }
        }
        return result;
    }

    /**
     * Returns encoded string after checking if its length is less than 4 or not; if its greater than or equal to 4 then it prints as it as
     * if its less than 4 then we add zeros until length of code is 4
     * @param code encoded string
     * @return modified encoded string
     */
    public static String padCode(String code) 
    {
        if (code.length() < 4) 
        {
            // Pad zeros to the end of the code
            while (code.length() < 4) 
            {
                code += '0';
            }
        } 
        else if (code.length() > 4) 
        {
            // Truncate the code to the first 4 characters
            code = code.substring(0, 4);
        }
        return code;
    }
    /**
     * Returns the final encoded string
     * it first calls isAlphaWord and check if words only contain alphabets, if its not true then it returns empty string
     * Calls buildCode method to encode specified letter into numbers
     * Calls removeAdjacentCharacters to remove repetition
     * Calls removeLetter to remove specified letters
     * Calls padCode to check if encoded string is less than 4 characters or not
     * Returns the final product
     * @param word to be encoded
     * @return encoded string 
     */
    public static String getSoundex(String word) 
    {
        if (!isAlphaWord(word)) 
        {
            return "";
        }

        String code = buildCode(word);
        code = removeAdjacentDuplicates(code);
        code = removeLetters(code, "AEIOUHWY");
        code = padCode(code);
        return code;
    }

    /**
     * Main method where program runs
     * @param args
     */
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        boolean condition = false;

        //Repeats until user enters "exit"
        while(!condition)
        {
            System.out.print("Enter a word: ");
            String word = in.nextLine();
    
            String soundex = getSoundex(word);
            //If its empty then it means that it has a number or special characters
            if (!soundex.isEmpty()) 
            {
                System.out.println("Soundex encoding: " + soundex);
                if(word.equals("exit"))
                    condition = true;
            } 
            else 
            {
                System.out.println("Error: Word contains non-alphabetic characters.");
            }
        }
        System.out.println("Good bye!");
        in.close();
    }
}
