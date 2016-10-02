package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.MoikrugStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;

import java.io.IOException;

public class Aggregator
{
    public static void main(String[] args) throws IOException
    {
        HtmlView htmlView = new HtmlView();
        Model model = new Model(htmlView,new Provider(new HHStrategy()),new Provider(new MoikrugStrategy()));
        Controller controller = new Controller(model);
        htmlView.setController(controller);
        htmlView.userCitySelectEmulationMethod();

    }
}