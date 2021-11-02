package JavaBattleship;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    static int placement;
    static int coordinatesLeft = 17;

    public BattleshipFrame() {
        Border border = new LineBorder(Color.RED, 13);
        Border border2 = new LineBorder(Color.decode("#03fc98"), 13);

        JFrame instructions = new JFrame();
        JButton theRules = new JButton("<html><u>Find the Fleet:</u><br><br>Carrier - 5 Spaces<br>Battleship" +
                " - 4 Spaces<br>Destroyer - 3 Spaces<br>Submarine - 3 Spaces<br>Patrol Boat - 2 Spaces<br><br> Let's begin.</html>");
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
                String text = String.format("[%d,%d]", i,j);
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
        System.out.println("Solution " + placement + " running.");
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
                String[] solution = new String[17];
                switch(placement) {
                    case 1:
                        String[] chosenSolution1 = {"[8,4]", "[8,5]", "[1,2]", "[1,3]", "[1,4]", "[0,8]", "[1,8]", "[2,8]", "[3,1]", "[4,1]", "[5,1]", "[6,1]", "[7,1]", "[3,3]", "[3,4]", "[3,5]", "[3,6]"};
                        System.arraycopy(chosenSolution1, 0, solution, 0, 17);
                        break;
                    case 2:
                        String[] chosenSolution2 = {"[0,6]", "[0,7]", "[3,0]", "[3,1]", "[3,2]", "[3,3]", "[6,7]", "[7,7]", "[8,7]", "[3,7]", "[4,7]", "[5,7]", "[8,0]", "[8,1]", "[8,2]", "[8,3]", "[8,4]"};
                        System.arraycopy(chosenSolution2, 0, solution, 0, 17);
                        break;
                    case 3:
                        String[] chosenSolution3 = {"[0,3]", "[0,4]", "[0,5]", "[0,6]", "[2,5]", "[2,6]", "[2,7]", "[2,8]", "[2,4]", "[4,3]", "[4,4]", "[4,5]", "[6,4]", "[7,4]", "[8,4]", "[8,2]", "[8,3]"};
                        System.arraycopy(chosenSolution3, 0, solution, 0, 17);
                        break;
                    case 4:
                        String[] chosenSolution4 = {"[0,0]", "[0,1]", "[0,5]", "[0,6]", "[0,7]", "[1,4]", "[1,5]", "[1,6]", "[4,5]", "[4,6]", "[4,7]", "[4,4]", "[7,0]", "[7,1]", "[7,2]", "[7,3]", "[7,4]"};
                        System.arraycopy(chosenSolution4, 0, solution, 0, 17);
                        break;
                    case 5:
                        String[] chosenSolution5 = {"[1,1]", "[1,2]", "[1,3]", "[3,1]", "[3,2]", "[4,5]", "[4,6]", "[4,7]", "[2,0]", "[2,1]", "[2,2]", "[2,3]", "[2,4]", "[6,5]", "[6,6]", "[6,7]", "[6,8]"};
                        System.arraycopy(chosenSolution5, 0, solution, 0, 17);
                        break;
                    default:
                        String[] chosenSolutionDefault = {"[0,1]", "[0,2]", "[0,3]", "[0,4]", "[0,6]", "[0,5]", "[0,7]","[2,1]", "[2,2]", "[2,3]", "[2,4]", "[2,6]", "[2,5]", "[2,7]", "[2,8]", "[8,7]" ,"[8,6]"}; //test case
                        System.arraycopy(chosenSolutionDefault, 0, solution, 0, 17);

                }
                for(int w=0; w<solution.length; w++){
                    if(b.getText().contentEquals(solution[w])) {
                        ((Component) source).setBackground(Color.RED);
                        ((Component) source).setEnabled(false);
                        coordinatesLeft-=1;
                        if(coordinatesLeft ==0){
                            JFrame congrats = new JFrame("Congratulations");
                            JButton newGame = new JButton("You win.");
                            newGame.setBackground(Color.WHITE);
                            newGame.setForeground(Color.BLACK);
                            newGame.setFont(new Font("Arial", Font.PLAIN, 18));
                            newGame.setEnabled(false);
                            congrats.setSize(550,150);
                            congrats.setLocation(570,270);
                            congrats.add(newGame);
                            congrats.setVisible(true);
                        }
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
        placement = (int)(Math.random()*6-1)+1;
    }
}