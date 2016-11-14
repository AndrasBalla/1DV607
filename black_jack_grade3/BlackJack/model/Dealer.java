package BlackJack.model;

import BlackJack.controller.IVisitor;
import BlackJack.model.rules.*;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
  private IWinRule m_winRule;

  public Dealer(AbstractFactory a_rulesFactory) {
    a_rulesFactory = FactoryProducer.getFactory("NEW");
    m_newGameRule = a_rulesFactory.getNewGameStrategy("AMERICAN");
    a_rulesFactory = FactoryProducer.getFactory("HIT");
    m_hitRule = a_rulesFactory.getHitStrategy("BASIC");
    a_rulesFactory = FactoryProducer.getFactory("WIN");
    m_winRule = a_rulesFactory.getNewWinRule("DEALER");
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

  @Override
  public void accept(IVisitor visitor){
    m_newGameRule.accept(visitor);
    m_hitRule.accept(visitor);
    m_winRule.accept(visitor);
    visitor.visit(this);
  }
  
}