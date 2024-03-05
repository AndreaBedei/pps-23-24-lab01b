package e1;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class LogicTest {
  private final static int SIZE = 5;
  Logics logics;

  @BeforeEach
  void beforeEach(){
    logics = new LogicsImpl(SIZE, new PositionImpl(2, 1), new PositionImpl(0, 0));
  }

  @Test
  void hasPawnInTheFirstPosition(){
    assertTrue(logics.hasPawn(new PositionImpl(2, 1)));
  }

  @Test
  void hasKnightInTheFirstPosition(){
    assertTrue(logics.hasKnight(new PositionImpl(0, 0)));
  }

  @Test
  void hasPawnInErrorPosition(){
    assertFalse(logics.hasPawn(new PositionImpl(0, 0)));
  }

  @Test
  void hasKnightInErrorPosition(){
    assertFalse(logics.hasKnight(new PositionImpl(2, 1)));
  }

  @Test
  void checkIfKnightCanMoveToAWrongNegativePosition(){
    assertThrows(IndexOutOfBoundsException.class, () -> logics.hit(new PositionImpl(-1, -1)));
  }

  @Test
  void checkIfKnightCanMoveToAWrongPosition(){
    final Position position = new PositionImpl(1, 1);
    logics.hit(position);
    assertFalse(logics.hasKnight(position));
  }

  @Test
  void checkIfKnightCanMoveToTheSamePositionOfThePawn(){
    assertTrue(logics.hit(new PositionImpl(2, 1)));
  }

  @Test
  void checkIfKnightCanMoveToRightPosition(){
    final Position position = new PositionImpl(1, 2);
    logics.hit(position);
    assertTrue(logics.hasKnight(position));
  }

  @Test
  void checkIfKnightCanMoveToTheSamePositionOfThePawnWithMoreMovements(){
    logics.hit(new PositionImpl(1, 2));
    logics.hit(new PositionImpl(2, 0));
    logics.hit(new PositionImpl(0, 1));
    logics.hit(new PositionImpl(2, 2));
    logics.hit(new PositionImpl(1, 0));
    logics.hit(new PositionImpl(0, 2));
    assertTrue(logics.hit(new PositionImpl(2, 1)));
  }
}
