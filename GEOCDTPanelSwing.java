package project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Write a description  here.
 *
 */
public class GEOCDTPanelSwing extends JPanel {

    private GeoCountDownTimer watch;
    private Timer javaTimer;

    private JButton startButton, stopButton, suspendButton;
    private JTextField yearsField, monthsField, daysField;
    private JButton addButton, continueButton;

    private JLabel lblTime;

    public GEOCDTPanelSwing() {

        // create the game object as well as the GUI1024 Frame
        watch = new GeoCountDownTimer();
        javaTimer = new Timer(1000, new TimerListener());

        setLayout(new GridLayout(10, 2));
        setBackground(Color.lightGray);

        yearsField = new JTextField("2022", 3);
        add(yearsField);

        add(new JLabel("Years:"));

        monthsField = new JTextField("10", 3);
        add(monthsField);
        add(new JLabel("Months:"));

        daysField = new JTextField("10", 3);

        add(daysField);
        add(new JLabel("Days:"));

        stopButton = new JButton("Stop");
        add(stopButton);

        startButton = new JButton("Start");
        add(startButton);

        addButton = new JButton("Add");
        add(addButton);

        continueButton = new JButton("Continue");
        add(continueButton);

        add(new JLabel(" "));

        lblTime = new JLabel();
        lblTime.setText(watch.toString());
        add(lblTime);

        add(new JLabel("   Date "));

        stopButton.addActionListener(new ButtonListener());
        startButton.addActionListener(new ButtonListener());
        addButton.addActionListener(new ButtonListener());
        continueButton.addActionListener(new ButtonListener());
    }

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            int mins, sec, milli, p;

            if (event.getSource() == stopButton) {
                javaTimer.stop();
            }

            if (event.getSource() == startButton) {
                try {
                    mins = Integer.parseInt(yearsField.getText());
                    sec = Integer.parseInt(monthsField.getText());
                    milli = Integer.parseInt(daysField.getText());
                    watch = new GeoCountDownTimer(mins, sec, milli);
                    javaTimer.start();
                } catch (NumberFormatException io) {
                    JOptionPane.showMessageDialog(null, "Enter an integer in all fields");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Error in field");
                }
            }

            // lots more code goes here


//            if (event.getSource() == stringInputButton)
//                watch = new GeoCountDownTimer(newStringField.getText());
//
//            if (event.getSource() == continueButton)
//                javaTimer.start();

            lblTime.setText(watch.toString());
        }

    }

    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
              //  watch.dec(1);
                lblTime.setText(watch.toString());
            }
            catch (Exception exception) {

			}
        }
    }
}