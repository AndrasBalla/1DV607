package BlackJack.controller;

import BlackJack.model.Dealer;
import BlackJack.model.rules.IHitStrategy;
import BlackJack.model.rules.INewGameStrategy;
import BlackJack.model.rules.IWinRule;

public interface IVisitor {
    void visit(Dealer dealer);
    String visit(INewGameStrategy newGameStrategy);
    String visit(IHitStrategy hitStrategy);
    String visit(IWinRule iWinRule);
    String[] GetTypes();
}
