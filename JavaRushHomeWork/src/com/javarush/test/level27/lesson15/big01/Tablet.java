package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by GAVRISH on 02.05.16.
 */
public class Tablet extends Observable
{
    final static Logger logger = Logger.getLogger(Tablet.class.getName());
    final int number;

    public Tablet(int number)
    {
        this.number = number;
    }
    public void createOrder(){
        Order order = null;
        try{
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            setChanged();
            if(!order.isEmpty()){
                notifyObservers(order);
            }
            new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();

        }
        catch (IOException e){
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }


}
