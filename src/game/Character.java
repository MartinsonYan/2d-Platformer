package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.FixtureDef;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Character extends Walker {
    private int credits = 0;
    private int currentHealth = 3;
    private int maxHealth;
    private static SoundClip arrowSound;
    private  Vec2 lastSaveLocation;


    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
        System.out.println(currentHealth);
    if(this.currentHealth == 0){
        Game.getLevel().dead();
    }
    }

    boolean isDead;



    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }



    public static final Shape characterShape = new BoxShape(1,1.5f);



    public static final BodyImage image =
            new BodyImage("data/Archer/Archer_idle_Right.gif", 2.8f);





    public Character(World world) {
        super(world, characterShape);
        addImage(image);



    }
    void shootRight(){
        DynamicBody projectile = new DynamicBody(getWorld(),new CircleShape(0.2f));
        projectile.setPosition(this.getPosition().sub(new Vec2(-1.5f,0.5f)));
        BodyImage arrow = new BodyImage("data/Archer/Archer_arrow_Right.png");
        AttachedImage projectileImage = new AttachedImage(projectile,arrow,1,0,new Vec2());
        ProjectileCollision hit = new ProjectileCollision();
        projectile.addCollisionListener(hit);
        //projectile.setLinearVelocity(new Vec2(4,0));
        projectile.setLinearVelocity(new Vec2(7 , 0));
        projectile.setGravityScale(0);

            try {
                arrowSound = new SoundClip("data/Arrow_sound.wav");

            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                System.out.println(e);
            }


    }

    void shootLeft(){
        DynamicBody projectile = new DynamicBody(getWorld(),new CircleShape(0.2f));
        projectile.setPosition(this.getPosition().sub(new Vec2(1.5f,0.5f)));
        BodyImage arrow = new BodyImage("data/Archer/Archer_arrow_Left.png");
        AttachedImage projectileImage = new AttachedImage(projectile,arrow,1,0,new Vec2());
        ProjectileCollision hit = new ProjectileCollision();
        projectile.addCollisionListener(hit);
        projectile.setLinearVelocity(new Vec2(-7,0));
       // projectile.setLinearVelocity(new Vec2(-4 , 0));
        projectile.setGravityScale(0);
        try {
            arrowSound = new SoundClip("data/Arrow_sound.wav");

        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
    }



    public void Respawn() {
        this.returnCharacter();
        setCurrentHealth(currentHealth- 1);



    }
    public void setReturnPosition(Vec2 saveLocation) {
        lastSaveLocation = saveLocation;
    }
    public void returnCharacter() {
        setPosition(lastSaveLocation);
    }





}


