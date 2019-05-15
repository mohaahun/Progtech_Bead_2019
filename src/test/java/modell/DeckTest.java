package modell;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    Deck tesztdeck;


    @BeforeEach
    void setUp() {
        tesztdeck=new Deck();
    }

    @AfterEach
    void tearDown() {
        tesztdeck=null;
    }

    @Test
    void getCardsindeck() {
        assertNotNull(tesztdeck);
    }

    @Test
    void builddeck() {
        assertNotNull(tesztdeck.getCardsindeck());
    }


}