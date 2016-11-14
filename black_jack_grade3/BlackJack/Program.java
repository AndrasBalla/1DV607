package BlackJack;

import BlackJack.model.Game;
import BlackJack.model.rules.AbstractFactory;
import BlackJack.model.rules.FactoryProducer;
import BlackJack.view.*;
import BlackJack.controller.*;

public class Program
{

  public static void main(String[] a_args) {
    AbstractFactory factory = FactoryProducer.getFactory("");

    Game g = new Game(factory);
    IView v = new SimpleView(); //new SwedishView();
    PlayGame ctrl = new PlayGame(g,v);
    
    while (ctrl.Play());
  }
}