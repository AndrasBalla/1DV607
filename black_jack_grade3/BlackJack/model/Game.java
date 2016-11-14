package BlackJack.model;

import BlackJack.model.rules.AbstractFactory;

public class Game {

  private Dealer m_dealer;
  private Player m_player;

  public Game(AbstractFactory factory) {
    m_dealer = new Dealer(factory);
    m_player = new Player();
  }
    
  public boolean IsGameOver() {
    return m_dealer.IsGameOver(m_player);
  }
  
  public boolean IsDealerWinner() {
    return m_dealer.IsDealerWinner(m_player);
  }
  
  public boolean NewGame() {
    return m_dealer.NewGame(m_player);
  }
  
  public boolean Hit() {
    return m_dealer.Hit(m_player);
  }
  
  public boolean Stand() {
    return m_dealer.Stand();
  }
  
  public Iterable<Card> GetDealerHand() {
    return m_dealer.GetHand();
  }
  
  public Iterable<Card> GetPlayerHand()
  {
    return m_player.GetHand();
  }
  
  public int GetDealerScore()
  {
    return m_dealer.CalcScore();
  }
  
  public int GetPlayerScore()
  {
    return m_player.CalcScore();
  }

  public Dealer getDealer(){
    return m_dealer;
  }

  public Player getPlayer(){
    return m_player;
  }

}