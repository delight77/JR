package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by GAVRISH on 02.05.16.
 */
public class Order
{
    private List<Dish> dishes;
    private Tablet tablet;

    public Order(Tablet tablet) throws IOException
    {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
        this.tablet = tablet;
    }

    @Override
    public String toString()
    {
        if(dishes == null||dishes.isEmpty()){
            return "";
        }
        else {
            return "Your order: " + dishes.toString() + " of " + tablet;
        }
    }
    public int getTotalCookingTime(){
        int t = 0;
        for(Dish d: dishes){
            t+=d.getDuration();
        }
        return t;
    }
    public boolean isEmpty(){
        if(dishes.isEmpty()){
            return true;
        }
        else
           return false;
    }
}
