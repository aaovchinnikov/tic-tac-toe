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
      factory.nextTurn(field).getClass()
   );
  }
  
  @Test
  void twoCallsReturnsNaughts() throws Exception {
    TurnFactory factory = new ConsoleCrossesNaughtsTurnFactory();
    Field field = new Field.Fake(); 
    factory.nextTurn(field);
    assertEquals(
      ConsoleNaughtsTurn.class,
      factory.nextTurn(field).getClass()
    );  
  }
  
  @Test
  void threeCallsReturnsCrosses() throws Exception {
    TurnFactory factory = new ConsoleCrossesNaughtsTurnFactory();
    Field field = new Field.Fake(); 
    factory.nextTurn(field);
    factory.nextTurn(field);
    assertEquals(
        ConsoleCrossesTurn.class,
      factory.nextTurn(field).getClass()
    );  
  }
}
