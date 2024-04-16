package game;

import city.cs.engine.*;

import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Enemy3 extends Walker implements ActionListener  {
    private static final BodyImage enemy3Image =
            new BodyImage("data/Enemies/Enemy3.png", 2f);

    private static final BoxShape enemy3Shape = new BoxShape(0.2f, 0.2f);

    Timer projectileTimer;

    public Enemy3(World world) {
        super(world, enemy3Shape);
        addImage(enemy3Image);
        this.setGravityScale(0);



        projectileTimer = new Timer(3000,this);
        projectileTimer.setInitialDelay(3000);
        projectileTimer.start();



    }

    public void enemy3Projectile() {
        Character character = Game.getLevel().character;
        double pos = this.position(character.getPosition(), this.getPosition());
        setAngle((float) pos);
        Timer shooting = new Timer(200,new projectile(this,pos));
        shooting.setInitialDelay(200);
        shooting.start();

    }

    public double position(Vec2 characterPos, Vec2 currentCharacterPos) {
        double X = characterPos.x - currentCharacterPos.x;
        double Y = characterPos.y - currentCharacterPos.y;
        return (Math.atan2(Y, X));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    enemy3Projectile();
    }



}
class projectile implements ActionListener{
    Enemy3 enemy3;
    double pos;

public projectile(Enemy3 enemy3, double angle){
this.enemy3= enemy3;
this.pos = angle;
}
        @Override
        public void actionPerformed(ActionEvent e) {
        DynamicBody projectile= new DynamicBody(enemy3.getWorld(),new BoxShape(0.2f ,0.5f));
        BodyImage fireball = new BodyImage("data/Enemies/enemy3_attack.gif");
        projectile.setPosition(new Vec2((float) (2 * Math.cos(pos)), (float) (2 * Math.sin(pos))));
        AttachedImage projectileImage = new AttachedImage(projectile,fireball,1,0,new Vec2());
        projectile.setGravityScale(0);
        fireballCollision hit = new fireballCollision();
        projectile.addCollisionListener(hit);
        projectile.setAngle((float) (pos + Math.PI / 2));
        projectile.setLinearVelocity(new Vec2((float) Math.cos(pos) * 15,  (float) Math.sin(pos) * 15));
        Timer timer =(Timer) e.getSource();
    timer.stop();
    }
}
