package com.javarush.test.level07.lesson09.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Буква «р» и буква «л»
1. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.1. удалять из списка строк все слова, содержащие букву «р»
2.2. удваивать все слова содержащие букву «л».
2.3. если слово содержит и букву «р» и букву «л», то оставить это слово без изменений.
Пример:
роза
лира
лоза
Выходные данные:
лира
лоза
лоза
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("лара"); //0
        list.add("вира"); //1
        list.add("лаза"); //2
        list = fix(list);

        for (String s : list)
        {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        //add your code here -  добавь код тут
        for(int i = 0; i < 3;i++){

            if(list.get(i).indexOf('р') != -1 && list.get(i).indexOf('л') == -1){
                list.remove(i);
            }else if(list.get(i).indexOf('л') != -1 && list.get(i).indexOf('р') == -1){
                list.add(list.get(i));
                i++;

            }
//            if(list.get(i).indexOf('л') != -1 && list.get(i).indexOf('р') != -1){
//                list.get(i);
//
//            }

        }
        return list;
    }
}