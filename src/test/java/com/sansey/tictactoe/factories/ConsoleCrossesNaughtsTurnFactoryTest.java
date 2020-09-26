package com.sansey.tictactoe.factories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sansey.tictactoe.Field;
import com.sansey.tictactoe.TurnFactory;
import com.sansey.tictactoe.turns.ConsoleCrossesTurn;
import com.sansey.tictactoe.turns.ConsoleNaughtsTurn;

class ConsoleCrossesNaughtsTurnFactoryTest {

  @Test
  void oneCallReturnsCrosses() throws Exception {
    TurnFactory factory = new ConsoleCrossesNaughtsTurnFactory();
    Field field = new Field.Fake();
    assertEquals(
      ConsoleCrossesTurn.class, 
      factory.createTurn(field).getClass()
   );
  }
  
  @Test
  void twoCallsReturnsNaughts() throws Exception {
    TurnFactory factory = new ConsoleCrossesNaughtsTurnFactory();
    Field field = new Field.Fake(); 
    factory.createTurn(field);
    assertEquals(
      ConsoleNaughtsTurn.class,
      factory.createTurn(field).getClass()
    );  
  }
  
  @Test
  void threeCallsReturnsCrosses() throws Exception {
    TurnFactory factory = new ConsoleCrossesNaughtsTurnFactory();
    Field field = new Field.Fake(); 
    factory.createTurn(field);
    factory.createTurn(field);
    assertEquals(
        ConsoleCrossesTurn.class,
      factory.createTurn(field).getClass()
    );  
  }
}
