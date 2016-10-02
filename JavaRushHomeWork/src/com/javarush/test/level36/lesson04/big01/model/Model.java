package com.javarush.test.level36.lesson04.big01.model;

/**
 * Created by delight on 10.08.16.
 */
public interface Model
{
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();

    void loadUserById(long userId);
    void deleteUserById(long userId);
    void changeUserData(String name, long id, int level);
}
