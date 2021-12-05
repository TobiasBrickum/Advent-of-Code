package Year2021.Day1;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static String fileName = "taskNumbers.txt";

    public static void main(String args[])
    {
        System.out.println("The result is: " + getTaskNumbers());
    }

    public static int getTaskNumbers()
    {
        // ToDO change code for path and Excaptionhandeling
        List<Integer> taskNumbersList = new LinkedList<>();
        // F:\GitHub Shiki Magata\Advent-of-Code\src\Year2021\Day1\taskNumbers.txt
        // F:\GitHub Shiki Magata\Advent-of-Code\Year2021\Day1\taskNumbers.txt
        File taskNumbersFile = new File(new PathHelper().getCombinedPath(fileName));
        Scanner taskNumbersScanner;
        try
        {
            taskNumbersScanner = new Scanner(taskNumbersFile);
            while(taskNumbersScanner.hasNextLine() == true)
            {
                int temp = Integer.parseInt(taskNumbersScanner.nextLine());
                taskNumbersList.add(temp);
            }
            taskNumbersScanner.close();

            int increaseCounter = 0;
            int oldNumber = taskNumbersList.get(0);
            for (int currentNumber: taskNumbersList)
            {
                if(currentNumber > oldNumber)
                {
                    increaseCounter ++;
                    oldNumber = currentNumber;
                }
                else if(currentNumber < oldNumber)
                {
                    oldNumber = currentNumber;
                }
            }

            return increaseCounter;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
        finally
        {
            // ToDO finally
            // taskNumbersScanner.close();
        }
    }
}