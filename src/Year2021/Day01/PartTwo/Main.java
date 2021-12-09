package Year2021.Day01.PartTwo;
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

            List<Integer> groupNumbers = new LinkedList<>();
            for(int i = 0; i < taskNumbersList.size(); i++)
            {
            /*
            1 A-+
            2 A B
            3 A B C
            4   B C D
            5     C D E
            6       D E F
            7       E F G
            if (A1-A3) < (B2-B4) ? counter ++;...

            Stop when there aren't enough measurements left to create a new three-measurement sum!!!
             */
                if(i == taskNumbersList.size()-2)
                {
                    break;
                }
                else
                {
                    groupNumbers.add(taskNumbersList.get(i) + taskNumbersList.get(i+1) + taskNumbersList.get(i+2));

                    String result = " = ";    String add = " + ";
                    System.out.println("Group : " + i +  result + taskNumbersList.get(i) + add + taskNumbersList.get(i+1)
                            + add + taskNumbersList.get(i+2) + result + groupNumbers.get(i));
                }
            }

            int retNumberIncreaseCounter = 0; // count all higher numbers
            int oldNumber = groupNumbers.get(0);
            for (int currentNumber: groupNumbers)
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

            System.out.println("How many sums are larger than the previous sum?");
            System.out.println("Answer: " + retNumberIncreaseCounter);
            // 1506 too low
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}