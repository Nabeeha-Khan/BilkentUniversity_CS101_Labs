import java.util.Scanner;

public class Lab02_Q1_Khan 
{
    public static void main(String[] args) 
    {
        //Constants 
        final double MULTIPLE_OF_EARTHS_WEIGTH_FOR_MARS = 0.38;
        final double MULTIPLE_OF_EARTHS_WEIGTH_FOR_VENUS = 0.91; 
        final double MULTIPLE_OF_EARTHS_WEIGTH_FOR_MOON = 0.166;
        final double MULTIPLE_OF_EARTHS_WEIGTH_FOR_NEPTUNE = 1.19;  

        //Variables 
        double firstEarthlingWeight, firstEarthlingWeightOnMars, firstEarthlingWeightOnVenus, firstEarthlingWeightOnMoon, firstEarthlingWeightOnNeptune;
        double secondEarthlingWeight, secondEarthlingWeightOnMars, secondEarthlingWeightOnVenus, secondEarthlingWeightOnMoon, secondEarthlingWeightOnNeptune;

        //Input weight of earthlings
        Scanner in = new Scanner(System.in);
        System.out.print("Enter weight of first earthling(kg): ");
        firstEarthlingWeight = in.nextDouble();
        System.out.print("Enter weight of second earthling(kg): ");
        secondEarthlingWeight = in.nextDouble();
        in.close();
        System.out.println();

        //Calculations
        firstEarthlingWeightOnMars = firstEarthlingWeight * MULTIPLE_OF_EARTHS_WEIGTH_FOR_MARS;
        firstEarthlingWeightOnMoon = firstEarthlingWeight * MULTIPLE_OF_EARTHS_WEIGTH_FOR_MOON;
        firstEarthlingWeightOnVenus = firstEarthlingWeight * MULTIPLE_OF_EARTHS_WEIGTH_FOR_VENUS;
        firstEarthlingWeightOnNeptune = firstEarthlingWeight * MULTIPLE_OF_EARTHS_WEIGTH_FOR_NEPTUNE;

        secondEarthlingWeightOnMars = secondEarthlingWeight * MULTIPLE_OF_EARTHS_WEIGTH_FOR_MARS;
        secondEarthlingWeightOnMoon = secondEarthlingWeight * MULTIPLE_OF_EARTHS_WEIGTH_FOR_MOON;
        secondEarthlingWeightOnVenus = secondEarthlingWeight * MULTIPLE_OF_EARTHS_WEIGTH_FOR_VENUS;
        secondEarthlingWeightOnNeptune = secondEarthlingWeight * MULTIPLE_OF_EARTHS_WEIGTH_FOR_NEPTUNE;

        //Display output
        System.out.println("\t\t\t\t Mars \t Venus \t Moon \t Neptune");
        System.out.printf("EARTHLING ONE( %.1fkg)\t\t %4.1f \t %4.1f \t %4.1f \t %4.1f\r\n", firstEarthlingWeight, firstEarthlingWeightOnMars, firstEarthlingWeightOnVenus, firstEarthlingWeightOnMoon, firstEarthlingWeightOnNeptune);
        System.out.printf("EARTHLING TWO( %.1fkg)\t\t %4.1f \t %4.1f \t %4.1f \t %4.1f\r\n", secondEarthlingWeight, secondEarthlingWeightOnMars, secondEarthlingWeightOnVenus, secondEarthlingWeightOnMoon, secondEarthlingWeightOnNeptune);

    }
}

