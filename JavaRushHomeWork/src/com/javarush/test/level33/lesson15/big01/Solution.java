package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by delight on 17.07.16.
 */
public class Solution
{
    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> g = new HashSet<>();
        for(String s: strings){
            g.add(shortener.getId(s));
        }
        return g;

    }
    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> g = new HashSet<>();
        for(Long s: keys){
            g.add(shortener.getString(s));
        }
        return g;
    }
    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        //Выводить имя класса стратегии. Имя не должно включать имя пакета
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> g = new HashSet<>();
        for(long i = 0; i<elementsNumber;i++){
            g.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);
        Set<Long> idsSet;
        Date olddate = new Date();
        Date newdate = new Date();
        Long old = olddate.getTime();
        idsSet = getIds(shortener,g);
        Long new1 = newdate.getTime();
        Long minus = new1 - old;
        Helper.printMessage(Long.toString(minus));

        Set<String> idsSet1;
        Date olddate1 = new Date();
        Date newdate1 = new Date();
        Long old1 = olddate.getTime();
        idsSet1 = getStrings(shortener, idsSet);
        Long new2 = newdate.getTime();
        Long minus1 = new1 - old;
        Helper.printMessage(Long.toString(minus1)); 
        if(idsSet1.equals(g)){
            Helper.printMessage("Тест пройден.");
        }
        else{
            Helper.printMessage("Тест не пройден.");
        }

    }
    public static void main(String[] args){
        testStrategy(new HashMapStorageStrategy(),10000);
    }
}
