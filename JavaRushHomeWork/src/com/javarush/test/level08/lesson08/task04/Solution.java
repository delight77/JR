package com.javarush.test.level08.lesson08.task04;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Iterator;
/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap() throws ParseException
    {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        HashMap<String, Date> map = new HashMap<String, Date>();

        map.put("Сталлоней", format.parse("01.08.2009"));
        map.put("Сталлонея", format.parse("01.07.2009"));
        map.put("Сталлонеч", format.parse("01.06.2009"));
        map.put("Сталлонес", format.parse("01.05.2009"));
        map.put("Сталлонем", format.parse("01.04.2009"));
        map.put("Сталлонеи", format.parse("01.03.2009"));
        map.put("Сталлонет", format.parse("01.02.2009"));
        map.put("Сталлонеь", format.parse("01.01.2009"));
        map.put("Сталлонеб", format.parse("01.12.2009"));
        map.put("Сталлонев", format.parse("01.09.2009"));

        return map;

        //Напишите тут ваш код

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            int month = iterator.next().getValue().getMonth() + 1;
            if (6 <= month && month <= 8)
            {
                iterator.remove();
            }
        }
    }

}
