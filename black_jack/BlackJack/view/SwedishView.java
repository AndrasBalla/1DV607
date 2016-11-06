package BlackJack.view;

public class SwedishView implements IView {
    private Character[] input ={'b','n','s','a'};
    public void DisplayWelcomeMessage() {
        for(int i = 0; i < 50; i++) {System.out.print("\n");};

        System.out.println("Hej Black Jack Världen");
        System.out.println("----------------------");
        System.out.println("Skriv 'b' för att Spela, 'n' för nytt kort, 's' för att stanna 'a' för att avsluta\n");
    }
        
    public int GetInput() {
        try {
            int c = System.in.read();
            while (c == '\r' || c =='\n') {
              c = System.in.read();
            }
            return c;
          } catch (java.io.IOException e) {
            System.out.println("" + e);
            return 0;
          }
        }

    public Character[] getExpectedInput(){
            return input;
        }
        
    public void DisplayCard(BlackJack.model.Card a_card) {
        if (a_card.GetColor() == BlackJack.model.Card.Color.Hidden) {
            System.out.println("Dolt Kort");
        }
        else {
            String colors[] = { "Hjärter", "Spader", "Ruter", "Klöver" };
            String values[] = { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess" };
            System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
        }
    }
    public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
        DisplayHand("Spelare", a_hand, a_score);
    }
    public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
        DisplayHand("Croupier", a_hand, a_score);
    }
    public void DisplayGameOver(boolean a_dealerIsWinner) {
        System.out.println("Slut: ");
        if (a_dealerIsWinner) {
            System.out.println("Croupiern Vann!");
        }
        else {
            System.out.println("Du vann!");
        }
    }

        private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score) {
            System.out.println(a_name + " Har: " + a_score);
            for(BlackJack.model.Card c : a_hand) {
                DisplayCard(c);
            }
            System.out.println("Poäng: " + a_score);
            System.out.println("");
        }

        public void PrintRules(String[] types){
            System.out.println("Spel typ: " + types[0] + "\nHit Regel : " + types[1] + " \nRegel för vinnare: " + types[2] + "\n");
        }
}
