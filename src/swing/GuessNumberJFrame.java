package swing;

import home.MathUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GuessNumberJFrame extends JFrame {
    private int x = 0;
    private int number = 0;
    private int attempts = 0;

    public GuessNumberJFrame() {

        setTitle("Guess number Game");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);


        JLabel label1 = new JLabel("From:");
        JTextField field1 = new JTextField("0");
        label1.setBounds(40, 70, 90, 20);
        field1.setBounds(40, 90, 90, 20);
        add(label1);
        add(field1);

        JLabel label2 = new JLabel("to:");
        JTextField field2 = new JTextField("10");
        add(label2);
        label2.setBounds(170, 70, 120, 20);
        field2.setBounds(170, 90, 120, 20);
        add(label2);
        add(field2);

        JLabel label3 = new JLabel("Yor number:");
        JTextField field3 = new JTextField();
        add(label3);
        label3.setBounds(170, 130, 120, 20);
        field3.setBounds(170, 150, 120, 20);
        add(label3);
        add(field3);
        label3.setVisible(false);
        field3.setVisible(false);


        JLabel label4 = new JLabel("attempts:");
        JTextField field4 = new JTextField("3");
        label4.setBounds(270, 130, 120, 20);
        field4.setBounds(300, 150, 120, 20);
        add(label4);
        add(field4);
//                label4.setVisible(false);
//                field4.setVisible(false);

        JButton button = new JButton();
        button.setText("Generate");
        button.setSize(120, 20);
        add(button);
        button.setLocation(40, 140);

        JButton button1 = new JButton();
        button1.setText("GO");
        button1.setSize(120, 20);
        add(button1);
        button1.setLocation(240, 240);
        button1.setVisible(false);

        JButton button2 = new JButton();
        button2.setText("RESTART");
        button2.setSize(120, 20);
        add(button2);
        button2.setLocation(240, 340);
        button2.setVisible(false);

        JLabel msg = new JLabel();
        msg.setBounds(200, 110, 320, 20);
        add(msg);

        setVisible(true);

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attempts = Integer.parseInt(field4.getText());
//                while (attempts > 0) {
//                    attempts--;
//                }
                if (attempts > 0) {
   //                 int number = Integer.parseInt(field3.getText());
                } else {
                    if (attempts == 1) {
                        msg.setText("You loose!");
                    }
                }
                int from = Integer.parseInt(field1.getText());
                int to = Integer.parseInt(field2.getText());
                int x = MathUtil.genRandom(from, to);


                System.out.println(x);
                field1.setEditable(false);
                field2.setEditable(false);
       //         button.setVisible(false);
                button.setEnabled(false);

                msg.setText("Random value generated!");

                label3.setVisible(true);
                field3.setVisible(true);
                button1.setVisible(true);
                attempts--;
                field4.setText(attempts + " ");

            }
        });

        button1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                msg.setVisible(false);
                int number = Integer.parseInt(field3.getText());
                if (number == x) {
                    msg.setText("Right");
                } else {
                    System.out.println("No!");
                    if (x > number) {
                        System.out.println("You number < random number");
                    } else {
                        System.out.println("You number > random number");
                    }
                    msg.setText("Your number is" + (number > x ? " greater " : " less "));
                }
                button2.setVisible(true);
            }
        });

        System.out.println(x);

        button2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field1.setEditable(true);
                field2.setEditable(true);
                field3.setVisible(true);
                button.setVisible(true);
                button.setEnabled(true);
                button1.setVisible(true);

                button2.setVisible(false);
                msg.setText("");

            }
        });
    }
}

class Player {
    public static void main(String[] args) {
        GuessNumberJFrame game = new GuessNumberJFrame();


    }
}