package com.javarush.test.level08.lesson03.task03;

import java.util.HashMap;
import java.util.Map;

/* Коллекция HashMap из котов
Есть класс Cat с полем имя (name, String).
Создать коллекцию HashMap<String, Cat>.
Добавить в коллекцию 10 котов, в качестве ключа использовать имя кота.
Вывести результат на экран, каждый элемент с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String[] cats = new String[] {"васька", "мурка", "дымка", "рыжик", "серый", "снежок", "босс", "борис", "визя", "гарфи"};

        HashMap<String, Cat> map = addCatsToMap(cats);

        for (Map.Entry<String, Cat> pair : map.entrySet())
        {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }


    public static HashMap<String, Cat> addCatsToMap(String[] cats)
    {

        //Напишите тут ваш код
        HashMap<String, Cat>catsmap = new HashMap<String, Cat>();
        for (String s : cats)
        {
            catsmap.put(s, new Cat(s.toUpperCase()));
        }


        return catsmap;
        }
//        Cat cat1 = new Cat(cats[0]);
//        Cat cat2 = new Cat(cats[1]);
//        Cat cat3 = new Cat(cats[2]);
//        Cat cat4 = new Cat(cats[3]);
//        Cat cat5 = new Cat(cats[4]);
//        Cat cat6 = new Cat(cats[5]);
//        Cat cat7 = new Cat(cats[6]);
//        Cat cat8 = new Cat(cats[7]);
//        Cat cat9 = new Cat(cats[8]);
//        Cat cat10 = new Cat(cats[9]);
//
//        a.put(cat1.name,cat1);
//        a.put(cat2.name,cat2);
//        a.put(cat3.name,cat3);
//        a.put(cat4.name,cat4);
//        a.put(cat5.name,cat5);
//        a.put(cat6.name,cat6);
//        a.put(cat7.name,cat7);
//        a.put(cat8.name,cat8);
//        a.put(cat9.name,cat9);
//        a.put(cat10.name,cat10);



    public static class Cat
    {
        String name;

        public Cat(String name)
        {
            this.name = name;
        }

        @Override
        public String toString()
        {
            return name != null ? name.toUpperCase() : null;
        }
    }
}
