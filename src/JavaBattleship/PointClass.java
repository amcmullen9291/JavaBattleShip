package JavaBattleship;
import java.awt.Point;

public class PointClass {

    public int x;
    public int y;
    static PointClass point;
    static String[] positions;

    public PointClass (){

        System.out.println(point + "Solution created.");
    }
    static int coinToss = (int)(Math.random()*9-1)+1;
    public void randomPlacement(int coinToss){
        switch (coinToss){
            case 1:
                positions = new String[]{"[2,4]", "[0,9]"};
        }
    }
}
