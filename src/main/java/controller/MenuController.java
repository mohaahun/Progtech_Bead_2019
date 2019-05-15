package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;

import sample.MyApplication;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * A Kezdőmenüt kezelő modell.controller.
 */
public class MenuController implements Initializable {

    /**
     * New Game gomb.
     */
    @FXML
    private Button ngbutton = new Button();
    /**
     * High Score gomb.
     */
    @FXML
    private Button hsbutton = new Button();
    /**
     * exit gomb.
     */
    @FXML
    private Button ebutton = new Button();

    @FXML
    public TextField pname;



    @Override
    public final void initialize(
            final URL location, final ResourceBundle resources) {

        System.out.println(pname);

        ebutton.setOnAction(e -> exit());
        hsbutton.setOnAction(e -> {
            try {
                getscoreboard();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        ngbutton.setOnAction(e -> {
            try {
                startnew();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    /**
     * @throws IOException
     * Scene váltás új játékra.
     */
    public final void startnew() throws IOException {


        MyApplication.setRoot(FXMLLoader
                .load(getClass().getResource("/FXML/Game.fxml")));
        MyApplication.getWindow().setScene(new Scene(MyApplication.getRoot()));
        MyApplication.getWindow().centerOnScreen();
        MyApplication.getWindow().show();
    }

    /**
     * @throws IOException
     * Scene váltás eredménytáblára.
     */
    public final void getscoreboard() throws IOException {
        MyApplication.setRoot(FXMLLoader
                .load(getClass().getResource("/FXML/Score.fxml")));
        MyApplication.getWindow().setScene(new Scene(MyApplication.getRoot()));
        MyApplication.getWindow().show();
    }

    /**
     * Kilépést kezelő kód.
     */
    public final void exit() {
        Platform.exit();
    }




}


