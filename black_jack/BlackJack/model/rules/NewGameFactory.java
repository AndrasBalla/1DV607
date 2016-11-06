package BlackJack.model.rules;

public class NewGameFactory extends AbstractFactory {
    @Override
    public IHitStrategy getHitStrategy (String hit){
        return null;
    }

    @Override
    public INewGameStrategy getNewGameStrategy(String game){
        if (game == null){
            return null;
        }
        if (game.equalsIgnoreCase("AMERICAN")){
            return new AmericanNewGameStrategy();
        }else if (game.equalsIgnoreCase("INTERNATIONAL")){
            return new InternationalNewGameStrategy();
        }
        return null;
    }

    @Override
    public IWinRule getNewWinRule(String win){
        return null;
    }
}
