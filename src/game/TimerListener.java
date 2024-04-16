package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
public class TimerListener implements ActionListener {
    Enemy1 enemy1;
    Enemy2 enemy2;
    Enemy4 enemy4;
    Enemy5 enemy5;
    GameLevel level = Game.getLevel();
    Game game;

    @Override
    public void actionPerformed(ActionEvent e) {
        int levelNum = Game.getLevel().getLevelNum();

        if (levelNum == 1 && enemy1.getIsEnemy1Dead() == 1 && enemy2.getIsEnemy2Dead() == 1) {


                Game.getLevel().setCurrentLevel(2);



        } else if (levelNum == 2 && enemy4.getIsEnemy4Dead() == 1 && enemy5.getIsEnemy5Dead() == 1){
            Game.getLevel().setCurrentLevel(3);
        }

    }

}
