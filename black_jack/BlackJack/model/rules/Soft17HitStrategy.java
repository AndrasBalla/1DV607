package BlackJack.model.rules;


import BlackJack.model.Card;
import BlackJack.model.Player;

public class Soft17HitStrategy implements IHitStrategy {
    private final int g_hitLimit = 17;

    public boolean DoHit(Player a_dealer) {
        int score = a_dealer.CalcScore();
        for(Card c : a_dealer.GetHand()) {
            if (c.GetValue() == Card.Value.Ace && score > 21) {
                score -= 10;
            }
        }
        return score < g_hitLimit;
    }
}
