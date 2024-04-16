package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Enemy7 extends Walker implements StepListener{
    private static BodyImage enemy7Image =
            new BodyImage("data/Enemies/Enemy7.gif",4f);
    private static final BoxShape enemy7Shape = new BoxShape(1,1f);

    private final int SPEED = 4;
    private static int isEnemy7Dead = 0;


    private float left, right;

    private final int RANGE = 2;

    public Enemy7(World world) {
        super(world,enemy7Shape);
        addImage(enemy7Image);
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

    public static int getIsEnemy7Dead() {
        return isEnemy7Dead;
    }

    public static void setIsEnemy7Dead(int isEnemy7Dead) {
        Enemy7.isEnemy7Dead = isEnemy7Dead;
    }
}
