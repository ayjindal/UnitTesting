package com.directi.training.unittesting.exercise;

import com.directi.training.unittesting.exercise.DisplayResult.Dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.directi.training.unittesting.exercise.GamePlay.Choice.HIT;
import static com.directi.training.unittesting.exercise.GamePlay.Choice.STAY;

public class GamePlay
{

    private final DisplayResult displayResult = new DisplayResult(new Dao());

    public static void main(String[] args)
    {
        CardDealer cardDealer = new CardDealer();
        Player gambler = new Player(cardDealer);
        Player dealer = new Player(cardDealer);
        gambler.deal();
        gambler.deal();
        dealer.deal();
        System.out.println(new GamePlay().play(gambler, dealer));
    }

    public DisplayResult.Result play(Player gambler, Player dealer)
    {
        try {
            while (true) {
                showGameState(gambler, dealer);
                Choice choice = askHitOrStay();
                if (choice.equals(HIT)) {
                    gambler.deal();
                    continue;
                }
                while (dealer.value() < 17) {
                    dealer.deal();
                    showGameState(gambler, dealer);
                }
                return displayResult.result(gambler, dealer);
            }
        } catch (Player.PlayerBustException e) {
            showGameState(gambler, dealer);
            return displayResult.result(gambler, dealer);
        }
    }

    private Choice askHitOrStay()
    {
        System.out.println("For stay Enter 'S'/'s'. For hit Enter 'H'/'h'.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = br.readLine().substring(0, 1);
            if (input.compareToIgnoreCase("S") == 0) {
                return STAY;
            }
            if (input.compareToIgnoreCase("H") == 0) {
                return HIT;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new WrongInputException();
    }

    private void showGameState(Player gambler, Player dealer)
    {
        System.out
            .println("gambler's value is: " + gambler.value() + " with cards:" + gambler.cards);
        System.out.println("dealer's value is: " + dealer.value() + " with cards:" + dealer.cards);
        System.out.println("------------------------------------------");
    }

    public enum Choice
    {
        HIT, STAY
    }

    private static class WrongInputException extends RuntimeException
    {
    }
}
