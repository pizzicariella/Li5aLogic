package de.htw.ai.ema.logic;

import de.htw.ai.ema.model.Card;
import de.htw.ai.ema.model.Deck;
import de.htw.ai.ema.model.Hand;
import de.htw.ai.ema.model.Player;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public interface Li5aLogic {
    /**
     * Takes the whole deck and assigns the cards randomly to four objects of type Hand.
     * @param deck
     * @return Array of type Hand that each contain an array of 13 cards
     */
    public Hand[] dealCards(Deck deck);

    /**
     * This method passes selected cards to the next player.
     * @param selectedCards - Cards to pass
     * @param passingPlayer - Player that is passing the cards
     * @param allPlayers - all players in the game
     * @return
     */
    public List<Player> passCards(List<Card> selectedCards, Player passingPlayer, List<Player> allPlayers);

    /**
     * This method determines which player will start the game round (which player gets to play the first card in
     * current game round). This will be random if firstRound is true (it's the first game round of the game).
     * In case firstRound is false it will be the player that got the Card "SPADESQUEEN" in the last round.
     * @param firstRound
     * @param players - all players in game
     * @return - the start player
     */
    public Player findStartPlayerForGameRound(boolean firstRound, Player[] players);

    /**
     * This method determines which player will start the cycle (which player gets to play the first card in current
     * cycle). This is always the player that had to take cards in the account in the last round.
     * @param players - all players in game
     * @return - the start player
     */
    public Player findStartPlayerCycle(Map<String, Player> players);

    /**
     * This method finds Cards in List which are allowed to played. If startPlayer is true this will be the whole List.
     * If startPlayer is false the outcome depends on cards in the stack object.
     * @param startPlayer - should be true if player is the first in the current cycle, else false
     * @param cards - hand cards of current player
     * @param stack - stack of current cycle
     * @return
     */
    public List<Card> findPlayableCards(boolean startPlayer, List<Card> cards, Stack stack);

    /**
     * This method adds Card of stack to the account of one player in List and returns it. Which player gets the cards
     * depends on the card that each player has put on stack.
     * @param players
     * @param stack
     * @return
     */
    public Player addCardsToAccount(List<Player> players, Stack stack);


    /**
     * This method calculates the score of each player by adding individual scores of cards in account of each player
     * and returns updated List.
     * @param players
     * @return
     */
    public List<Player> calculateScore(List<Player> players);

    /**
     * This method determines whether the game is over or not. Returns true if on of the players in passed list has a
     * score of 151 or higher in it's account, else false.
     * @param players
     * @return
     */
    public boolean gameIsOver(List<Player> players);
}
