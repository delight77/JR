package com.javarush.test.level06.lesson08.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Класс ConsoleReader
Сделать класс ConsoleReader, у которого будут 4 статических метода:
String readString() – читает с клавиатуры строку
int readInt() – читает с клавиатуры число
double readDouble() – читает с клавиатуры дробное число
void readLn() – ждет нажатия enter [использовать readString()]
*/

public class ConsoleReader
{
    public static String readString() throws Exception
    {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String a =
                return reader.readLine();

    }

    public static int readInt() throws Exception
    {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //int b =
                return Integer.parseInt(reader.readLine());

    }

    public static double readDouble() throws Exception
    {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Double c =
                return Double.parseDouble(reader.readLine());
    }

    public static void readLn() throws Exception
    {
        readString();
        //Напишите тут ваш код

    }
}
