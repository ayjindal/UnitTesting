package com.directi.training.unittesting.exercise;

// suit 1 => CLUBS
// suit 2 => DIAMONDS
// suit 3 => HEARTS
// suit 4 => SPADES

public class Card
{
    private final int number;
    private final int suit;

    public Card(int number, int suit)
    {
        verifyNumber(number);
        verifySuit(suit);
        this.number = number;
        this.suit = suit;
    }

    private void verifySuit(int suit)
    {
        if (suit < 1 || suit > 4) {
            throw new CardGenerationException();
        }
    }

    private void verifyNumber(int number)
    {
        if (number < 1 || number > 13) {
            throw new CardGenerationException();
        }
    }

    public int value()
    {
        if (number > 10) {
            return 10;
        }
        return number;
    }

    private String fetchNum()
    {
        switch (number) {
        case 1:
            return "A";
        case 2:
            return "2";
        case 3:
            return "3";
        case 4:
            return "4";
        case 5:
            return "5";
        case 6:
            return "6";
        case 7:
            return "7";
        case 8:
            return "8";
        case 9:
            return "9";
        case 10:
            return "T";
        case 11:
            return "J";
        case 12:
            return "Q";
        case 13:
            return "K";
        default:
            throw new CardGenerationException();
        }
    }

    private String fetchSuit()
    {
        switch (suit) {
        case 1:
            return "♣";
        case 2:
            return "♦";
        case 3:
            return "♥";
        case 4:
            return "♠";
        default:
            throw new CardGenerationException();
        }
    }

    @Override
    public String toString()
    {
        return fetchSuit() + ":" + fetchNum();
    }

    public static class CardGenerationException extends RuntimeException
    {
    }
}

