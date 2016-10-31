package BlackJack.model.rules;

import BlackJack.model.Player;


public class BasicWinRule implements IWinRule{
    protected final int g_maxScore = 21;

    //TODO: At least one more win type.

    public boolean equalOrHigherScore(Player a_dealer, Player a_player){
        if (a_player.CalcScore() == g_maxScore){
            return false;
        }else if (a_player.CalcScore() > g_maxScore){
            return true;
        }else if (a_dealer.CalcScore() > g_maxScore){
            return false;
        }else {
            return a_dealer.CalcScore() >= a_player.CalcScore();
        }
    }
}
