package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.model.Game;
import BlackJack.model.Observer;

public class PlayGame implements Observer {
  private Game a_game;
  private IView a_view;
  private Character[] expectedChar;
  private boolean shouldPrint = true;

  public PlayGame(Game in_game, IView in_view) {
    a_game = in_game;
    a_view = in_view;
    expectedChar = in_view.getExpectedInput();
    a_game.getDealer().registerObserver(this);
    a_game.getPlayer().registerObserver(this);
  }

  public boolean Play() {
    if (shouldPrint){
      a_view.DisplayWelcomeMessage();
      a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
      a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
      shouldPrint = false;
    }


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
      // thread to sleep for 1500 milliseconds
      Thread.sleep(1500);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @Override
  public void update() {
    print();
  }
}