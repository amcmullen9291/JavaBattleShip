package JavaBattleship;

import javax.swing.*;
import java.awt.Color;

public class BattleshipFrame extends JFrame {

    BattleshipPanel panel;

    BattleshipFrame(){
        panel = new BattleshipPanel();
        this.add(panel);
        this.setTitle("Battle Ship");
        this.setResizable(false);
        this.setBackground(Color.BLUE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}
