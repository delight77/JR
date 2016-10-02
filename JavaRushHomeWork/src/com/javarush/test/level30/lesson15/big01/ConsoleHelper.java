package com.javarush.test.level30.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by GAVRISH on 03.06.16.
 */
public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString()
    {
        boolean flag = true;
        String result = null;
        while (flag)
        {
            try
            {
                result = reader.readLine();
                flag = false;
            }
            catch (IOException e)
            {
                writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
                flag = true;
            }
        }
        return result;

    }

    public static int readInt(){
        int result = 0;
        boolean flag = true;
        while (flag)
        {
            try
            {
                result = Integer.parseInt(readString());
                flag = false;
            }
            catch (NumberFormatException e)
            {
                writeMessage("Произошла ошибка\n" + "при попытке ввода числа. Попробуйте еще раз.");
                flag = true;
            }
        }
       return result;

    }
}
