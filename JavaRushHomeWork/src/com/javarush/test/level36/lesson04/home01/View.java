package com.javarush.test.level36.lesson04.home01;

/**
 * Created by delight on 14.08.16.
 */
public class View
{
    Controller controller = new Controller();
    public void fireEventShowData() {
        System.out.println(controller.onDataListShow());
    }
}
