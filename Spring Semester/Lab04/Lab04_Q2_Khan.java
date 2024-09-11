import java.util.Scanner;

public class Lab04_Q2_Khan 
{
    public static void main(String[] args) 
    {
        //Coefficient of restitution for specified ball types
        final double TENNIS_BALL = 0.7;
        final double BASKETBALL = 0.75;
        final double SUPERBALL = 0.9;
        final double SOFTBALL = 0.3;

        //Variables
        int noOfBounces;
        double height, totalDistance, coefficient;
        String ball;

        Scanner in = new Scanner(System.in);

        System.out.print("Enter Ball Type: ");
        ball = in.nextLine();

        //Checks if the entered ball type is valid and assigns coefficents accordingly
        if(ball.equalsIgnoreCase("Tennis Ball"))
        {
            coefficient = TENNIS_BALL;
        }
        else if(ball.equalsIgnoreCase("Basketball"))
        {
            coefficient = BASKETBALL;
        }
        else if(ball.equalsIgnoreCase("Superball"))
        {
            coefficient = SUPERBALL;
        }
        else if(ball.equalsIgnoreCase("Softball"))
        {
            coefficient = SOFTBALL;
        }
        else
        {
            coefficient = 0;
            System.out.println("Invalid Ball Type - Exiting...");
        } 
        
        //Calculations
        if(coefficient != 0)
        {
            System.out.print("Enter initial height(m): ");
            height = 0;

            //Checks if height is nemeric value
            if(in.hasNextDouble())
            {
                height = in.nextDouble();
            }
            else
            {
                boolean condition = false;

                //Takes height until numeric value is given
                while(!condition)
                {
                    if(in.hasNextDouble())
                    {
                        height = in.nextDouble();
                        condition = true;
                    }
                    else
                    {
                        in.next();
                        System.out.println("Height must be numeric value...");
                        System.out.print("Enter initial height(m): ");
                    }
                }
            }
            
            noOfBounces = 0;
            totalDistance = 0;
            //Repeats until height is less than 10 centimeter or 0.1 meter
            while (height >= 0.1) 
            {
                noOfBounces++;
                totalDistance = totalDistance + height * (1 + coefficient); 
                height = height * coefficient;
            }

            //Output
            System.out.println("Number of bounces: " + noOfBounces);
            System.out.printf("Meters travelled: %.2f", totalDistance);
        }
        in.close();
    }
}