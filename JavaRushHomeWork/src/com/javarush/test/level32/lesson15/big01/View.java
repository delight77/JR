package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by GAVRISH on 17.06.16.
 */
public class View extends JFrame implements ActionListener
{
    private Controller controller;
    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

    public Controller getController()
    {
        return controller;
    }

    public void setController(Controller controller)
    {
        this.controller = controller;
    }
    public void init(){
        initGui();
        FrameListener win = new FrameListener(this);
        this.addWindowListener(win);
        this.setVisible(true);
    }
    public void exit(){
        controller.exit();
    }

    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();

    public void initMenuBar() {

    }

    public void initEditor(){

    }

    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }
    public void selectedTabChanged(){

    }

}
