package com.directi.training.unittesting.exercise;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest
{
    CardDealer cardDealerMock;

    @Before
    public void setUP()
    {
        cardDealerMock = mock(CardDealer.class);
    }

    @Test
    public void playerShouldBustIfValueGreaterThan21()
    {
        when(cardDealerMock.deal()).
                                       thenReturn(new Card(4, 3)).
                                       thenReturn(new Card(10, 2)).
                                       thenReturn(new Card(9, 2));
        try {
            Player player = new Player(cardDealerMock);
            player.deal();
            player.deal();
            player.deal();
            fail();
        } catch (Player.PlayerBustException e) {

        }
    }

    public void playerShouldNotBustIfValueLessThan21()
    {
        when(cardDealerMock.deal()).
                                       thenReturn(new Card(4, 3)).
                                       thenReturn(new Card(10, 2)).
                                       thenReturn(new Card(9, 2));
        try {
            Player player = new Player(cardDealerMock);
            player.deal();
            player.deal();
            player.deal();
        } catch (Player.PlayerBustException e) {
            fail();
        }
    }
}
