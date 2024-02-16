package rinthaisong.trin.lab8;

/**
 * This program is PlayerFormV3
 * Show a window, titled "Player Form V4"
 * This program displays results similar to PlayerFormV2.
 * the program will show hobbies, ports and years experience in Various formats
 * Author: Trin Rinthaisong
 * ID: 653040448-3
 * Sec: 2
 * Date: 16/2/2024
 **/
import javax.swing.*;
import java.awt.*;

public class PlayerFormV4 extends PlayerFormV3 {
    protected JPanel hobbiesPanel, sportPanel, experiencePanel, mainPanel2, cBoxPanel;
    protected JLabel hobbiesLabel, sportLabel, experienceLabel;
    protected JCheckBox readingCheckBox, browsingCheckBox, sleepingCheckBox, travelingCheckBox;
    protected JList<String> sportList;
    protected JScrollPane sportScrollPane;
    protected JSlider experienceSlider;
    protected ButtonGroup hButtonGroup;

    public PlayerFormV4(String title) {
        super(title);
    }

    @Override
    protected void initComponents() {
        super.initComponents();
        // Hobbies components
        hobbiesPanel = new JPanel();
        cBoxPanel = new JPanel(new FlowLayout());
        hButtonGroup = new ButtonGroup();
        hobbiesLabel = new JLabel("Hobbies:");
        readingCheckBox = new JCheckBox("Reading");
        browsingCheckBox = new JCheckBox("Browsing");
        sleepingCheckBox = new JCheckBox("Sleeping");
        sleepingCheckBox.setSelected(true); // เลือก sleeping
        travelingCheckBox = new JCheckBox("Traveling");
        // Sport components
        sportPanel = new JPanel();
        sportLabel = new JLabel("Sport:");
        String[] sports = { "Badminton", "Boxing", "Football", "Running" };
        sportList = new JList<>(sports);
        sportList.setSelectedValue("Football", true); // เลือก football
        sportScrollPane = new JScrollPane(sportList);
        // Experience components
        experiencePanel = new JPanel();
        experienceLabel = new JLabel("Year of experience in this sport:");
        experienceSlider = new JSlider(0, 20, 0); // เซ็ตค่าเริ่มต้นเป็น 0
        experienceSlider.setMajorTickSpacing(5);
        experienceSlider.setMinorTickSpacing(1);
        experienceSlider.setPaintTicks(true);
        experienceSlider.setPaintLabels(true);
    }

    @Override
    protected void addComponents() {
        super.addComponents();
        // Hobbies Panel
        hobbiesPanel.setLayout(new GridLayout(2, 1));
        cBoxPanel.add(readingCheckBox);
        cBoxPanel.add(browsingCheckBox);
        cBoxPanel.add(sleepingCheckBox);
        cBoxPanel.add(travelingCheckBox);
        hobbiesPanel.add(hobbiesLabel);
        hobbiesPanel.add(cBoxPanel);
        hButtonGroup.add(readingCheckBox);
        hButtonGroup.add(browsingCheckBox);
        hButtonGroup.add(sleepingCheckBox);
        hButtonGroup.add(travelingCheckBox);
        // Sport Panel
        sportPanel.setLayout(layout);
        sportPanel.add(sportLabel);
        sportPanel.add(sportScrollPane);
        // Experience Panel
        experiencePanel.setLayout(new BorderLayout());
        experiencePanel.add(experienceLabel, BorderLayout.NORTH);
        experiencePanel.add(experienceSlider);
        // Add new panels to the mainPanel
        mainPanel2 = new JPanel();
        mainPanel2.setLayout(new BorderLayout());
        mainPanel2.add(hobbiesPanel, BorderLayout.NORTH);
        mainPanel2.add(sportPanel, BorderLayout.CENTER);
        mainPanel2.add(experiencePanel, BorderLayout.SOUTH);
        contentsPanel2.add(mainPanel2);

    }

    public static void createAndShowGUI() {
        PlayerFormV4 msw = new PlayerFormV4("Player Form V4");
        msw.addComponents();
        msw.setJMenuBar(msw.menuBar);
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