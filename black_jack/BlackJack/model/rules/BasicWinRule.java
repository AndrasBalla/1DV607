package BlackJack.model.rules;

import BlackJack.model.Player;


public class BasicWinRule implements IWinRule{

    public boolean equalOrHigherScore(Player a_dealer, Player a_player){
        return a_dealer.CalcScore() >= a_player.CalcScore();
    }
}
