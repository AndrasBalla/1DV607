package BlackJack.model.rules;


import BlackJack.controller.IVisitor;
import BlackJack.model.Card;
import BlackJack.model.Player;

public class Soft17HitStrategy implements IHitStrategy {
    private final int s_hitLimit = 17;

    public boolean DoHit(Player a_dealer) {
        int score = a_dealer.CalcScore();
        for(Card c : a_dealer.GetHand()) {
            if (c.GetValue() == Card.Value.Ace && score == s_hitLimit) {
                score -= 10;
            }
        }
        return score <= s_hitLimit;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
