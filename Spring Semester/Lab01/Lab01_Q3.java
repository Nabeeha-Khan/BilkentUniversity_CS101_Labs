public class Lab01_Q3 
{
    public static void main(String[] args) 
    {
        //Constants
        final double AREA_OF_EARTH = 510072000; 
        final double AREA_OF_TURKEY = 783562;   

        //Variables
        double areaOfWater, areaOfLand, areaOfWaterInTurkey, areaOfLandInTurkey, landPercentage, waterPercentage;

        //Calculations
        areaOfLand = AREA_OF_EARTH * 29.2 / 100;   
        areaOfWater  = AREA_OF_EARTH - areaOfLand; 

        areaOfWaterInTurkey = AREA_OF_TURKEY * 1.3/ 100;
        areaOfLandInTurkey = AREA_OF_TURKEY - areaOfWaterInTurkey;

        landPercentage = areaOfLandInTurkey / areaOfLand * 100;
        
        waterPercentage = areaOfWaterInTurkey / areaOfWater * 100;

        //Displaying result
        System.out.println("Earth has " + (int)areaOfLand + " km2 dry land and " + (int)areaOfWater + " km2 water.");
        System.out.println("Turkey has " +  (int)areaOfLandInTurkey + " km2 dry land and " + (int)areaOfWaterInTurkey + " km2 water.");
        System.out.println("Turkey has " + landPercentage + " percent of the Earth's dry land.");
        System.out.println("Turkey has " + waterPercentage + " percent of the Earth's water.");
    }    
}
