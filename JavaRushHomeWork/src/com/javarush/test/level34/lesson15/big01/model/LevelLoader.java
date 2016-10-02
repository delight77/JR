package com.javarush.test.level34.lesson15.big01.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {

    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }


    public GameObjects getLevel(int level) {
        level = level % 60;
        Player player = new Player(0, 0);
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(levels.toString()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (("Maze: " + level).equals(line)) {
                    break;
                }
            }
            bufferedReader.readLine();
            int x = Integer.parseInt(bufferedReader.readLine().split(" ")[2]);
            int y = Integer.parseInt(bufferedReader.readLine().split(" ")[2]);
            int x0 = Model.FIELD_SELL_SIZE / 2;
            int y0 = Model.FIELD_SELL_SIZE / 2;
            bufferedReader.readLine();
            bufferedReader.readLine();
            bufferedReader.readLine();
            for (int i = 0; i < y; i++) {
                line = bufferedReader.readLine();
                for (int j = 0; j < x; j++) {
                    switch (line.charAt(j)) {
                        case ' ':
                            break;
                        case 'X':
                            walls.add(new Wall(x0 + j * Model.FIELD_SELL_SIZE, y0 + i * Model.FIELD_SELL_SIZE));
                            break;
                        case '*':
                            boxes.add(new Box(x0 + j * Model.FIELD_SELL_SIZE, y0 + i * Model.FIELD_SELL_SIZE));
                            break;
                        case '.':
                            homes.add(new Home(x0 + j * Model.FIELD_SELL_SIZE, y0 + i * Model.FIELD_SELL_SIZE));
                            break;
                        case '&':
                            boxes.add(new Box(x0 + j * Model.FIELD_SELL_SIZE, y0 + i * Model.FIELD_SELL_SIZE));
                            homes.add(new Home(x0 + j * Model.FIELD_SELL_SIZE, y0 + i * Model.FIELD_SELL_SIZE));
                            break;
                        case '@':
                            player = new Player(x0 + j * Model.FIELD_SELL_SIZE, y0 + i * Model.FIELD_SELL_SIZE);
                            break;
                    }
                }
            }
        }
        catch (IOException ignore) {
        }
        return new GameObjects(walls, boxes, homes, player);
    }

}