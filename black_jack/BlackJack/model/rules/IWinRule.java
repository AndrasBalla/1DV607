package BlackJack.model.rules;

import BlackJack.model.Player;

/**
 * Created by Spiks on 28/10/2016.
 */
public interface IWinRule {
    boolean equalOrHigherScore(Player a_dealer, Player a_player);
}
