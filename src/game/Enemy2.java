package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Enemy2 extends Walker implements StepListener {
    private static final BodyImage enemy2Image =
            new BodyImage("data/Enemies/Enemy2.gif",2f);
    private static final BoxShape enemy2Shape = new BoxShape(1,1f);

    private final int SPEED = 4;
    private static int isEnemy2Dead = 0;
    private float left, right;

    private final int RANGE = 1;
    public Enemy2(World world) {
        super(world,enemy2Shape);
        addImage(enemy2Image);
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

    public static int getIsEnemy2Dead() {
        return isEnemy2Dead;
    }

    public static void setIsEnemy2Dead(int isEnemy2Dead) {
        Enemy2.isEnemy2Dead = isEnemy2Dead;
    }
}
