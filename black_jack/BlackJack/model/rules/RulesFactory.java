package BlackJack.model.rules;

public class RulesFactory {

  public IHitStrategy GetHitRule() {
    return new BasicHitStrategy();
  }

  public IWinRule GetWinRule(){return new BasicWinRule();}

  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }
}