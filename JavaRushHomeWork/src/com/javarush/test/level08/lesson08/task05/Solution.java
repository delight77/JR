package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //Напишите тут ваш код
        HashMap<String,String> a = new HashMap<String, String>();
        a.put("Цой","Виктор");
        a.put("Гавриш","Андрей");
        a.put("Алаев","Андрей");
        a.put("Нигма","Вася");
        a.put("Олух","Виталий");
        a.put("Дурень","Вячеслав");
        a.put("Нудный","Вадим");
        a.put("Деревянный","Олег");
        a.put("Разумный","Святослав");
        a.put("Сизый","Игорь");

        return a;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //Напишите тут ваш код
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){

            removeItemFromMapByValue(map,iterator.next().getValue());
        }



    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());

        }
    }
    public static void main(String[] args) throws Exception{

        HashMap<String, String> a = new HashMap<String, String>(createMap());
        removeTheFirstNameDuplicates(a);
        for (Map.Entry<String, String> pair: a.entrySet()){
            System.out.println( pair.getKey() + " " + pair.getValue());

        }






    }

}
