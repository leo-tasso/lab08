package it.unibo.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private final Controller cont;
    private final JFrame frame = new JFrame();

    public SimpleGUIWithFileChooser(Controller c) {
        this.cont = c;
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea area = new JTextArea();
        JButton save = new JButton("Save");
        JPanel nPanel = new JPanel(new BorderLayout());
        JButton browse = new JButton("Browse...");
        JTextField pathF = new JTextField();

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                final int result = fc.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    cont.setFile(fc.getSelectedFile());
                    pathF.setText(cont.getPath());
                } else if (result != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(frame, "Error choosing the file");
                }

            }
        });

        pathF.setText(cont.getPath());
        pathF.setEditable(false);
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
        nPanel.add(pathF, BorderLayout.CENTER);
        nPanel.add(browse, BorderLayout.EAST);
        panel.add(nPanel, BorderLayout.NORTH);
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
        new SimpleGUIWithFileChooser(new Controller()).display();

    }
}
