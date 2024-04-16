package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class fireballCollision implements CollisionListener {
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Character) {
            ((Character) collisionEvent.getOtherBody()).Respawn();
            collisionEvent.getReportingBody().destroy();
        } else {
            collisionEvent.getReportingBody().destroy();
        }
        }
    }

