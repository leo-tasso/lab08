package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.*;
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

    public SimpleGUI(Controller c) {
        this.cont = c;
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea area = new JTextArea();
        JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = JOptionPane.showConfirmDialog(frame, "Save?", "Saving", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    try {
                        cont.write(area.getText());
                    } catch (IOException e1) {
                        System.err.println("Error while writing");
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

    public void display() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI(new Controller()).display();

    }
}
