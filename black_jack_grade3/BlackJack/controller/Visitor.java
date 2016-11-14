package BlackJack.controller;

import BlackJack.model.Dealer;
import BlackJack.model.rules.IHitStrategy;
import BlackJack.model.rules.INewGameStrategy;
import BlackJack.model.rules.IWinRule;

public class Visitor implements IVisitor {
    private String types[] = new String[3];

    @Override
    public String visit(IHitStrategy hitStrategy) {
        types[0] = hitStrategy.getClass().getSimpleName();
        return hitStrategy.getClass().getSimpleName();
    }

    @Override
    public String visit(IWinRule iWinRule) {
        types[1] = iWinRule.getClass().getSimpleName();
        return iWinRule.getClass().getSimpleName();
    }

    @Override
    public String visit(INewGameStrategy newGameStrategy) {
        types[2] = newGameStrategy.getClass().getSimpleName();
        return newGameStrategy.getClass().getSimpleName();
    }

    @Override
    public void visit(Dealer dealer) {}

    @Override
    public String[] GetTypes(){
        return types;
    }
}
