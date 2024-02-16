package rinthaisong.trin.lab8;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class PlayerFormV5 extends PlayerFormV4 {
    protected ImageIcon Newitem;
    protected ImageIcon Openitem;
    protected ImageIcon Saveitem;
    protected ImageIcon footballItem;

    public PlayerFormV5(String title) {
        super(title);
        Newitem = new ImageIcon(getClass().getResource("New-icon.png"));
        Openitem = new ImageIcon(getClass().getResource("Open-icon.png"));
        Saveitem = new ImageIcon(getClass().getResource("Save-icon.png"));
        fileMenuNew = new JMenuItem("New", Newitem);
        fileMenuOpen = new JMenuItem("Open", Openitem);
        fileMenuSave = new JMenuItem("Save", Saveitem);
        footballItem = new ImageIcon(getClass().getResource("Football.jpg"));
    }

    public static void createAndShowGUI() {
        PlayerFormV5 msw = new PlayerFormV5("Athlete Form V5");
        msw.addComponents();
        msw.setJMenuBar(msw.menuBar);// เรียกใช้ menu bar
        msw.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }
}
