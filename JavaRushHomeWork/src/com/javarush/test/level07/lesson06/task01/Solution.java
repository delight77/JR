package com.javarush.test.level07.lesson06.task01;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        ArrayList<String> a = new ArrayList<String>();
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");
        a.add("e");
        System.out.println(a);
        for(int i = 0; i < a.size(); i++){
            System.out.println(a.get(i));
    }



    }
}
