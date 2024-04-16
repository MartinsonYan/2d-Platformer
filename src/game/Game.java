package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Your main game entry point
 */
public class Game {
    private static GameLevel level;
    private static Enemy1 enemy1;
    private static Enemy2 enemy2;

    private  static GameView gameView;
private CharacterController controller;
    private SoundClip gameMusic;


    /** Initialise a new Game. */
    public Game() {

        //1. make an empty game world
        //World world = new World();
        // World world = new World();
        //GameWorld world = new GameWorld();
        Level1 gameLevel = new Level1();
        level = new GameLevel();
        gameView = new GameView(gameLevel,500,500);
        level.createLevel(gameView,1);

       try {
            gameMusic = new SoundClip("data/music.wav");   // Open an audio input stream
            gameMusic.loop();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }


        //code that creates bodies was moved
        //in the GameWorld constructor



        //2. populate it with bodies (ex: platforms, collectibles, characters)

        /*make a ground platform
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(world, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

         //make a suspended platform
        Shape platformShape = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(world, platformShape);
        platform1.setPosition(new Vec2(-8, -4f));

        //make a character (with an overlaid image)
        Student student = new Student(world);
        student.setPosition(new Vec2(7, -9));
        student.setCredits(15);*/


        //3. make a view to look into the game world
        // UserView view = new UserView(world, 500, 500);
        //gameView =new GameView(level,500,500);



        //optional: draw a 1-metre grid over the view
        // view.setGridResolution(1);


        //4. create a Java window (frame) and add the game
        //   view to it
        final JFrame frame = new JFrame("City Game");
        frame.add(gameView);
        controlPanel buttons = new controlPanel(gameView);
        frame.add(buttons.getMainPanel(), BorderLayout.SOUTH);


        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
        // JFrame debugView = new DebugViewer(gameLevel, 500, 500);

        // start our game world simulation!
        //level.start();

        gameView.requestFocus();
        TimerListener listener = new TimerListener();
        Timer timer = new Timer(5000,listener);

        // start the timer
        timer.start();





    }
    public static GameLevel getLevel() {
        return level;
    }
    public static GameView getGameView() {
        return gameView;
    }



    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
