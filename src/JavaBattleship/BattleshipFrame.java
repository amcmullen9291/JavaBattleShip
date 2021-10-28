package JavaBattleship;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

//@SuppressWarnings("serial")
public class BattleshipFrame extends JPanel implements ActionListener {
    private static final int SML_SIDE = 3;
    private static final int SIDE = SML_SIDE * SML_SIDE;
    private static final int GAP = 3;
    private static final Color BG = Color.BLACK;
    private static final Dimension BTN_PREF_SIZE = new Dimension(60, 60);
    private JButton[][] buttons = new JButton[SIDE][SIDE];
    Point point;
    static int placements;
    //    ActionListener click;
//    BattleshipFrame targetButton;
    static String[] locations;

    public BattleshipFrame() {
        Border border = new LineBorder(Color.RED, 13);
        Border border2 = new LineBorder(Color.decode("#03fc98"), 13);

        JFrame instructions = new JFrame();
        JButton theRules = new JButton("<html><u>Find the Fleet:</u><br><br>Carrier - 5 Spaces<br>Battleship" +
                " - 4 Spaces<br>Destroyer - 3 Spaces<br>Submarine - 2 Spaces<br>Patrol Boat - 1 Spaces<br><br> Choose a cell to get started.</html>");
        theRules.setBorder(border);
        instructions.setVisible(true);
        instructions.setLocation(0,0);
        instructions.setSize(390, 300);
        theRules.setBackground(Color.BLUE);
        theRules.setForeground(Color.WHITE);
        theRules.setBounds(5, 5, 50, 30);
        theRules.setFont(new Font("Arial", Font.PLAIN, 16));
        instructions.add(theRules);

        JFrame motivation = new JFrame();
        JButton theTalk = new JButton("<html><c> ' Players approach the game as essentially <b>one of chance</b>;" +
                "   targeting squares at random and hoping for a “hit.” " +
                "   But, <u><i>is there a better strategy</i></u> ? '</c><html>");
        motivation.setVisible(true);
        motivation.setLocation(0,300);
        motivation.setSize(390,300);
        theTalk.setBounds(5, 5, 50, 30);
        theTalk.setBorder(border2);
        motivation.add(theTalk);
        theTalk.setFont(new Font("Arial", Font.PLAIN, 16));
        //Main window below
        setBackground(Color.decode("#03fc98"));
//        setForeground(Color.decode("#03fc98"));
        setLayout(new GridLayout(SML_SIDE, SML_SIDE, GAP, GAP));
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        JPanel[][] smallPanels = new JPanel[SML_SIDE][SML_SIDE];
        for (int i = 0; i < smallPanels.length; i++) {
            for (int j = 0; j < smallPanels[i].length; j++) {
                smallPanels[i][j] = new JPanel(new GridLayout(SML_SIDE, SML_SIDE));
                add(smallPanels[i][j]);
            }
        }
        for (int i = 0; i < buttons.length; i++) {
            int panelI = i / SML_SIDE;
            for (int j = 0; j < buttons[i].length; j++) {
                int panelJ = j / SML_SIDE;
                String text = String.format("[%d,%d]", j,i);
                buttons[i][j] = new JButton(text);
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 12));
                buttons[i][j].setPreferredSize(BTN_PREF_SIZE);
                buttons[i][j].addActionListener(this);
                smallPanels[panelI][panelJ].add(buttons[i][j]);
            }
        }
    }

    private static void createAndShowGui() {
        BattleshipFrame mainPanel = new BattleshipFrame();

        JFrame frame = new JFrame("Java: Battleship");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
        solutionPlacement();
        System.out.println("Solution " + placements + " running.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
//        double testCorrectGuess = Math.random();

        if (source instanceof Component) {
            if(true) {
//                ((Component) source).setBackground(Color.RED);
                Object O = e.getSource();
                JButton b = null;
                String buttonText = "";
                b = (JButton)O;
                choice(b.getText());
                String[] chosenSolution = {"[0,0]", "[5,1]", "[0,1]", "[0,4]", "[0,2]"}; //test case
                String[] solution = new String[5];
                System.arraycopy(chosenSolution, 0, solution,0,5);
                //use switch statement to copy switchCase array to solution[]
                //use static int placements for switch

//                System.out.println(b.getText().getClass().getSimpleName());
                for(int w=0; w<solution.length; w++){
                    if(b.getText().contentEquals(solution[w])) {
                        ((Component) source).setBackground(Color.RED);
                        return;
                    }
                    if (!b.getText().contentEquals(solution[w])){
                        ((Component) source).setBackground(Color.BLUE);
                    }
                };
            }
        }
    }
    public void choice(String result){
        System.out.println("That was " + result);
    }
    public static void solutionPlacement(){
        placements = (int)(Math.random()*9-1)+1;
//        switch(placements){
//            case 1:
//                String[] locations = {"[0,0]", "[0,1]", "[1,0]", "[1,1]", "[1,2]"};
//        }
    }
}