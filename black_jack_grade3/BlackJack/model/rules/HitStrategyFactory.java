package BlackJack.model.rules;


public class HitStrategyFactory extends AbstractFactory{

    @Override
    public IHitStrategy getHitStrategy (String hit){
        if (hit == null){
            return null;
        }
        if (hit.equalsIgnoreCase("BASIC")){
            return new BasicHitStrategy();
        }else if (hit.equalsIgnoreCase("SOFT17")){
            return new Soft17HitStrategy();
        }
        return null;
    }

    @Override
    public INewGameStrategy getNewGameStrategy(String game){
        return null;
    }

    @Override
    public IWinRule getNewWinRule(String win){
        return null;
    }
}
