import java.util.Scanner;

public class FitnessApp 
{
    public static void main(String[] args) 
    {
        String birthDate;
        char gender;
        double height, weight, waist, hips, restingHeartRate;
        int choice;

        Scanner in = new Scanner(System.in);

        System.out.print("Enter birthdate (YYYY-MM-DD): ");
        birthDate = in.next();

        System.out.print("Enter gender (f)emale/(m)ale: ");
        gender = in.next().charAt(0);

        System.out.print("Enter height(m) weight(kg): ");
        height = in.nextDouble();
        weight = in.nextDouble();

        System.out.print("Enter waist and hip measurements (cm): ");
        waist = in.nextDouble();
        hips = in.nextDouble();

        System.out.print("Enter resting heart rate: ");
        restingHeartRate = in.nextDouble();

        FitnessAssessment assessment = new FitnessAssessment(birthDate, height, weight, restingHeartRate, waist, hips, gender);

        do 
        {
            menu();
            System.out.print("Enter choice: ");
            choice = in.nextInt();
            System.out.println();

            if(choice == 1)
                System.out.println("Target Heart Rate: " + assessment.calculateTargetHeartRate());

            else if(choice == 2)
                System.out.println("Waist/Hip Ratio: " + assessment.calculateWaistHipRatio());

            else if(choice == 3)
                System.out.println("Your BMI is: " + assessment.calculateBMI() + " Category: " + assessment.findBMICategory());

            else if(choice == 4)
                System.out.println("Your fitness level is: " + assessment.determineFitnessLevel());
        }
        while(choice != 5);
        in.close();
    }

    private static void menu()
    {
        System.out.println("--------------MENU--------------");
        System.out.println("1 - Calculate Target Heart Rate");
        System.out.println("2 - Calculate Waist/Hip Ratio");
        System.out.println("3 - Body Mass Index");
        System.out.println("4 - Display Fitness Level");
        System.out.println("5 - Quit");
    }

}
