package BlackJack.model.rules;

import BlackJack.controller.IVisitor;
import BlackJack.model.Player;

public interface IHitStrategy {
    boolean DoHit(Player a_dealer);
    void accept(IVisitor visitor);
}