package controller;

import modell.Player;
import sample.MyApplication;
import modell.Deck;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * A játék alatt aktív vezérlőegység.
 */
public class GameController implements Initializable {

    /**
     * Az 1. sor 1. oszlophelyen lévő kártya
     */
    @FXML
    private ImageView card0;
    /**
     * Az 1. sor 2. oszlophelyen lévő kártya
     */
    @FXML
    private ImageView card1;
    /**
     * Az 1. sor 3. oszlophelyen lévő kártya
     */
    @FXML
    private ImageView card2;
    /**
     * Az 1. sor 4. oszlophelyen lévő kártya
     */
    @FXML
    private ImageView card3;
    /**
     * Az 2. sor 1. oszlophelyen lévő kártya
     */
    @FXML
    private ImageView card4;
    /**
     * Az 2. sor 2. oszlophelyen lévő kártya
     */
    @FXML
    private ImageView card5;
    /**
     * Az 2. sor 3. oszlophelyen lévő kártya
     */
    @FXML
    private ImageView card6;
    /**
     * Az 2. sor 4. oszlophelyen lévő kártya
     */
    @FXML
    private ImageView card7;
    /**
     * Az 3. sor 1. oszlophelyen lévő kártya
     */
    @FXML
    private ImageView card8;
    /**
     * Az 3. sor 2. oszlophelyen lévő kártya
     */
    @FXML
    private ImageView card9;
    /**
     * Az 3. sor 3. oszlophelyen lévő kártya
     */
    @FXML
    private ImageView card10;
    /**
     * Az 3. sor 4. oszlophelyen lévő kártya
     */
    @FXML
    private ImageView card11;
    /**
     * Az 4. sor 1. oszlophelyen lévő kártya
     */
    @FXML
    private ImageView card12;
    /**
     * Az 4. sor 2. oszlophelyen lévő kártya
     */
    @FXML
    private ImageView card13;
    /**
     * Az 4. sor 3. oszlophelyen lévő kártya
     */
    @FXML
    private ImageView card14;
    /**
     * Az 4. sor 4. oszlophelyen lévő kártya
     */
    @FXML
    private ImageView card15;

    @FXML
    private TextField namebox;



    Player p1 = new Player();

    /**
     * Jelenleg felfordított lapok száma.
     */
    private int turned = 0;

    /**
     * Felfordított lapokhoz tartozó előlapi képek.
     */
    private ImageView[] target = new ImageView[2];

    /**
     * Alapértelmezett kártyahátlap.
     */
    private Image back;
    //private Image front;

    /**
     * "Üres" (láthatatlan) kártyalap.
     */
    private Image empty;
    /**
     * A kártyákat tartalmazó pakli.
     */
    private Deck asdasd = new Deck();
    /**
     * A kártyákhoz tartozó előlapi képek.
     */
    private ImageView[] cards;
    /**
     * Hátralévő kártyák száma.
     */
    private int remaining;
    /**
     * Alapértelmezett kártyaszám (16).
     */
    private int baselength;

    private String temp;


    @Override
    public final void initialize(
            final URL location, final ResourceBundle resources) {


        back = new Image(getClass()
                .getResource("/cards/back.png")
                .toExternalForm());

        empty = new Image(getClass()
                .getResource("/cards/empty.png")
                .toExternalForm());


            asdasd.builddeck();



        cards = new ImageView[]{
                card0, card1, card2, card3,
                card4, card5, card6, card7,
                card8, card9, card10, card11,
                card12, card13, card14, card15};





        baselength = cards.length;
        remaining = cards.length;
        System.out.println(remaining);

        for (int i = 0; i < baselength; i++) {
            // Decks[i].getNewCard();
            System.out.println(asdasd.getCardsindeck().get(i).getSuit()
                    + " "
                    + asdasd.getCardsindeck().get(i).getValue());

            String uri = "/cards/"
                    + asdasd.getCardsindeck().get(i).getSuit()
                    + "/"
                    + asdasd.getCardsindeck().get(i).getValue()
                    + ".png";

            System.out.println(uri);
            Image asd = new Image(getClass().getResource(uri).toExternalForm());
            asdasd.getCardsindeck().get(i).setPicture(asd);
            cards[i].setImage(back);
        }
    }


    /**
     * @throws IOException
     * A gombra klikkelést lekezelő kód.
     */
    public final void clicked() throws IOException {
        p1.setName(namebox.getText());

    }


    /**
     * @param mouseEvent Egérkezelő Event
     * @throws IOException
     * A kártyákra klikkelést kezelő kód.
     */
   public void pclick(final MouseEvent mouseEvent)
           throws IOException {

        System.out.println("Found the picture!");
        ImageView asd = (ImageView) mouseEvent.getTarget();
        if (asd.getImage().equals(back)) {
            String targetid = (((ImageView) mouseEvent.getTarget()).getId());
            targetid = targetid.replace("card", "");
            int targetnum = Integer.parseInt(targetid);
            System.out.println("target id= " + targetid);

            asd.setImage(asdasd.getCardsindeck().get(targetnum).getPicture());
            target[turned] = asd;


            turned++;
            if (turned == 2) {


                System.out.println("PAIRCHECK!");
                    if (target[0]
                        .getImage()
                        .getUrl()
                        .equals(target[1]
                                .getImage()
                                .getUrl())) {
                    target[0].setImage(empty);
                    target[0].setDisable(true);
                    target[1].setImage(empty);
                    target[1].setDisable(true);
                    turned = 0;
                    remaining = remaining - 2;
                    p1.setSteps(p1.getSteps()+1);
                    if (remaining == 0) {

                        p1.sendscore(p1);

                        MyApplication
                                .setRoot(FXMLLoader
                                        .load(getClass()
                                                .getResource(
                                                        "/FXML/Score.fxml")));

                        MyApplication
                                .getWindow()
                                .setScene(new Scene(MyApplication.getRoot()));
                        MyApplication.getWindow().show();




                    }
                } else {
                    target[0].setImage(back);
                    target[1].setImage(back);
                    turned = 0;
                    p1.setSteps(p1.getSteps()+1);

                }
            }
        }
    }
}
