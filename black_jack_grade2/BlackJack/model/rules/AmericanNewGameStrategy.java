package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;  

class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Dealer a_dealer, Player a_player) {

    a_dealer.deal(a_player,true);
    a_dealer.deal(a_dealer,true);
    a_dealer.deal(a_player,true);
    a_dealer.deal(a_dealer,false);

    return true;
  }
}