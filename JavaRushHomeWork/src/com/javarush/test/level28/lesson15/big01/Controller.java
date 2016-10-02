package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Model;

import java.io.IOException;

public class Controller
{
    Model model;

    public Controller(Model model){
        if (model == null) {
            throw  new IllegalArgumentException("Illegal arguments");
        }
        this.model = model;
    }

    public void onCitySelect(String cityName){
        try
        {
            this.model.selectCity(cityName);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}