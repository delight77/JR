package com.javarush.test.level27.lesson15.big01.ad;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

/**
 * Created by GAVRISH on 05.05.16.
 */
public class AdvertisementManager
{
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds;

    public AdvertisementManager(int timeSeconds){
        this.timeSeconds = timeSeconds;
    }
    public void processVideos(){
        ConsoleHelper.writeMessage("processVideos method calling");
    }
}
