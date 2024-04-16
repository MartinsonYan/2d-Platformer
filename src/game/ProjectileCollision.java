package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class ProjectileCollision implements CollisionListener {
    Enemy1 enemy1;
    Enemy2 enemy2;
    Enemy4 enemy4;
    Enemy5 enemy5;
    Enemy6 enemy6;
    Enemy7 enemy7;

    @Override
    public void collide(CollisionEvent a) {
        if (a.getOtherBody() instanceof Enemy1) {
            a.getOtherBody().destroy();
            a.getReportingBody().destroy();
            enemy1.setIsEnemy1Dead(1);
            System.out.println(enemy1.getIsEnemy1Dead());

        } else if (a.getOtherBody() instanceof Enemy2) {
            a.getOtherBody().destroy();
            a.getReportingBody().destroy();
            enemy2.setIsEnemy2Dead(1);
            System.out.println(enemy2.getIsEnemy2Dead());

        } else if (a.getOtherBody() instanceof Enemy4){
            a.getOtherBody().destroy();
            a.getReportingBody().destroy();
            enemy4.setIsEnemy4Dead(1);
        } else if (a.getOtherBody() instanceof Enemy5){
            a.getOtherBody().destroy();
            a.getReportingBody().destroy();
            enemy5.setIsEnemy5Dead(1);
        }  else if (a.getOtherBody() instanceof Enemy6) {
            a.getOtherBody().destroy();
            a.getReportingBody().destroy();
            enemy6.setIsEnemy6Dead(1);
        } else if (a.getOtherBody() instanceof Enemy7) {
            a.getOtherBody().destroy();
            a.getReportingBody().destroy();
            enemy7.setIsEnemy7Dead(1);
        }
        else {
            a.getReportingBody().destroy();
        }
    }
}
