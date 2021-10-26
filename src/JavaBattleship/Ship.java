package JavaBattleship;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class Ship extends Rectangle {

    int id;
    Graphics g;
    static int Scorecard;

    Ship(int xAxis, int yAxis, int width, int height, int id) {
        super(xAxis, yAxis, width, height);
        this.id = id;
    }
    public void keyPressed(KeyEvent e){

    }

    public void keyReleased(KeyEvent e){

    }

    public void draw(Graphics g) {
        g.fillRect(x,y,width,height);
    }
}