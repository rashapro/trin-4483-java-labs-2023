package rinthaisong.trin.lab9;

/**
 * This program is PlayerFormV6
 * Show a window, titled "Player Form V6"
 * This program displays results similar to PlayerFormV4.
 * Additional functions of the reset button and the submit button.
 * There is a window showing updates when the user changes the information.
 * Class PlayerFormV6 which inherited from PlayerFormV4.
 * Author: Trin Rinthaisong
 * ID: 653040448-3
 * Sec: 2
 * Date: 23/2/2024
 **/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import rinthaisong.trin.lab8.PlayerFormV4;

public class PlayerFormV6 extends PlayerFormV4 implements ActionListener {
    protected StringBuffer resultBuffer;
    protected String genderSelected;

    public PlayerFormV6(String title) {
        super(title);
    }// กำหนดชื่อของหน้าต่าง(Title)

    protected void addComponents() {
        super.addComponents();
        nameTxt.setText("Trin");
        nationalityTxt.setText("Thai");
        birthTxt.setText("19-12-2003");
    } // เพิ่มส่วนประกอบต่างๆ

    public static void createAndShowGUI() {
        PlayerFormV6 msw = new PlayerFormV6("Athlete Form V6");
        msw.addComponents();
        msw.setJMenuBar(msw.menuBar);
        msw.setFrameFeatures();
        msw.addListeners();
    }

    public void addListeners() {
        submitButton.addActionListener(this);
        resetButton.addActionListener(this);
        nameTxt.addActionListener(this);
        nationalityTxt.addActionListener(this);
        birthTxt.addActionListener(this);
        playerBox.addActionListener(this);
    }// เพิ่มส่วนของตัวดำเนินการ

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        resultBuffer = new StringBuffer();
        if (src == resetButton) { // เมื่อกดปุ่ม submit (เนื่องจากมีความผิดพาดจากMySimpleWindowจึงสลับระหว่างปุ่ม
                                  // submit และ reset)
            handleSubmitButton(); // เรียกใช้เมธอด
        } else if (src == submitButton) { // เมื่อกดปุ่ม reset
            handleResetButton(); // เรียกใช้เมธอด
        } else if (src instanceof JTextField) { // เมื่อมีการดำเนินการของ JTextField
            JTextField tf = (JTextField) src;
            handleTextField(tf); // เรียกใช้เมธอด
        } else if (src == playerBox) { // เมื่อมีการดำเนินการของ playerBox
            handleComboBox(); // เรียกใช้เมธอด
        }
        if (maleRButton.isSelected()) {
            JOptionPane.showMessageDialog(this, "Gender is updated to Male");
        }
        if (femaleRButton.isSelected()) {
            JOptionPane.showMessageDialog(this, "Gender is updated to Female");
        }
    } // การดำเนินการของตัวดำเนินการ

    public boolean handleSubmitButton() { // การดำเนินการของปุ่ม Submit
        String name = nameTxt.getText();
        String nationality = nationalityTxt.getText();
        String birth = birthTxt.getText();
        String playerType = (String) playerBox.getSelectedItem();
        String hobbiesSelected = getSelectedHobbies();
        String sportsSelected = getSelectedSports();
        resultBuffer.append(name + " ");
        resultBuffer.append("has nationality as " + nationality + " and ");
        resultBuffer.append("birthdate as " + birth + ", ");
        resultBuffer.append("is a " + playerType + " player, ");
        resultBuffer.append("has hobbies as " + hobbiesSelected + " and ");
        resultBuffer.append("plays " + sportsSelected);
        JOptionPane.showMessageDialog(null, resultBuffer.toString());
        return false;
    }

    public String getSelectedHobbies() {
        String hobbies = "";
        if (readingCheckBox.isSelected()) {
            hobbies += "Reading ";
        }
        if (browsingCheckBox.isSelected()) {
            hobbies += "Browsing ";
        }
        if (sleepingCheckBox.isSelected()) {
            hobbies += "Sleeping ";
        }
        if (travelingCheckBox.isSelected()) {
            hobbies += "Traveling ";
        }
        return hobbies.trim();
    }

    public String getSelectedSports() {
        return sportList.getSelectedValue();
    }

    public void handleResetButton() { // การดำเนินการของปุ่ม Reset
        nameTxt.setText("");
        nationalityTxt.setText("");
        birthTxt.setText("");
    }

    public void handleTextField(JTextField tf) { // การดำเนินการของ JTextField
        nameTxt.setName("Name is changed to ");
        nationalityTxt.setName("Nationality is changed to ");
        birthTxt.setName("Date of birth is changed to ");
        JOptionPane.showMessageDialog(null, tf.getName() + tf.getText());
    }

    public void handleComboBox() { // การดำเนินการของ JComboBox
        JOptionPane.showMessageDialog(null, "Player type is updated to " + playerBox.getSelectedItem());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }
}