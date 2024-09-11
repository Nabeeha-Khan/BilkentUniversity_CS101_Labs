import java.util.Scanner;

public class Lab02_Q3_Khan 
{
    public static void main(String[] args) 
    {
        //Constants
        final double PAL = 1.4;  //Physical Activity Level
        final double PERCENT_OF_CARB_CALORIES = 0.45;
        final double PERCENT_OF_PROTEIN_CALORIES = 0.25;
        final double PERCENT_OF_FAT_CALORIES = 0.30;
        final int CALORIES_PER_GRAM_OF_FAT = 9;
        final int CALORIES_PER_GRAM_OF_PROTEIN = 4;
        final int CALORIES_PER_GRAM_OF_CARB = 4;

        //Variables
        double  weight, height, age, bmr, calories, carbCalories, proteinCalories, fatCalories, gramCarbs, gramProteins, gramFat;

        //Input weight, height and age
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your weight(kg), height(cm) and age: ");
        weight = in.nextDouble();
        height = in.nextDouble();
        age = in.nextDouble();
        in.close();

        //Calculations
        bmr = 10 * weight + 6.25 * height - 5 * age - 161;  //Basal metabolic rate

        calories = bmr * PAL;

        carbCalories = calories * PERCENT_OF_CARB_CALORIES;
        gramCarbs = carbCalories / CALORIES_PER_GRAM_OF_CARB;

        proteinCalories = calories * PERCENT_OF_PROTEIN_CALORIES;
        gramProteins = proteinCalories / CALORIES_PER_GRAM_OF_PROTEIN;

        fatCalories = calories * PERCENT_OF_FAT_CALORIES;
        gramFat = fatCalories / CALORIES_PER_GRAM_OF_FAT;

        //Output result
        System.out.printf("Calories Required:  \t %.2f \r\n" , calories);
        System.out.printf("\tGRAMS PROTEIN: \t %.2f \r\n" , gramProteins);
        System.out.printf("\tGRAMS FAT: \t %.2f \r\n" , gramFat);
        System.out.printf("\tGRAMS CARBS: \t %.2f \r\n" , gramCarbs);
    }   
}
