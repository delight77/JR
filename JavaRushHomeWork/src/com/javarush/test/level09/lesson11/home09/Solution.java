package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
         Map<String,Cat> st = new HashMap<String, Cat>();
        Cat c = new Cat("Вася");
        Cat c1 = new Cat("Вася");
        Cat c2 = new Cat("Вася");
        Cat c3 = new Cat("Вася");
        Cat c4 = new Cat("Вася");
        Cat c5 = new Cat("Вася");
        Cat c6 = new Cat("Вася");
        Cat c7 = new Cat("Вася");
        Cat c8 = new Cat("Вася");
        Cat c9 = new Cat("Вася");
        st.put("Васяй",c);
        st.put("Васяц",c1);
        st.put("Васяу",c2);
        st.put("Васяк",c3);
        st.put("Васян",c4);
        st.put("Васяг",c5);
        st.put("Васяш",c6);
        st.put("Васяф",c7);
        st.put("Васяв",c8);
        st.put("Васяр",c9);

        return st;
        //Напишите тут ваш код
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        //Напишите тут ваш код
        Set<Cat> ct = new HashSet<Cat>();
        for(Map.Entry<String, Cat> ww: map.entrySet())
        {
            ct.add(ww.getValue());
        }
        return ct;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
