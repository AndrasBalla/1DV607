package BlackJack.model.rules;


public class WinRuleFactory extends AbstractFactory{
    @Override
    public IHitStrategy getHitStrategy (String hit){
        return null;
    }

    @Override
    public INewGameStrategy getNewGameStrategy(String game){
        return null;
    }

    @Override
    public IWinRule getNewWinRule(String win){
        if (win == null){
            return null;
        }
        if (win.equalsIgnoreCase("DEALER")){
            return new DealerWinRule();
        }else if (win.equalsIgnoreCase("PLAYER")){
            return new PlayerWinRule();
        }
        return null;
    }
}
