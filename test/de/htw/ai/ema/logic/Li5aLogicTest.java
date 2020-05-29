package de.htw.ai.ema.logic;

import de.htw.ai.ema.model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Li5aLogicTest {

    Li5aLogic ll = new Li5aLogicImpl();
    Deck deck = new Deck();

    @Test
    public void testDealCards(){
        Card[] cards = deck.getCards();
        Card[] cardsOfFirstHand = new Card[13];
        for(int i = 0; i<13; i++){
            cardsOfFirstHand[i] = cards[i];
        }

        Hand[] hands = ll.dealCards(deck);

        assertTrue("returned array does not have the right size", hands.length==4);
        assertTrue("card list of first hand does not have the right size",
                hands[0].getCards().size()==13);
        //could be coincident but unlikely...
        assertNotEquals("Cards haven't been shuffled", cardsOfFirstHand, hands[1].getCards());
    }

    @Test
    public void testPassCards(){
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        Player p3 = new Player("p4");
        Player p4 = new Player("p5");
        Card c1 = new Card(Suit.CLUBS, Rank.ACE);
        Card c2 = new Card(Suit.HEARTS, Rank.FIVE);
        Card c3 = new Card(Suit.SPADES, Rank.QUEEN);
        Card c4 = new Card(Suit.DIAMONDS, Rank.ACE);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        Hand handP1 = new Hand();
        handP1.setCards(cards);
        p1.setHand(handP1);
        ArrayList<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        Hand[] hands = ll.dealCards(deck);
        for(int i = 1; i<4; i++){
            players.get(i).setHand(hands[i]);
        }
        List<Player> playersAfterPassing = ll.passCards(cards,p1,players);
        assertEquals("p1 didn't pass any cards", 0, playersAfterPassing.get(0).getHand().getCards().size());
        assertEquals("p2 didn't receive any cards", 17, playersAfterPassing.get(1).getHand().getCards().size());
        //TODO geht das so??
        assertTrue("p2 didn't receive the right cards", playersAfterPassing.get(1).getHand().getCards().contains(c1));
    }

    @Test
    public void testFindStartPlayerForGameRound(){
        fail("Not yet implemented");
    }

    @Test
    public void testFindStartPlayerCycle(){
        fail("Not yet implemented");
    }

    @Test
    public void testFindPlayableCards(){
        fail("Not yet implemented");
    }

    @Test
    public void testAddCardsToAccount(){
        fail("Not yet implemented");
    }

    @Test
    public void testCalculateScore(){
        fail("Not yet implemented");
    }

    @Test
    public void testGameIsOver(){
        fail("Not yet implemented");
    }
}
