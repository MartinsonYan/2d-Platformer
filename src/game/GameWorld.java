package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class    GameWorld extends World  {
        private Character character;
        private Enemy1 enemy1;
        private Enemy2 enemy2;


        public GameWorld() {
                super();


                //1. make an empty game world
                World world = new World();

                //make a ground platform
                Shape shape = new BoxShape(30, 0.5f);
                StaticBody ground = new StaticBody(this, shape);
                ground.setPosition(new Vec2(0f, -11.5f));
                ground.addImage(new BodyImage("data/ground.png",1f));



                //make a suspended platform
                Shape platformShape = new BoxShape(1.5f, 0.5f);
                StaticBody platform1 = new StaticBody(this, platformShape);
                platform1.setPosition(new Vec2(6, -4f));
                platform1.addImage(new BodyImage("data/platform1.png",4));
                //make a character (with an overlaid image)
                /*Character character = new Character(this);
                character.setPosition(new Vec2(7, -9));
                character.setCredits(15);*/
                //Player Character

                character = new Character(this);
                character.setPosition(new Vec2(-10, -11));
                


                //Enemy1
                enemy1 = new Enemy1(this);
                enemy1.setPosition(new Vec2(6,-11));

                //Enemy2
                enemy2 = new Enemy2(this);
                enemy2.setPosition(new Vec2(6,-3));

                //Collision
                GenericCollisionListener gcl = new GenericCollisionListener();
                character.addCollisionListener(gcl);
                ground.addCollisionListener(gcl);









        }


        public Character getCharacter(){
            return character;
        }
    }