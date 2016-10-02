package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

/**
 * Created by GAVRISH on 02.05.16.
 */
public class Restaurant
{
    public static void main(String[] args){

        Cook cook = new Cook("Amigo");
        Waitor waitor = new Waitor();
        cook.addObserver(waitor);
        Tablet t = new Tablet(5);
        t.addObserver(cook);
        t.createOrder();




    }
}
