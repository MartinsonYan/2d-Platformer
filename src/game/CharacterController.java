package game;

import city.cs.engine.BodyImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class CharacterController implements KeyListener {
    Character character;
    float speed;
    int left = 0;
    static int isShootKeyPressed = 0;


    public CharacterController(Character character) {
        this.character = character;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_A) {
            character.startWalking(-5);
            left = 1;
            character.removeAllImages();
            character.addImage(new BodyImage("data/Archer/Archer_run_Left.gif",2.8f));
        } else if (code == KeyEvent.VK_D) {
            character.startWalking(5);
            left = 0;
            character.removeAllImages();
            character.addImage(new BodyImage("data/Archer/Archer_run_Right.gif",2.8f));

        } else if (code == KeyEvent.VK_W) {
            character.jump(12);
        }

        }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_A) {
            character.startWalking(0);
            character.removeAllImages();
            character.addImage(new BodyImage("data/Archer/Archer_idle_Left.gif", 2.8f));

        } else if (code == KeyEvent.VK_D) {
            character.startWalking(0);
            character.removeAllImages();
            character.addImage(new BodyImage("data/Archer/Archer_idle_Right.gif", 2.8f));

        } else if (code == KeyEvent.VK_J) {
            if (left == 0) {
             character.shootRight();


            } else if (left == 1) {
                character.shootLeft();


            }
        }
    }
}

