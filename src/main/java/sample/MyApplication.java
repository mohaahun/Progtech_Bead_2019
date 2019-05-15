package sample;

import com.google.inject.Injector;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Az applikáció belépési pontja.
 */
public class MyApplication extends Application {


    /**
     * @return Stage
     * A window nevű stage elem get metódusa.
     */
    public static Stage getWindow() {
        return window;
    }

    /**
     * Grafikus felület Stage eleme.
     */
    private static Stage window;

    /**
     * @return Parent
     * A root nevű Parent elem get metódusa.
     */
    public static Parent getRoot() {
        return root;
    }

    /**
     * @param roots
     * A root nevű Parent elem set metódusa.
     */
    public static void setRoot(final Parent roots) {
        MyApplication.root = roots;
    }

    /**
     * A javafx alkalmazás Parent eleme.
     */
    private static Parent root;



    @Override
    public final void start(final Stage primaryStage) throws Exception {

        root = FXMLLoader.load(getClass().getResource("/FXML/Menu.fxml"));

        window = primaryStage;
        window.setTitle("Memory Game");
        window.setResizable(false);
        window.setScene(new Scene(root));
        window.show();
    }

    /**
     * @param args
     * Applikáció main metódusa.
     */
    public static void main(final String[] args) {
        launch(); }
}
