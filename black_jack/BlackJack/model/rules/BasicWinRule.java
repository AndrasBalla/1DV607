package BlackJack.model.rules;

import BlackJack.model.Player;


public class BasicWinRule implements IWinRule{

    //TODO: At least one more win type.
    public boolean equalOrHigherScore(Player a_dealer, Player a_player){
        return a_dealer.CalcScore() >= a_player.CalcScore();
    }
}
