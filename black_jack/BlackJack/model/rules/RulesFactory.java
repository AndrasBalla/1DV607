package BlackJack.model.rules;

public class RulesFactory {

  public IHitStrategy GetHitRule() {
    return new BasicHitStrategy();
  }

  public IHitStrategy GetSoft17HitRule() {
    return new Soft17HitStrategy();
  }

  public IWinRule GetBasicWinRule(){
    return new BasicWinRule();
  }

  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }
}