package sample;

import javafx.application.Application;



/**
 * Alkalmazás indítókódja.
 */
public final class Main {


    /**
     * Checkstyle fals pozitív  HideUtilityClassConstructor hiba elhárítására.
     *
     */
    private void anticheckstyle() {

    }

    /**
     * @param args
     * Alkalmazás indítókódja.
     */
    public static void main(final String[] args) {
        System.out.println("asd");


        Application.launch(MyApplication.class, args);
    }

}
