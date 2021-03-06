package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gavrish on 19.04.16.
 */
public class ConsoleHelper
{
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

   public static void writeMessage(String message){
       System.out.println(message);
   }

   public static String readString() throws InterruptOperationException
   {
       String message = "";
       try{
       message = reader.readLine();
           if (message.equalsIgnoreCase("EXIT"))
               throw new InterruptOperationException();
       }
       catch (IOException ignored)
       {
       }

       return message;
   }

   public static String askCurrencyCode() throws InterruptOperationException
   {
       boolean isCorrect = false;
       String currencyCode = "";
       while(!isCorrect){
           writeMessage("Введите код валюты: ");
           currencyCode = readString();
           if (currencyCode.length()!=3){
               writeMessage("Повторите попытку: ");
           }
           else{
               isCorrect = true;
           }


       }
       return currencyCode.toUpperCase();

   }
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        String[] array;
        writeMessage("Введите номинал и количество бонкнот: ");

        while (true)
        {
            String s = readString();
            array = s.split(" ");
            int k;
            int l;
            try
            {
                k = Integer.parseInt(array[0]);
                l = Integer.parseInt(array[1]);
            }
            catch (Exception e)
            {
                writeMessage("invalid.data");
                continue;
            }
            if (k <= 0 || l <= 0 || array.length > 2)
            {
                writeMessage("invalid.data");
                continue;
            }
            break;
        }
        return array;
    }

    public static Operation askOperation() throws InterruptOperationException, IOException
    {
        while (true)
        {
            String line = readString();
            if (checkWithRegExp(line))
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(line));
            else
                writeMessage("invalid.data");
        }

    }

    public static boolean checkWithRegExp(String Name)
    {
        Pattern p = Pattern.compile("^[1-4]$");
        Matcher m = p.matcher(Name);
        return m.matches();
    }
}
