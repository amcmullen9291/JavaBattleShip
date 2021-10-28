//package JavaBattleship;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

//public class BattleshipPanel extends JPanel implements Runnable {

//    static final int GAME_WIDTH = 600;
//    static final int GAME_HEIGHT = 400;
//    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
//    public static int aircraftCarrierX; //length=5
//    public static int battleShipX; //length=4
//    public static int destroyerX; //length=3
//    public static int submarineX; //length=3
//    public static int patrolBoatX; //length=
//    public static int aircraftCarrierY; //length=5
//    public static int battleShipY; //length=4
//    public static int destroyerY; //length=3
//    public static int submarineY; //length=3
//    public static int patrolBoatY; //length=2

//    Ship airCraftCarrier;
//    Ship battleShip;
//    Ship destroyer;
//    Ship submarine;
//    Ship patrolBoat;
//    Ship captain;
//    Image image;
//    Random random;
//    Scorecard score;
//    Graphics graphics;

//    BattleshipPanel() {
//        newGame();
//        this.setFocusable(true); //able to read keystrokes
//        this.addKeyListener(new ActionListener());
//        this.setPreferredSize(SCREEN_SIZE);
//    }

//    public void directHit() {
//    int aircraftCarrierX = (int)airCraftCarrier.getX();
//    int aircraftCarrierY = (int)airCraftCarrier.getY();
//        int battleShipX = (int)battleShip.getX();
//        int battleShipY = (int)battleShip.getY();
//        int destroyerX = (int)destroyer.getX();
//        int destroyerY = (int)destroyer.getY();
//        int submarineX = (int)submarine.getX();
//        int submarineY = (int)submarine.getY();
//        int patrolBoatX = (int)patrolBoat.getX();
//        int patrolBoatY = (int)patrolBoat.getY();
//    }

//    public void newGame(){
//        board = new GameBoard();
//        airCraftCarrier = new Ship();
//        battleShip = new Ship();
//        destroyer = new Ship();
//        submarine = new Ship();
//        patrolBoat = new Ship();
//        captain = new Ship();
//    }
//    public void paint(Graphics g) {
//        image = createImage(getWidth(), getHeight());
//        graphics = image.getGraphics();
//        draw(graphics);
//        g.drawImage(image,0, 0,this);
//    }

//    public void draw(Graphics g) {
//        patrolBoat.draw(g);
//        submarine.draw(g);
//        airCraftCarrier.draw(g);
//        destroyer.draw(g);
//        battleShip.draw(g);
//    }


//    public void checkContact() {
//    }
//
//    public void run(){
//        long lastTime = System.nanoTime();
//        double amountOfTicks = 60;
//        double ns = 1000000000/amountOfTicks;
//        double delta = 0;
//        while(true){
//            long now = System.nanoTime();
//            delta += (now-lastTime)/ns;
//            lastTime = now;
//            if(delta>=1){
//                checkContact();
//                repaint();
//                delta--;
//            }
//        }
//    }
//    public class ActionListener extends KeyAdapter {
//        public void keyPressed(KeyEvent e) {
//        }
//    }
//
//}
