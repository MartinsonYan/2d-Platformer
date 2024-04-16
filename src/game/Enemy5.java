package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Enemy5 extends Walker implements StepListener{

        private static BodyImage enemy5Image =
                new BodyImage("data/Enemies/Enemy5.gif",2f);
        private static final BoxShape enemy5Shape = new BoxShape(1,1f);

        private final int SPEED = 4;
        private static int isEnemy5Dead = 0;


        private float left, right;

        private final int RANGE = 2;

        public Enemy5(World world) {
            super(world,enemy5Shape);
            addImage(enemy5Image);
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

    public static int getIsEnemy5Dead() {
        return isEnemy5Dead;
    }

    public static void setIsEnemy5Dead(int isEnemy5Dead) {
        Enemy5.isEnemy5Dead = isEnemy5Dead;
    }

    @Override
        public void postStep(StepEvent stepEvent) {

        }
    }


