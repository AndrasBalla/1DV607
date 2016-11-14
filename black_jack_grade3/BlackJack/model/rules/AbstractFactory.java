package BlackJack.model.rules;

public abstract class AbstractFactory {
    public abstract IHitStrategy getHitStrategy(String hit);
    public abstract INewGameStrategy getNewGameStrategy(String game);
    public abstract IWinRule getNewWinRule(String win);
}
