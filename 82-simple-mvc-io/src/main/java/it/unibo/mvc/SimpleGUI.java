package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private final Controller cont;
    private final JFrame frame = new JFrame();

    /**
     * constructor.
     * 
     * @param c controller to operate.
     */
    private SimpleGUI(final Controller c) {
        this.cont = c;
        final JPanel panel = new JPanel(new BorderLayout());
        final JTextArea area = new JTextArea();
        final JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final int n = JOptionPane.showConfirmDialog(frame, "Save?", "Saving", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    try {
                        cont.write(area.getText());
                    } catch (IOException e1) {
                        System.err.println("Error while writing"); //NOPMD
                    }
                }
            }
        });
        panel.add(area, BorderLayout.CENTER);
        panel.add(save, BorderLayout.SOUTH);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        frame.setLocationByPlatform(true);
    }

    /**
     * displays the output window.
     */
    public void display() {
        frame.setVisible(true);
    }

    /**
     * Executes the program.
     * 
     * @param args useless.
     * 
     */
    public static void main(final String[] args) {
        new SimpleGUI(new Controller()).display();

    }
}
