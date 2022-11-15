package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private final Controller cont;
    private final JFrame frame = new JFrame();

    /**
     * Class to execute the gui.
     * 
     * @param c controller to use.
     */
    private SimpleGUIWithFileChooser(final Controller c) {
        this.cont = c;
        final JPanel panel = new JPanel(new BorderLayout());
        final JTextArea area = new JTextArea();
        final JButton save = new JButton("Save");
        final JPanel nPanel = new JPanel(new BorderLayout());
        final JButton browse = new JButton("Browse...");
        final JTextField pathF = new JTextField();

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fc = new JFileChooser();
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
            public void actionPerformed(final ActionEvent e) {
                final int n = JOptionPane.showConfirmDialog(frame, "Save?", "Saving", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    try {
                        cont.write(area.getText());
                    } catch (IOException e1) {
                        System.err.println("Error while writing"); // NOPMD
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
        frame.setVisible(true);
    }
    /**
     * To run the Program.
     * 
     * @param args useless.
     */
    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser(new Controller());

    }
}
