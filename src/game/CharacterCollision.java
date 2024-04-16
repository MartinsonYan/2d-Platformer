package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class CharacterCollision implements CollisionListener {
//private final Enemy1 enemy1;
//public CharacterCollision(Enemy1 e1){ enemy1 = e1;}

    @Override
    public void collide(CollisionEvent a){
        if (a.getOtherBody() instanceof Character) {
            ((Character) a.getOtherBody()).Respawn();
        }
    }
}
