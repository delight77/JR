package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by delight on 18.06.16.
 */
public class TabbedPaneChangeListener implements ChangeListener
{
    View view;
    public TabbedPaneChangeListener(View view){
        this.view = view;
    }
    @Override
    public void stateChanged(ChangeEvent e)
    {
        view.selectedTabChanged();
    }
}
