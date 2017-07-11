package com.directi.training.unittesting.exercise;

import com.directi.training.unittesting.exercise.DisplayResult.Dao;

import org.junit.Before;
import org.junit.Test;

import static com.directi.training.unittesting.exercise.DisplayResult.Result.DEALER_WIN;
import static com.directi.training.unittesting.exercise.DisplayResult.Result.GAMBLER_WIN;
import static com.directi.training.unittesting.exercise.DisplayResult.Result.PUSH;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DisplayResultTest
{
    Player gamblerMock;
    Player dealerMock;
    DisplayResult subject;
    private Dao mockDao;

    @Before
    public void setUp()
    {
        mockDao = mock(Dao.class);
        gamblerMock = mock(Player.class);
        dealerMock = mock(Player.class);
        subject = new DisplayResult(mockDao);
    }

    @Test
    public void gamblerWinsIfHeHasGreaterValue()
    {
        when(gamblerMock.value()).thenReturn(19);
        when(dealerMock.value()).thenReturn(18);
        DisplayResult.Result result = subject.result(gamblerMock, dealerMock);
        assertEquals(GAMBLER_WIN, result);
        verify(mockDao).insert(result);
    }

    @Test
    public void gamblerWinsIfDealerIsBusted()
    {
        when(gamblerMock.value()).thenReturn(10);
        when(dealerMock.value()).thenReturn(-1);
        DisplayResult.Result result = subject.result(gamblerMock, dealerMock);
        assertEquals(GAMBLER_WIN, result);
        verify(mockDao).insert(GAMBLER_WIN);
    }

    @Test
    public void dealerrWinsIfHeHasGreaterValue()
    {
        when(gamblerMock.value()).thenReturn(17);
        when(dealerMock.value()).thenReturn(19);
        DisplayResult.Result result = subject.result(gamblerMock, dealerMock);
        assertEquals(DEALER_WIN, result);
        verify(mockDao).insert(DEALER_WIN);
    }

    @Test
    public void dealerWinsIfGamblerIsBusted()
    {
        when(gamblerMock.value()).thenReturn(-1);
        when(dealerMock.value()).thenReturn(10);
        DisplayResult.Result result = subject.result(gamblerMock, dealerMock);
        assertEquals(DEALER_WIN, result);
        verify(mockDao).insert(DEALER_WIN);
    }

    @Test
    public void pushIfBothHaveSameValue()
    {
        when(gamblerMock.value()).thenReturn(19);
        when(dealerMock.value()).thenReturn(19);
        DisplayResult.Result result = subject.result(gamblerMock, dealerMock);
        assertEquals(PUSH, result);
        verify(mockDao).insert(PUSH);
    }
}
