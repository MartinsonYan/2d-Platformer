package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level1 extends GameLevel {


    public Level1(/*Game game*/) {
        super();


        //1. make an empty game world




        //make a ground platform
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));
        ground.addImage(new BodyImage("data/ground.png", 1f));


        //make a suspended platform
        Shape platformShape = new BoxShape(1.5f, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(6, -4f));
        platform1.addImage(new BodyImage("data/platform1.png", 4));
        //make a character (with an overlaid image)
                /*Character character = new Character(this);
                character.setPosition(new Vec2(7, -9));
                character.setCredits(15);*/
        //Player Character
        getCharacter().setPosition(new Vec2(-10, -11));
        getCharacter().setReturnPosition(new Vec2(-10,-11));
        //Enemy1
        Enemy1 enemy1 = new Enemy1(this);
        enemy1.setPosition(new Vec2(6,-11));
        //Enemy2
        Enemy2 enemy2 = new Enemy2(this);
        enemy2.setPosition(new Vec2(6,-3));




        //Collision
        GenericCollisionListener gcl = new GenericCollisionListener();
        getCharacter().addCollisionListener(gcl);
        ground.addCollisionListener(gcl);
        CharacterCollision collide = new CharacterCollision();
        enemy1.addCollisionListener(collide);
        enemy2.addCollisionListener(collide);


        }




}