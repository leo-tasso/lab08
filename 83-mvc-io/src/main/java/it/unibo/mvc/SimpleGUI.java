package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int HEIGHT = 500;
    private static final int WITH = 500;
    /**
     *
     */
    private static final String SHOW_HISTORY = "Show history";
    private static final String PRINT = "Print";
    private final Controller controller;
    private final JFrame frame = new JFrame();

    /**
     * constructor, starts the gui.
     * 
     * @param c to set the controller
     */
    @SuppressFBWarnings()
    public SimpleGUI(final Controller c) {
        controller = c; 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JPanel(new BorderLayout()));
        final JTextField field = new JTextField();
        final JTextArea area = new JTextArea();
        area.setEditable(false);
        final JButton print = new JButton(PRINT);
        final JButton history = new JButton(SHOW_HISTORY);
        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setnext(field.getText());
                controller.print();
            }

        });
        history.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                area.setText(controller.getHistory().toString());
            }

        });
        final JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER));
        south.add(print);
        south.add(history);
        frame.getContentPane().add(field, BorderLayout.NORTH);
        frame.getContentPane().add(area, BorderLayout.CENTER);
        frame.getContentPane().add(south, BorderLayout.SOUTH);
        frame.setSize(WITH, HEIGHT);
        frame.setResizable(false);
        frame.setVisible(true);
    }
/**
 * to run the program.
 * @param args unused.
 */
    public static void main(final String[] args) {
        new SimpleGUI(new SimpleController());
    }
}
