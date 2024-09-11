import java.time.LocalDate;
import java.time.Period;

public class FitnessAssessment
{
    //Instance variables
    private LocalDate birthDate;
    private double height, weight, restingHeartRate, waist, hips;
    private char gender;

    //Constructor method
    public FitnessAssessment(String birthDate, double height, double weight, double restingHeartRate, double waist, double hips, char gender)
    {
        this.height = height;
        this.weight = weight;
        this.restingHeartRate = restingHeartRate;
        this.waist = waist;
        this.hips = hips;
        this.gender = gender;
        setBirthDate(birthDate);
    }

    //Setter method for setting birth date
    public void setBirthDate(String birthDate)
    {
        this.birthDate = LocalDate.parse(birthDate);
    }

    //Getter method for birth date
    public LocalDate getBirthDate()
    {
        return this.birthDate;
    }

    //Getter method for height
    public double getHeight()
    {
        return this.height;
    }

    //Getter method for weight
    public double getWeight()
    {
        return this.weight;
    }

    //Getter method for resting heart rate
    public double getRestingHeartRate()
    {
        return this.restingHeartRate;
    }

    //Getter method for waist
    public double getWaist()
    {
        return this.waist;
    }

    //Getter method for hips
    public double getHips()
    {
        return this.hips;
    }

    //Getter method for gender
    public char getGender()
    {
        return this.gender;
    }

    //Method that calculates and return target heart rate
    public double calculateTargetHeartRate()
    {
        return round(0.85 * calculateMaxHeartRate());
    }

    //Method that calculates and return maximum heart rate
    public double calculateMaxHeartRate()
    {
        return 220 - calculateAge(); 
    }

    //Method that calculates and return waist hip ratio
    public double calculateWaistHipRatio()
    {
        return round(this.waist / this.hips);
    }

    //Method that calculates and return bmi
    public double calculateBMI()
    {
        return round(this.weight / Math.pow(this.height, 2));
    }

    //Method that finds and returns bmi category as string
    public String findBMICategory()
    {
        double bmi = calculateBMI();

        if(bmi < 20)
            return "Underweight";

        else if (bmi >= 20 && bmi < 25)
            return "Normal";

        else if(bmi >= 25 && bmi < 30)  
            return "Overweight";

        else
            return "Obese";
    }

    //Method that calculate and returns age
    public int calculateAge()
    {
        LocalDate localDate = LocalDate.now();
        return Period.between(this.birthDate, localDate).getYears();
    }

    //Method that determines and returns fitness level as string 
    public String determineFitnessLevel()
    {
        int points = 0;
        double bmi = calculateBMI();
        double waistHipRatio = calculateWaistHipRatio();

        //Calculate points 
        if(bmi >= 20 && bmi <= 24)
            points++;

        if(this.restingHeartRate < 70)
            points++;

        if(this.gender == 'm')
        {
            if(waistHipRatio < 1)
                points++;
        }
        else
        {
            if(waistHipRatio < 0.9)
                points++;
        }

        //Determining fitness level acc to points
        if(points == 0)
            return "POOR";

        else if(points == 1)
            return "AVERAGE";

        else if(points == 2)
            return "GOOD";

        else
            return "EXCELLENT";
    }

    //Method to round off values to one decimal place
    private double round(double value) 
    {
        double roundedNumber = value * 100 + 5; //Multiplying by 100 to get two decimal places before decimal and adding 5 to see if first decimal place changes
        roundedNumber = (int)(roundedNumber / 10); //Truncating second decimal place
        return roundedNumber / 10; //Returning rounded number to one decimal place
    }
}