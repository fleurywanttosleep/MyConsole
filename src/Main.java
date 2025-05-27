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

        JTextField smallField = new JTextField("300, 450, 25, 45, 20");
        JTextField numbers = new JTextField("0, 1, 2, 3, 4, 5, 6, 7, 8, 9");
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));

        //Создание панели с текстовыми полями
        contents.add(numbers);
        contents.add(smallField);
        f.setContentPane(contents);

        // Создаем MyPanel один раз в начале
        MyPanel myPanel = new MyPanel();
        myPanel.setSymbols("1, 2, 3");
        f.add(myPanel); // Добавляем myPanel в окно
        f.pack(); //  Вызываем pack перед setLocationRelativeTo()
        f.setLocationRelativeTo(null);
        f.setVisible(true); //Делаем видимым в конце.


        numbers.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String[] parm = smallField.getText().replaceAll(" ", " ").split(",");
                int[] koords = new int[parm.length];

                if (parm.length != 5) {
                    JOptionPane.showMessageDialog(null, "Ошибка в количестве параметров");
                    return; // Выходим, если неверное количество параметров
                }

                try {
                    for (int i = 0; i < parm.length; i++) {
                        koords[i] = getInteger(parm[i]); // Преобразуем в числа
                    }

                    // Устанавливаем параметры для myPanel
                    myPanel.setX(koords[0]);
                    myPanel.setY(koords[1]);
                    myPanel.setWidth(koords[2]);
                    myPanel.setHeight(koords[3]);
                    myPanel.setStep(koords[4]);
                    myPanel.setSymbols(numbers.getText());
                    myPanel.repaint(); //Перерисовываем панель, чтобы показать результат

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ошибка: Неверный формат чисел");
                }
            }
        });
    }

    private static int getInteger(String parm) {
        try {
            return Integer.parseInt(parm.trim());
        } catch (NumberFormatException e) {
            // Обрабатываем исключение NumberFormatException
            return 0; //Возвращаем значение по умолчанию
        }
    }
}