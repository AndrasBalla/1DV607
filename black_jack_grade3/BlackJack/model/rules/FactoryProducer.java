package BlackJack.model.rules;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if (choice.equalsIgnoreCase("HIT")){
            return new HitStrategyFactory();
        }else if (choice.equalsIgnoreCase("NEW")){
            return new NewGameFactory();
        }else if (choice.equalsIgnoreCase("WIN")){
            return new WinRuleFactory();
        }
        return null;
    }
}
