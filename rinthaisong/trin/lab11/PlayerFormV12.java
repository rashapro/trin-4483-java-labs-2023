package rinthaisong.trin.lab11;

/**
 * This program is PlayerFormV12
 * Show a window, titled "Player Form V12"
 * This program displays results similar to PlayerFormV11.
 * Class PlayerFormV9 which inherited from PlayerFormV11.
 * Add the check for null values.
 * Author: Trin Rinthaisong
 * ID: 653040448-3
 * Sec: 2
 * Date: 10/3/2024
 **/
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import rinthaisong.trin.lab10.PlayerFormV11;

public class PlayerFormV12 extends PlayerFormV11 {

    public PlayerFormV12(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        PlayerFormV12 msw = new PlayerFormV12("Player Form V12");
        msw.addComponents();
        msw.addListeners();
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

    public void handleTextField(JTextField tf) {
        if (tf == birthTxt) {
            handleDateTextField(tf);
        } else if (tf == nameTxt) {
            handleNormalTextField(nameTxt, nationalityTxt);
        } else if (tf == nationalityTxt) {
            handleNormalTextField(nationalityTxt, birthTxt);
        }
    }

    public void handleDateTextField(JTextField tf) {
        String date = tf.getText();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate.parse(date, dateFormat);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid date in data of Birth\n");
        }
    }

    public void handleNormalTextField(JTextField namTextTxt) {
        if (nameTxt.getText().isEmpty()) {
            resultBuffer.append("Please enter some data in Name\n");
        }
        JOptionPane.showMessageDialog(this, resultBuffer.toString());
    }

    public void handleNormalTextField(JTextField nationalityTxt, JTextField birthTxt) {
        if (nationalityTxt.getText().isEmpty()) {
            resultBuffer.append("Please enter some data in Nationality\n");
        }
        if (birthTxt.getText().isEmpty()) {
            resultBuffer.append("Please enter a valid date in data of Birth\n");
        }
        JOptionPane.showMessageDialog(this, resultBuffer.toString());
    }
}