package Year2021.Day03.PartOne;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainTwo {
    private final static String fileSeparator = File.separator;
    private final static String fileNameDirectory = "Year2021"
            + fileSeparator + "Day03"
            + fileSeparator + "task03.txt";

    public static void main(String[] args) {
        partOne();
    }

    private static void   partOne()
    {
        //List<Long> tasksInputList = new LinkedList<>();
        List<String> tasksInputList = new LinkedList<>();
        try
        {
            File taskFile = new File(ClassLoader.getSystemResource(fileNameDirectory).toURI());
            Scanner scannTaskFile = new Scanner(taskFile);
            while(scannTaskFile.hasNextLine() == true)
            {
                //tasksInputList.add(Long.parseLong(scannTaskFile.nextLine()); // cut all first zeros so useless
                tasksInputList.add(scannTaskFile.nextLine());
            }
            scannTaskFile.close();

            // view task input
            for (String rowInput : tasksInputList )
            {
                System.out.println(rowInput);
            }

            int taskValueListRowCount = tasksInputList.get(0).toString().length();
            int[] columnNumberZeroCounter = new int[taskValueListRowCount];
            int[] columnNumberOneCounter = new int[taskValueListRowCount];

            // loop all list columns
            for (int i = 0; i < tasksInputList.size(); i++)
            {
                // loop all index values from currently list column
                for (int j = 0; j < taskValueListRowCount; j++)
                {
                    String temp; // save the index value from currently list column index starts 0
                    if(j == taskValueListRowCount -1)
                    {
                        temp = tasksInputList.get(i).substring(j);
                    }
                    else
                    {
                        temp = tasksInputList.get(i).substring(j, j+1);
                    }

                    // count for each column all row values between 0 or 1
                    if(temp.equals("0"))
                    {
                        columnNumberZeroCounter[j] ++;
                    }
                    else
                    {
                        columnNumberOneCounter[j] ++;
                    }
                }
            }

            System.out.println("Each column number zero count :" + Arrays.toString(columnNumberZeroCounter));
            System.out.println("Each column number one count :" + Arrays.toString(columnNumberOneCounter));

            String gammaRate = "";
            String epsilonRate = "";
            for (int i = 0; i < columnNumberZeroCounter.length; i++)
            {
                if(columnNumberZeroCounter[i] > columnNumberOneCounter[i])
                {
                    gammaRate += "0";
                    epsilonRate += "1";
                }
                else
                {
                    gammaRate += "1";
                    epsilonRate += "0";
                }
            }

            int gammaRateDecimal = Integer.parseInt(gammaRate, 2);
            int epsilonRateDecimal = Integer.parseInt(epsilonRate, 2);
            int result = gammaRateDecimal * epsilonRateDecimal;

            System.out.println("\nWhat do you get if you multiply your final horizontal position by your final depth?");
            System.out.println("\nAnswer: Gamma rate * epsilon rate = " + result);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
