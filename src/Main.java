import java.awt.Component;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {

            System.out.println("Hello world!");

            JFrame f = new JFrame("Me Panel");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Component MyPanel = new MyPanel();
           
            f.add(MyPanel);
            f.pack();
            
            f.setVisible(true);

        }
    }