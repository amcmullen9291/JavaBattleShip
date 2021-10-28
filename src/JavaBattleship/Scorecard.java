package JavaBattleship;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Scorecard {

    int movesUsed = 0;
    int movesAvailable = 35;

    Scorecard(){
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Georgia", Font.BOLD,18));
        g.drawString("Moves used: " + movesUsed, 0,25);
        g.drawString("Moves Remaining: " + (movesAvailable-movesUsed)+ " units lefts",0,45);
    }

}
