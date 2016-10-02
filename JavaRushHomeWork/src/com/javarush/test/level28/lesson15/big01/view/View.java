package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.io.IOException;
import java.util.List;

/**
 * Created by GAVRISH on 25.05.16.
 */
public interface View
{
    void update(List<Vacancy> vacancies);
    void setController(Controller controller) throws IOException;
}
