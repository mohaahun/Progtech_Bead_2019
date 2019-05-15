package modell;

import javafx.scene.image.Image;
import java.util.Random;

/**
 * Egy kártyát leíró típus.
 */
public class Card {

    public void setValue(String a) {
        this.value=a;
    }

    public void setSuit (String a){
        this.suit=a;
    }

    /**
     * A különböző kártya típusok felsorolása.
     */
    enum Suits {
        /**
         * Pikk.
         */
        Clubs,
        /**
        * Káró.
        */
        Diamonds,
        /**
        *   Kör.
        */
        Hearts,
        /**
        *   Treff.
        */
        Spades
    }

    /**
     * A különböző kártya értékek felsorolása.
     */
    enum Values {
        /**
         * Asz.
         */
        Ace,
        /**
         * 2.
         */
        Two,
        /**
         * 3.
         */
        Three,
        /**
         * 4.
         */
        Four,
        /**
         * 5.
         */
        Five,
        /**
         * 6.
         */
        Six,
        /**
         * 7.
         */
        Seven,
        /**
         * 8.
         */
        Eight,
        /**
         * 9.
         */
        Nine,
        /**
         * 10.
         */
        Ten,
        /**
         * Bubi.
         */
        Jack,
        /**
         * Dáma.
         */
        Queen,
        /**
         * Király.
         */
        King
    }

    /**
     * @return suit
     * Kártyaszín lekérdezése.
     */
    public final String getSuit() {
        return suit;
    }

    /**
     * @return value
     * Kártya érték lekérdezése.
     */
    public final String getValue() {
        return value;
    }


    /**
     * Kártya színe.
     */
    private String suit;
    /**
     * Kártya értéke.
     */
    private String value;


    /**
     * @param ppicture
     * Kép beállítása.
     */
    public final void setPicture(final Image ppicture) {
        this.picture = ppicture;
    }

    /**
     * @return picture
     * Kép lekérdezése.
     */
    public final Image getPicture() {
        return picture;
    }

    /**
     * Kártyához tartozó kép.
     */
    private Image picture;

    /**
     * @return TSuit
     * Új random szín generálása.
     */
    private String getrandomsuit() {

        int suitnum;
        Random rsuit;
        String tsuit;

        rsuit = new Random();
        suitnum = rsuit.nextInt(Suits.values().length);
        tsuit = String.valueOf(Suits.values()[suitnum]);

        return tsuit;
    }

    /**
     * @return TValue
     * Új random érték generálása.
     */
    private String getrandomvalue() {

        int valuenum;
        Random rvalue;
        String tvalue;

        rvalue = new Random();
        valuenum = rvalue.nextInt(Values.values().length);
        tvalue = String.valueOf(Values.values()[valuenum]);

        return tvalue;
    }


    /**
     * @return Card
     * Egy kártya suit és value értékeit adja vissza egy Card típusban.
     */
    public final Card getNewCard() {



        this.suit = getrandomsuit();
        this.value = getrandomvalue();

        return this;
    }

}
