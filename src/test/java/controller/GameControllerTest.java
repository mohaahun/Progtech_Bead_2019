package controller;

import modell.Card;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.scene.image.Image;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    Card c1 = new Card();
    Card c2 = new Card();
    Card c3 = new Card();


    @BeforeEach
    void setUp() {
        c1.setValue("ace");
        c1.setSuit("Hearts");

        c2.setValue("ace");
        c2.setSuit("Hearts");

        c3.setValue("two");
        c3.setSuit("Hearts");

    }

    @AfterEach
    void tearDown() {
        c1.setSuit(null);
        c1.setValue(null);
        c2.setSuit(null);
        c2.setValue(null);
        c3.setSuit(null);
        c3.setValue(null);
    }

    @Test
    void initialize() {
    }

    @Test
    void clicked() {


    }

    @Test
    void pclick() {



        assertNotNull(c1);
        assertNotNull(c2);
        assertNotNull(c3);

        assertTrue(true, String.valueOf(c1.getValue().equals(c2.getValue())));

        assertEquals(true,c3.getSuit().equals(c2.getSuit()));

        assertNotEquals(true,c1.equals(c3));

    }
}