package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Enemy1 extends Walker implements StepListener {

    private static final BodyImage enemy1Image =
            new BodyImage("data/Enemies/Enemy1.gif",2f);
    private static final BoxShape enemy1Shape = new BoxShape(1,1f);

    private final int SPEED = 4;
    private static int isEnemy1Dead = 0;


    private float left, right;

    private final int RANGE = 3;

    public Enemy1(World world) {
        super(world,enemy1Shape);
        addImage(enemy1Image);
        world.addStepListener(this);
        startWalking(SPEED);
    }


    @Override
    public void setPosition(Vec2 position) {
        super.setPosition(position);
        left = position.x-RANGE;
        right = position.x+RANGE;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x > right){
            startWalking(-SPEED);
        }
        if (getPosition().x < left){
            startWalking(SPEED);
        }
    }



    @Override
    public void postStep(StepEvent stepEvent) {

    }
    public static int getIsEnemy1Dead() {
        return isEnemy1Dead;
    }

    public static void setIsEnemy1Dead(int isEnemy1Dead) {
        Enemy1.isEnemy1Dead = isEnemy1Dead;
    }

}
