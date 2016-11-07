package BlackJack.model.rules;

import BlackJack.model.Player;


public class BasicWinRule implements IWinRule{
    protected final int g_maxScore = 21;

    public boolean progressWin(Player a_dealer, Player a_player){
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

    public boolean instantWin(Player a_dealer, Player a_player){
        if (a_player.CalcScore() == g_maxScore){
            return true;
        }else if (a_player.CalcScore() > g_maxScore){
            return true;
        }else if (a_dealer.CalcScore() > g_maxScore){
            return true;
        }else {
            return false;
        }
    }
}
