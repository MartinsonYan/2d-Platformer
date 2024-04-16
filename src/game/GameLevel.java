package game;

import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameLevel extends World {
    Character character;
    Game game;
    GameView gameView;

    int level;
    int levelNum = 1;


    private Enemy1 enemy1;
    private Enemy2 enemy2;
    private  Enemy3 enemy3;
    private  Enemy4 enemy4;
    private  Enemy5 enemy5;
    private  Enemy6 enemy6;
    private  Enemy7 enemy7;
    public GameLevel() {
        character = new Character(this);

    }

    public GameLevel(Game game) {
        character = new Character(this);

    }
    public Character getCharacter() {
        return character;
    }

    public Enemy1 getEnemy1() {
        return enemy1;
    }

    public Enemy2 getEnemy2() {
        return enemy2;
    }

    public Enemy3 getEnemy3() {return enemy3;}

    public void createLevel(GameView gameView, int levelNum) {
        gameView.getWorld().stop();
        switch (levelNum) {
            case 1 -> {
                Level1 firstLevel = new Level1();
                character = firstLevel.getCharacter();
                gameView.setWorld(firstLevel);
                CharacterController controller = new CharacterController(getCharacter());
                gameView.addKeyListener(controller);
                firstLevel.start();
            }
            case 2 -> {
                Level2 secondLevel = new Level2();
                character = secondLevel.getCharacter();
                gameView.setWorld(secondLevel);
                CharacterController controller = new CharacterController(getCharacter());
                gameView.addKeyListener(controller);
                secondLevel.start();
            }
            case 3 -> {
                Level3 thirdLevel = new Level3();
                character = thirdLevel.getCharacter();
                gameView.setWorld(thirdLevel);
                CharacterController controller = new CharacterController(getCharacter());
                gameView.addKeyListener(controller);
                thirdLevel.start();
            }





        }

    }

    /*    public class level1 extends GameLevel {
            public level1(Game game) {
                super(game);
            }
        }


        public static class Level1 extends GameLevel {
            public Level1(Game game) {
                super(game);
            }
        }*/
public void destroyLevel(GameView gameView){
    gameView.getWorld().stop();
}

    public void setCurrentLevel(int levelNumber) {
        level = levelNumber;
        destroyLevel(Game.getGameView());
        createLevel(Game.getGameView(), level);
        System.out.println("Current level: " + level);
        setLevelNum(levelNumber);
        System.out.println(getLevelNum());

    }

    public int getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(int levelNum) {
        this.levelNum = levelNum;
    }

    public void dead(){
        setCurrentLevel(1);
        Image background1 = new ImageIcon("data/Tiles/Assets/Background_2.png").getImage();
        Game.getGameView().setBackground(background1);
        enemy1.setIsEnemy1Dead(0);
        enemy2.setIsEnemy2Dead(0);
        enemy4.setIsEnemy4Dead(0);
        enemy5.setIsEnemy5Dead(0);
        enemy6.setIsEnemy6Dead(0);
        enemy7.setIsEnemy7Dead(0);

    }
    }

