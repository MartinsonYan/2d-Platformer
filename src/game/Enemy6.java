package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
public class Enemy6 extends Walker implements StepListener{

    private static BodyImage enemy6Image =
            new BodyImage("data/Enemies/Enemy6.gif",4f);
    private static final BoxShape enemy6Shape = new BoxShape(1,2f);

    private final int SPEED = 4;
    private static int isEnemy6Dead = 0;


    private float left, right;

    private final int RANGE = 2;

    public Enemy6(World world) {
        super(world,enemy6Shape);
        addImage(enemy6Image);
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

    public static int getIsEnemy6Dead() {
        return isEnemy6Dead;
    }

    public static void setIsEnemy6Dead(int isEnemy6Dead) {
        Enemy6.isEnemy6Dead = isEnemy6Dead;
    }
}
