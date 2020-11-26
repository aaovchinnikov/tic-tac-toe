package com.sansey.tictactoe.factories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.sansey.tictactoe.Field;
import com.sansey.tictactoe.Turn;
import com.sansey.tictactoe.TurnFactory;
import com.sansey.tictactoe.turns.CrossesTurn;
import com.sansey.tictactoe.turns.NaughtsTurn;

class SyncronizedTurnFactoryTest {

  @ParameterizedTest
  @ValueSource(ints = {10, 99, 100})
  void checkSynchronized(final int threads) throws InterruptedException, ExecutionException {
    final ExecutorService service = Executors.newFixedThreadPool(threads);
    final Collection<Future<Turn>> futures = new ArrayList<>(threads);  
    final CountDownLatch latch = new CountDownLatch(1);
    TurnFactory factory = new SyncronizedTurnFactory(
      new RoundRobinTurnFactory(
        new CrossesTurnFactory(),
        new NaughtsTurnFactory()
      )
    );
    final List<Turn> turns = new ArrayList<>(threads);
    for (int t = 0; t < threads; t++) {
      futures.add(
        service.submit(
          () -> {
            latch.await();
            return factory.nextTurn(new Field.Fake());
          }
        )
      );
    }
    latch.countDown();
    for(Future<Turn> future: futures) {
      turns.add(future.get());
    }
    assertEquals(threads, turns.size());
    int crosses = 0;
    int naughts = 0;
    for (int i = 0; i < turns.size(); i++) {
      if (turns.get(i).getClass() == CrossesTurn.class) {
        crosses++;
      }
      if (turns.get(i).getClass() == NaughtsTurn.class) {
        naughts++;
      }
    }
    if (threads % 2 == 0) {
      assertEquals(threads / 2, crosses);  
    } else {
      assertEquals(threads / 2 + 1, crosses);
    }
    assertEquals(threads / 2, naughts);  
  }
}
