import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
    public static void main(String[] args) {

            System.out.println("Hello world!");

            JTextField smallField = new JTextField("300, 250, 25, 45, 20");
            JTextField numbers = new JTextField("0, 1, 2, 3, 4, 5, 6, 7, 8, 9");

            numbers.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    String[] parm = smallField.getText().replaceAll(" ",
                              " ").split(",");
                    int[] koords = new int[parm.length];
                    if (parm.length != parm.length) {
                        //отображение введенного текста
                        JOptionPane.showMessageDialog(null, 
                        "Ошибка в количестве параметров");
                    }

                }

            });

            JFrame f = new JFrame("Swing Paint Demo");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));

            //Создание панели с текстовыми полями
            contents.add(numbers);
            contents.add(smallField);
            f.setContentPane(contents);

            MyPanel myPanel = new MyPanel();
            myPanel.setSymbols("1, 2, 3");
            f.add(myPanel);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);

        }
    }