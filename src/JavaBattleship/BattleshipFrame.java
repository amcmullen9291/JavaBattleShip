package JavaBattleship;

import javax.swing.*;
import java.awt.*;

public class BattleshipFrame extends JFrame {

    BattleshipPanel panel;

    BattleshipFrame(){
        panel = new BattleshipPanel();
        this.add(panel);
        this.setTitle("Battleship");
        this.setResizable(false);
        this.setBackground(Color.decode("#03fc98"));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }




}
