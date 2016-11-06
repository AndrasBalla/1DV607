package BlackJack.model.rules;

import BlackJack.controller.IVisitor;
import BlackJack.model.Player;

public interface IWinRule {
    boolean instantWin(Player a_dealer, Player a_player);
    boolean progressWin(Player a_dealer, Player a_player);
    void accept(IVisitor visitor);
}
