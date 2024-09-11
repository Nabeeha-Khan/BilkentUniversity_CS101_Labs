public class Lab01_Q2 
{
    public static void main(String[] args) 
    {
        //Declaring variables
        double answer1, answer2, answer3;
        double x, y, z;

        //First expression
        x = (23.2 - 7.1 / 2.2) / ((5.1 - 3.7) * (3.4 + 4.2));
        answer1 = x;

        //Second expression
        y = (35.7 * 64.1 - Math.pow(6.0, 3)) / (43 + (5 * 5));
        answer2 = y;

        //Third expression
        z = 2.1 + 8.0;
        z = Math.pow(z, -1.0/3);
        answer3 = z;

        //Printing values
        System.out.println("Answer1 is: " + answer1);
        System.out.println("Answer2 is: " + answer2);
        System.out.println("Answer3 is: " + answer3);
    }    
}
