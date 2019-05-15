package modell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * A játék alatt használt pakli.
 */
public class Deck extends Card {

    /**
     * Pakliméret megadása.
     */
    private static final int DECKSIZE = 16;

    /**
     * @return List
     *     Kártyalista get metódusa.
     */
    public final List<Card> getCardsindeck() {
        return cardsindeck;
    }

    /**
     * Lista ami tárolja a kártyákat.
     */
    private List<Card> cardsindeck = new ArrayList<>(DECKSIZE);

    /**
     * @return Deck
     * A pakli felépítése.
     */
    public final Deck builddeck() {
        for (int i = 0; i < DECKSIZE / 2; i++) {
            Card temp = new Card();
            temp.getNewCard();
            for (int j = 0; j < i;) {
                if (temp.getSuit()
                        .equals(cardsindeck.get(j).getSuit())
                        && temp.getValue()
                        .equals(cardsindeck.get(j).getValue())) {
                    temp.getNewCard();
                } else {
                    j++;
                }
            }

           this.cardsindeck.add(temp);
        }
        for (int i = 0; i < DECKSIZE / 2; i++) {
            this.cardsindeck.add(cardsindeck.get(i));
        }
        Collections.shuffle(this.cardsindeck);

        return this;
    }

}
