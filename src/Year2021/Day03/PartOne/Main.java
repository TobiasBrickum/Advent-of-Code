package Year2021.Day03.PartOne;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
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

            int zeroCount = 0; int oneCount = 0;
            String resultPositiv = "";
            String resultNegativ = "";
            int taskNumbersListBitCount = taskNumbersList.get(0).toString().length();

            for (int i = 0; i < taskNumbersList.size(); i++)
            {
                System.out.println(taskNumbersList.get(i));
                for (int j = 0; j < taskNumbersListBitCount; j++)
                {
                    String temp;
                    if(j == taskNumbersListBitCount -1)
                    {
                        temp = taskNumbersList.get(i).substring(j);
                        System.out.print(temp);
                    }
                    else
                    {
                        temp = taskNumbersList.get(i).substring(j,j+1);
                        System.out.print(temp);
                    }

                    if(temp.equals("0"))
                    {
                        zeroCount++;
                    }
                    else
                    {
                        oneCount++;
                    }
                }

                if(zeroCount > oneCount)
                {
                    resultPositiv += "0";
                }
                else
                {
                    resultPositiv += "1";
                }

                zeroCount = 0;
                oneCount = 0;
            }

            char[] temp = resultPositiv.toCharArray();
            for (char x : temp)
            {
                if(x == 0)
                {
                    resultNegativ += "1";
                }
                else
                {
                    resultNegativ += "0";
                }
            }


            System.out.println("What do you get if you multiply your final horizontal position by your final depth?");
            System.out.println("resultPositiv: " + resultPositiv);
            System.out.println("resultNegativ: " + resultNegativ);

            System.out.println("Answer: ");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
