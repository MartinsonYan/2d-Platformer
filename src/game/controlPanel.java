package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlPanel {
    private JButton restartGameButton;
    private JPanel mainPanel;

    private GameView gameView;
    GameLevel level;
    public controlPanel(GameView gameView){
        this.gameView =  gameView;

        restartGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.getLevel().setCurrentLevel(1);
                Image background1 = new ImageIcon("data/Tiles/Assets/Background_2.png").getImage();
                Game.getGameView().setBackground(background1);
                Enemy1.setIsEnemy1Dead(0);
                Enemy2.setIsEnemy2Dead(0);
                Enemy4.setIsEnemy4Dead(0);
                Enemy5.setIsEnemy5Dead(0);
                Enemy6.setIsEnemy6Dead(0);
                Enemy7.setIsEnemy7Dead(0);
            }
        });
    }

    public JPanel getMainPanel(){
        return mainPanel;
    }
}