package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level2 extends GameLevel {


    public Level2(/*Game game*/) {
        super();




        //change the background
        Image background2 = new ImageIcon("data/Background3.png").getImage();
        Game.getGameView().setBackground(background2);

        //make a ground platform
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));
        ground.addImage(new BodyImage("data/ground.png", 1f));


        //make a suspended platform
        Shape platformShape = new BoxShape(1.5f, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-6, -6f));

        platform1.addImage(new BodyImage("data/platform2.png", 4));

        StaticBody platform2 = new StaticBody(this,platformShape);
        platform2.setPosition((new Vec2(5,-4.3f)));
        platform2.addImage(new BodyImage("data/platform2.png", 4));

        StaticBody platform3 = new StaticBody(this,platformShape);
        platform3.setPosition((new Vec2(-2.4f,3f)));
        platform3.addImage(new BodyImage("data/platform2.png", 4));
        //make a character (with an overlaid image)
                /*Character character = new Character(this);
                character.setPosition(new Vec2(7, -9));
                character.setCredits(15);*/
        //Player Character
        getCharacter().setPosition(new Vec2(-2, -11f));
        getCharacter().setReturnPosition(new Vec2(-2f, -11f));



        //Enemy
        Enemy3 enemy3 = new Enemy3(this);
        enemy3.setClipped(true);
        enemy3.setPosition(new Vec2(0, 0));

        Enemy4 enemy4 = new Enemy4(this);
        enemy4.setPosition(new Vec2(-6,-5.5f));

        Enemy5 enemy5 = new Enemy5(this);
        enemy5.setPosition(new Vec2(-2.4f,3.5f));






        //Collision
        GenericCollisionListener gcl = new GenericCollisionListener();
        getCharacter().addCollisionListener(gcl);
        ground.addCollisionListener(gcl);
        CharacterCollision collide = new CharacterCollision();
        enemy3.addCollisionListener(collide);
        //getEnemy1().addCollisionListener(collide);
        //getEnemy2().addCollisionListener(collide);


    }
}