package modell;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.scene.image.Image;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    Card tesztcard;
    enum Suits{ Clubs, Diamonds, Hearts, Spades};

    @BeforeEach
    void setUp() {
        tesztcard = new Card();
        tesztcard.getNewCard();
    }

    @AfterEach
    void tearDown() {
        tesztcard = null;
    }

    @Test
    void getSuit() {
        assertNotNull(tesztcard.getSuit());

    }

    @Test
    void getValue() {
        assertNotNull(tesztcard.getValue());
    }

    @Test
    void setPicture() {
    }

    @Test
    void getPicture() {
    }

    @Test
    void getNewCard() {
    }
}