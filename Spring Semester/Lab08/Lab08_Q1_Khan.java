import java.util.Scanner;

public class Lab08_Q1_Khan 
{
    //Global arrays
    public static int[] arrivalTime = {7,5,8,7,9,7,8};
    public static int[] departureTime = {12,7,11,12,10,9,10};
    public static String[] nameOfFriends = {"Ela", "Eren", "Alona", "Jen", "Mark", "Mel", "Ender"};
    public static int[] priorities = {1,1,5,2,2,4,3};

    /**
     * Method that returns the array of average priorities for each hour
     * @param arrival arrival time
     * @param departure departure time
     * @return array of average priorities
     */
    public static double[] friendsPriorities(int arrival, int departure)
    {
        double[] priority = new double[departure - arrival];

        for(int index = 0; index < priority.length; index++)
        {
            double sum = 0;
            double count = 0;

            int time = arrival + index; 
            for(int i = 0; i < arrivalTime.length; i++)
            {
                //Checks if given hour is within the range of given time
                if(arrivalTime[i] <= time && time < departureTime[i])
                {
                    sum += priorities[i];
                    count++;
                }
            }

            //Using if to avoid zero division
            if(count != 0)
            {
                priority[index] = sum / count;
            }
            else
            {
                priority[index] = sum;
            }
        }

        return priority;
    }

    /**
     * Takes the priority array and return the best hour based on the highest priority after removing the hours when the friend to avoid is there
     * @param arrival arrival time
     * @param departure departure time
     * @param name name of friend to avoid
     * @return best hour to attend
     */
    public static int bestTimeToAttend(int arrival, int departure, String name)
    {
        double[] priority = friendsPriorities(arrival, departure);

        //Finds the index at which name of the friend is (-1 for if the friend doesn't exist)
        int index = -1;
        for(int i = 0; i < nameOfFriends.length; i++)
        {
            if(name.equals(nameOfFriends[i]))
                index = i;
        }

        double largestPriority = 0;
        int bestHour = -1;
        for(int i = 0; i < priority.length; i++)
        {
            int hour = arrival + i;
            //Check if the index is valid
            if(index != -1)
            {
                //Checks if hour is within range of the friend attendance time and make priority to zero
                if(arrivalTime[index] <= hour && hour < departureTime[index])
                    priority[i] = 0;
            }

            //Checks if current priority is higher and change hour accordingly
            if(largestPriority < priority[i])
            {
                largestPriority = priority[i];
                bestHour = hour;
            }
        }
        return bestHour;
    }

    /**
     * Main method for implementation
     * @param args
     */
    public static void main(String[] args) 
    {
        //Variables
        int arrival, departure, bestTime;
        String name;

        Scanner in = new Scanner(System.in);

        //Takes input
        System.out.print("Enter friend you wish to avoid: ");
        name = in.next();
        System.out.print("Enter time interval you are available: ");
        arrival = in.nextInt();
        departure = in.nextInt();
        in.close();

        bestTime = bestTimeToAttend(arrival, departure, name);
        //Outputs the best hour
        if(bestTime != -1)
            System.out.println("Best time to attend to avoid " + name + " and to see the closest friends is " + bestTime);
        else
            System.out.println("There's no such time slot available");
    }
}


