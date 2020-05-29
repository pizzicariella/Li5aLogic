package de.htw.ai.ema.logic;

import de.htw.ai.ema.model.Card;
import de.htw.ai.ema.model.Deck;
import de.htw.ai.ema.model.Hand;
import de.htw.ai.ema.model.Player;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Li5aLogicImpl implements Li5aLogic{

    @Override
    public Hand[] dealCards(Deck deck) {
        Card[] allCards = deck.getCards();
        shuffleCards(allCards);
        Hand[] hands = new Hand[4];
        int i=0;
        while(i<allCards.length) {
            List<Card> l = new LinkedList<>();
            for (int j = 0; j < allCards.length/4; j++) {
                l.add(allCards[i]);
                i++;
            }
            Hand hand = new Hand();
            hand.setCards(l);
            hands[(i-1)/(allCards.length/4)] = hand;
        }
        return hands;
    }

    private void shuffleCards(Card[] cards){
        Random rand = new Random();
        int randomIndex;
        Card tempCard;
        for(int i = cards.length-1; i>0; i--){
            randomIndex = rand.nextInt(i+1);
            tempCard = cards[randomIndex];
            cards[randomIndex] = cards[i];
            cards[i] = tempCard;
        }
    }

    @Override
    public List<Player> passCards(List<Card> SelectedCards, Player passingPlayer, List<Player> allPlayers) {
        return null;
    }

    @Override
    public Player findStartPlayerForGameRound(boolean firstRound, Player[] players) {
        return null;
    }

    @Override
    public Player findStartPlayerCycle(List<Player> players) {
        return null;
    }

    @Override
    public List<Card> findPlayableCards(boolean startPlayer, List<Card> cards, Stack stack) {
        return null;
    }

    @Override
    public Player addCardsToAccount(List<Player> players, Stack stack) {
        return null;
    }

    @Override
    public List<Player> calculateScore(List<Player> players) {
        return null;
    }

    @Override
    public boolean gameIsOver(List<Player> players) {
        return false;
    }
}
