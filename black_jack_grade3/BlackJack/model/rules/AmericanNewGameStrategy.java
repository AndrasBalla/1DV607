package BlackJack.model.rules;

import BlackJack.controller.IVisitor;
import BlackJack.model.Dealer;
import BlackJack.model.Player;

class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Dealer a_dealer, Player a_player) {

    a_dealer.deal(a_player,true);
    a_dealer.deal(a_dealer,true);
    a_dealer.deal(a_player,true);
    a_dealer.deal(a_dealer,false);

    return true;
  }

  @Override
  public void accept(IVisitor visitor) {
    visitor.visit(this);
  }
}