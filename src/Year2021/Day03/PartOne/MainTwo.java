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
        //List<Long> taskNumbersList = new LinkedList<>();
        List<String> taskNumbersList = new LinkedList<>();
        try
        {
            File taskFile = new File(ClassLoader.getSystemResource(fileNameDirectory).toURI());
            Scanner scannTaskFile = new Scanner(taskFile);
            while(scannTaskFile.hasNextLine() == true)
            {
                //taskNumbersList.add(Long.parseLong(scannTaskFile.nextLine()); // cut all first zeros so useless
                taskNumbersList.add(scannTaskFile.nextLine());
            }
            scannTaskFile.close();

            // view scanned lines
            for (String x : taskNumbersList )
            {
                System.out.println(x);
            }

            int taskNumbersListBitCount = taskNumbersList.get(0).toString().length();
            int[] zeroCounter = new int[taskNumbersListBitCount];
            int[] oneCounter = new int[taskNumbersListBitCount];

            for (int i = 0; i < taskNumbersList.size(); i++)   // spalte
            {
                for (int j = 0; j < taskNumbersListBitCount; j++) // index
                {
                    String temp;
                    if(j == taskNumbersListBitCount -1)
                    {
                        temp = taskNumbersList.get(i).substring(j);
                        //System.out.print(temp);
                    }
                    else
                    {
                        temp = taskNumbersList.get(i).substring(j, j+1);
                        //System.out.print(temp);
                    }

                    if(temp.equals("0"))
                    {
                        zeroCounter[j] ++;
                    }
                    else
                    {
                        oneCounter[j] ++;
                    }
                }
            }

            System.out.println("zero counter :" + Arrays.toString(zeroCounter));
            System.out.println("one counter :" + Arrays.toString(oneCounter));

            int zeroCount = 0; int oneCount = 0;
            String resultPositiv = "";
            String resultNegativ = "";

            for (int i = 0; i < zeroCounter.length; i++)
            {
                if(zeroCounter[i] > oneCounter[i])
                {
                    resultPositiv += "0";
                    resultNegativ += "1";
                }
                else
                {
                    resultPositiv += "1";
                    resultNegativ += "0";
                }
            }

            int resultPositivDecimal = Integer.parseInt(resultPositiv, 2);
            int resultNegativvDecimal = Integer.parseInt(resultNegativ, 2);
            int result = resultPositivDecimal * resultNegativvDecimal;

            System.out.println("\nWhat do you get if you multiply your final horizontal position by your final depth?");
            System.out.println("resultPositiv binär: " + resultPositiv);
            System.out.println("resultNegativ binär: " + resultNegativ);
            System.out.println("resultPositiv decimal: " + resultPositivDecimal);
            System.out.println("resultNegativ decimal: " + resultNegativvDecimal);
            System.out.println("resultNegativ * resultPositiv =  end result: " + result );

            System.out.println("\nAnswer: " + result);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
