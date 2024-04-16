package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Enemy4 extends Walker implements StepListener {
    Enemy4 enemy4;
    private static BodyImage enemy4Image =
            new BodyImage("data/Enemies/Enemy4_right.gif",2f);
    private static final BoxShape enemy4Shape = new BoxShape(1,1f);

    private final int SPEED = 4;
    private static int isEnemy4Dead = 0;


    private float left, right;

    private final int RANGE = 2;

    public Enemy4(World world) {
        super(world,enemy4Shape);
        addImage(enemy4Image);
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

    public static int getIsEnemy4Dead() {
        return isEnemy4Dead;
    }

    public static void setIsEnemy4Dead(int isEnemy4Dead) {
        Enemy4.isEnemy4Dead = isEnemy4Dead;
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }

}
