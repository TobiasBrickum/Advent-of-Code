package Year2021.Day01.PartOne;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    private final static String fileSeparator = File.separator;
    private final static String fileNameDirectory = "Year2021"
                                                  + fileSeparator + "Day01"
                                                  + fileSeparator + "task01.txt";

    public static void main(String args[])
    {
        getNumberIncreaseCount();
    }

    public static void getNumberIncreaseCount()
    {
        List<Integer> taskNumbersList = new LinkedList<>();
        try
        {
            File taskFile = new File(ClassLoader.getSystemResource(fileNameDirectory).toURI());
            Scanner scannTaskFile = new Scanner(taskFile);

            while(scannTaskFile.hasNextLine() == true)
            {
                int temp = Integer.parseInt(scannTaskFile.nextLine());
                taskNumbersList.add(temp);
            }
            scannTaskFile.close();

            int retNumberIncreaseCounter = 0; // count all higher numbers
            int oldNumber = taskNumbersList.get(0);
            for (int currentNumber: taskNumbersList)
            {
                if(currentNumber > oldNumber)
                {
                    retNumberIncreaseCounter ++;
                    oldNumber = currentNumber;
                }
                else if(currentNumber < oldNumber)
                {
                    oldNumber = currentNumber;
                }
            }

            System.out.println("How many measurements are larger than the previous measurement?");
            System.out.println("Answer: " + retNumberIncreaseCounter);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}