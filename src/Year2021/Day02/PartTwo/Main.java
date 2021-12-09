package Year2021.Day02.PartTwo;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;;

public class Main
{
    private final static String fileSeparator = File.separator;
    private final static String fileNameDirectory = "Year2021"
            + fileSeparator + "Day02"
            + fileSeparator + "task02.txt";

    public static void main(String[] args)
    {
        partTwo();
    }

    private static void   partTwo()
    {
        List<String> taskNumbersList = new LinkedList<>();
        String[] taskIdentifier = new String[]{"up", "down", "forward"};
        int[] taskIdentifierCounter = new int[3]; // 0 = "aim", "depth", "horizon"

        try
        {
            File taskFile = new File(ClassLoader.getSystemResource(fileNameDirectory).toURI());
            Scanner scannTaskFile = new Scanner(taskFile);
            while(scannTaskFile.hasNextLine() == true)
            {
                String temp = scannTaskFile.nextLine();
                char a = temp.charAt(temp.length()-1);
                int b = Integer.parseInt(Character.toString(a));

                if(temp.startsWith(taskIdentifier[0])) // up
                {
                    taskIdentifierCounter[0] -= b; // aim
                }
                else if(temp.startsWith(taskIdentifier[1])) // down
                {
                    taskIdentifierCounter[0] += b; // aim
                }
                else if(temp.startsWith(taskIdentifier[2])) // forward
                {
                    taskIdentifierCounter[2] += b; // horizon
                    taskIdentifierCounter[1] += b * taskIdentifierCounter[0]; // depth
                }
            }
            scannTaskFile.close();

            System.out.println("What do you get if you multiply your final horizontal position by your final depth?");
            System.out.println("\tMax aim:"+ taskIdentifierCounter[0]);
            System.out.println("\tMax depth:"+ taskIdentifierCounter[1]);
            System.out.println("\tMax horizon: "+ taskIdentifierCounter[2]);
            System.out.println("Answer: " + taskIdentifierCounter[1] * taskIdentifierCounter[2]);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
