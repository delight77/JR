package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //Напишите тут ваш код
        HashMap<String,String> a = new HashMap<String, String>();
        a.put("Цой","Виктор");
        a.put("Гавриш","Андрей");
        a.put("Алаев","Азер");
        a.put("Нигма","Вася");
        a.put("Олух","Виталий");
        a.put("Дурень","Вячеслав");
        a.put("Нудный","Вадим");
        a.put("Прелый","Олег");
        a.put("Разумный","Святослав");
        a.put("Сизый","Игорь");

        return a;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //Напишите тут ваш код
        int count = 0;
        for(Map.Entry<String,String> s: map.entrySet()){
        if(s.getValue() == name){
            count++;
        }

        }
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        //Напишите тут ваш код
        int count = 0;
        for(Map.Entry<String,String> s: map.entrySet()){
            if(s.getKey() == familiya){
                count++;
            }

        }
        return count;

    }
}
