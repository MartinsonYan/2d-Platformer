package game;

import city.cs.engine.UserView;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {
 GameLevel Level;
private Image background;



    private final Image background3 = new ImageIcon("data/Background3.png").getImage();


    public GameView(GameLevel world, int width, int height) {
        super(world,width , height);
        background = new ImageIcon("data/Tiles/Assets/Background_2.png").getImage();


        }
    @Override
    protected void paintBackground(Graphics2D g) {


            g.drawImage(background, 0, 0, 500, 500, this);




    }
    public void setBackground(Image levelBackground){
    background = levelBackground;
    }
   @Override
    protected void paintForeground(Graphics2D g) {
        int hp =Game.getLevel().character.getCurrentHealth();

        g.drawImage(new ImageIcon("data/health/health_"+ hp +".png").getImage(), 10, 0, this);
    }
}
