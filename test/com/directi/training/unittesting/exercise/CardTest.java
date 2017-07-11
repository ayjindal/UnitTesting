package com.directi.training.unittesting.exercise;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CardTest
{
    @Test
    public void cardNumberLessThanOneShouldThrowAnError()
    {
        try {
            new Card(0, 2);
            fail();
        } catch (Card.CardGenerationException e) {

        }
    }

    @Test
    public void cardNumberGreaterThanThirteenShouldThrowError()
    {
        try {
            new Card(14, 2);
            fail();
        } catch (Card.CardGenerationException e) {

        }
    }

    @Test
    public void cardNumberBetweenOneAndThritenIsOK()
    {
        try {
            new Card(10, 2);
        } catch (Card.CardGenerationException e) {
            fail();
        }
    }

    @Test
    public void suitNumberLessThanOneShouldThrowAnError()
    {
        try {
            new Card(5, 0);
            fail();
        } catch (Card.CardGenerationException e) {

        }
    }

    @Test
    public void suitNumberGreaterThanFourShouldThrowError()
    {
        try {
            new Card(4, 5);
            fail();
        } catch (Card.CardGenerationException e) {

        }
    }

    @Test
    public void suitNumberBetweenOneAndFourIsOK()
    {
        try {
            new Card(4, 3);
        } catch (Card.CardGenerationException e) {
            fail();
        }
    }

    @Test
    public void cardWithNumberGreaterThan10ShouldGiveValue10()
    {
        Card newCard = new Card(11, 3);
        assertEquals("Card value for cards with number greater than 10 should be 10.", 10,
            newCard.value());
    }

    @Test
    public void cardWithNumber8ShouldGiveValue8()
    {
        Card newCard = new Card(8, 3);
        assertEquals("Card value for card with number 8 should be 8.", 8, newCard.value());
    }

    @Test
    public void stringRepresentationForCardShouldBeValid()
    {
        Card card = new Card(2, 3);
        assertEquals(card.toString(), "♥:2");
    }
}
