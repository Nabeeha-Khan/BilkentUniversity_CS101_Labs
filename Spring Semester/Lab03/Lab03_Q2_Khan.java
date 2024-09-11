import java.util.Scanner;

public class Lab03_Q2_Khan 
{
    public static void main(String[] args) 
    {
        //Variables
        double children, adults, seniors, childDepend, seniorDepend;

        //Take input values
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number citizen under 15: ");
        children = in.nextDouble();
        System.out.print("Enter number citizen between 15 and 64: ");
        adults = in.nextDouble();
        System.out.print("Enter number citizen over 64: ");
        seniors = in.nextDouble();
        in.close();

        //Calculate child and senior dependency
        childDepend = children / adults * 100;
        seniorDepend = seniors / adults * 100;

        //Print Dependency Rate
        System.out.printf("%nChild Dependency: %.1f", childDepend);
        System.out.printf("%nSenior Dependency: %.1f", seniorDepend);

        //Find age dependency category
        if(seniorDepend < 15)
        {
            if(childDepend < 29)
            {
               System.out.println("\r\nAge Dependency Category: Low Overall Dependency");
            }

            else if(childDepend >= 29 && childDepend <= 45)
            {
               System.out.println("\r\nAge Dependency Category: Moderate Child Dependency");
            }
            else
            {
               System.out.println("\r\nAge Dependency Category: High Child Dependency");
            }
        }

        else
        {
            if(childDepend < 29)
            {
               System.out.println("\r\nAge Dependency Category: High Old-age Dependency");
            }

            else
            {
               System.out.println("\r\nAge Dependency Category: Double Dependency");
            }
        }
    }    
}
