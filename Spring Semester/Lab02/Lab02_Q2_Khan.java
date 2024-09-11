import java.util.Scanner;

public class Lab02_Q2_Khan 
{
    public static void main(String[] args) 
    {
        //Variables
        String phoneNumber, countryCode, areaCode, number;

        //Input phone number
        Scanner in = new Scanner(System.in);
        System.out.print("Enter phone number: ");
        phoneNumber = in.nextLine();
        in.close();

        //Find country code, area code and phone number
        countryCode = phoneNumber.substring(phoneNumber.indexOf("(") + 1, phoneNumber.indexOf(")"));
        countryCode = countryCode.trim();

        areaCode = phoneNumber.substring(phoneNumber.indexOf(")") + 1, phoneNumber.indexOf("-"));
        areaCode = areaCode.trim();

        number = phoneNumber.substring(phoneNumber.indexOf("-") + 1);
        number = number.trim();

        //Output result
        System.out.println("Country code: " + countryCode);
        System.out.println("City / Area code: " + areaCode);
        System.out.println("Phone number: " + number);
    }    
}
