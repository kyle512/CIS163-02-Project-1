package project1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.awt.event.ActionListener;

public class GEOCDTPanelFX extends GridPane {

    private GeoCountDownTimer watch;
    private Timer javaTimer;

    private Button startButton, stopButton;
    private TextField yearField, monthField, dayField;
    private Button addButton, continueButton;

    private Label lblTime;

    public GEOCDTPanelFX() {

        watch = new GeoCountDownTimer();
        javaTimer = new Timer(8, new TimerListener());

        yearField = new TextField("2021");

        add(yearField, 0, 0);
        add(new Label("Years"), 1, 0);

        monthField = new TextField("10");
        add(monthField, 0, 1);
        add(new Label("Months:"), 1, 1);

        dayField = new TextField("10");

        add(dayField, 0, 2);
        add(new Label("Days:"), 1, 2);

        stopButton = new Button("Stop");
        add(stopButton, 0, 3);

        startButton = new Button("Start");
        add(startButton, 1, 3);

        addButton = new Button("Add");
        add(addButton, 0, 6);

        continueButton = new Button("Continue");
        add(continueButton, 0, 8);

        add(new Label(" "), 1, 8);

        lblTime = new Label();
        lblTime.setText(watch.toString());
        add(lblTime, 0, 9);

        add(new Label("Time:"), 1, 9);

        // register the listeners
        stopButton.setOnAction(this::actionPerformed);
        startButton.setOnAction(this::actionPerformed);
        addButton.setOnAction(this::actionPerformed);
        continueButton.setOnAction(this::actionPerformed);
    }

    public void actionPerformed(ActionEvent event) {

        int mins, sec, milli, p;

        if (event.getSource() == stopButton) {
            javaTimer.stop();
        }

        if (event.getSource() == startButton) {
            try {
                mins = Integer.parseInt(yearField.getText());
                sec = Integer.parseInt(monthField.getText());
                milli = Integer.parseInt(dayField.getText());
                watch = new GeoCountDownTimer(mins, sec, milli);
                javaTimer.start();
            } catch (NumberFormatException io) {
                errorMessageDialog("Number Format exception");
            } catch (IllegalArgumentException e) {
                errorMessageDialog("Number Format exception");
            }
        }


//        if (event.getSource() == addButton)
//            watch.inc(Integer.parseInt(addDaysField.getText()));
//
//        if (event.getSource() == stringInputButton)
//            watch = new GeoCountDownTimer(newStringField.getText());

        if (event.getSource() == continueButton) {
             javaTimer.start();
        }

        lblTime.setText(watch.toString());
    }

    private void errorMessageDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
          //  watch.inc(10);

            Platform.runLater(() -> lblTime.setText(watch.toString()));
            Platform.runLater(new Runnable() {
                                  @Override
                                  public void run() {
                                      lblTime.setText(watch.toString());
                                  }
                              });
    //
        }
    }
}