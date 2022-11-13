package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    /**
     *
     */
    private static final String SHOW_HISTORY = "Show history";
    private static final String PRINT = "Print";
    private final Controller controller;
    private final JFrame frame = new JFrame();

    public SimpleGUI(Controller c) {
        this.controller = c;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JPanel(new BorderLayout()));
        JTextField field = new JTextField();
        JTextArea area = new JTextArea();
        area.setEditable(false);
        JButton print = new JButton(PRINT);
        JButton history = new JButton(SHOW_HISTORY);
        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setnext(field.getText());
                controller.print();
            }

        });
        history.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                area.setText(controller.getHistory().toString());
            }

        });
        JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER));
        south.add(print);
        south.add(history);
        frame.getContentPane().add(field, BorderLayout.NORTH);
        frame.getContentPane().add(area, BorderLayout.CENTER);
        frame.getContentPane().add(south, BorderLayout.SOUTH);
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI(new SimpleController());
    }
}
