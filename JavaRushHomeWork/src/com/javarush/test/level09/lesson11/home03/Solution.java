package com.javarush.test.level09.lesson11.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Метод в try..catch
Вводить с клавиатуры числа. Код по чтению чисел с клавиатуры вынести в отдельный метод readData.
Обернуть все тело (весь код внутри readData, кроме объявления списка, где будут храниться числа) этого метода в try..catch.
Если пользователь ввёл какой-то текст, вместо ввода числа, то метод должен перехватить исключение и вывести на экран все введенные числа в качестве результата.
Числа выводить с новой строки сохраняя порядок ввода
*/

public class Solution
{
    public static void main(String[] args) throws IOException,ArrayStoreException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        readData(reader);
    }

    public static void readData(BufferedReader reader) throws IOException,ArrayStoreException{
        ArrayList<Integer> s = new ArrayList<Integer>();
        try
        {
            while(true){
                s.add(Integer.parseInt(reader.readLine()));
            }

//            for (int i = 0; i < 999; i++)
//            {
//                int g = Integer.parseInt(reader.readLine());
//                s.add(g);
//            }
        } catch(NumberFormatException e){
            for (int i = 0; i < s.size(); i++)
            {
                System.out.println(s.get(i));
            }
        }
        //add your code here
    }
}