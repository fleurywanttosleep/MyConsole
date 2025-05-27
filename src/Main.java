import java.awt.Component;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {

            System.out.println("Hello world!");

            JFrame f = new JFrame("Me Panel");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            MyPanel myPanel = new MyPanel();
            myPanel.setSymbols("1, 2, 3");
            f.add(myPanel);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);

        }
    }
    