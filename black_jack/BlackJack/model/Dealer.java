package BlackJack.model;

import BlackJack.model.rules.*;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
  private IWinRule m_winRule;

  public Dealer(RulesFactory a_rulesFactory) {
  
    m_newGameRule = a_rulesFactory.GetNewGameRule();
    m_hitRule = a_rulesFactory.GetHitRule();
    m_winRule = a_rulesFactory.GetWinRule();
  }
  
  
  public boolean NewGame(Player a_player) {
    if (m_deck == null || IsGameOver(a_player)) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      return m_newGameRule.NewGame(this, a_player);
    }
    return false;
  }

  public boolean Stand() {
    if (m_deck != null){
      ShowHand();
      while (m_hitRule.DoHit(this)){
        deal(this,true);
      }
      return true;
    }
    return false;
  }

  public boolean Hit(Player a_player) {
    if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver(a_player)) {
      deal(a_player,true);
      return true;
    }
    return false;
  }

  public boolean IsDealerWinner(Player a_player) {
    return m_winRule.progressWin(this, a_player);
  }

  public boolean IsGameOver(Player a_player) {
    if (m_deck != null && (m_hitRule.DoHit(this) != true || m_winRule.instantWin(this, a_player))) {
        return true;
    }
    return false;
  }

  public void deal(Player a_player, Boolean bool){
    Card c = m_deck.GetCard();
    c.Show(bool);
    a_player.DealCard(c);
  }
  
}