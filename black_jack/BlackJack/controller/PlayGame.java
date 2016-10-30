package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.model.Game;
import java.util.Observable;
import java.util.Observer;

public class PlayGame implements Observer {
  private Game a_game;
  private IView a_view;
  private Character[] expectedChar;

  public PlayGame(Game in_game, IView in_view) {
    a_game = in_game;
    a_view = in_view;
    expectedChar = in_view.getExpectedInput();
  }

  public boolean Play() {
    a_view.DisplayWelcomeMessage();
    a_game.getDealer().addObserver(this);
    a_game.getPlayer().addObserver(this);

    a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
    a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

    if (a_game.IsGameOver()) {
        a_view.DisplayGameOver(a_game.IsDealerWinner());
    }

    int input = a_view.GetInput();
    
    if (input == expectedChar[0]) {
        a_game.NewGame();
    }
    else if (input == expectedChar[1]) {
        a_game.Hit();
    }
    else if (input == expectedChar[2]) {
        a_game.Stand();
    }

    return input != expectedChar[3];
  }

  private void print(){
    a_view.DisplayWelcomeMessage();
    a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
    a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
    try {
      // thread to sleep for 5000 milliseconds
      Thread.sleep(4000);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @Override
  public void update(Observable o, Object arg){
    print();
  }
}