package e1;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class LogicTest {
  private final static int SIZE = 5;
  Logics logics;

  @BeforeEach
  void beforeEach(){
    logics = new LogicsImpl(SIZE, new Pair<Integer,Integer>(2, 1), new Pair<Integer,Integer>(0, 0));
  }

  @Test
  void hasPawnInTheFirstPosition(){
    assertTrue(logics.hasPawn(2, 1));
  }

  @Test
  void hasKnightInTheFirstPosition(){
    assertTrue(logics.hasKnight(0, 0));
  }

  @Test
  void hasPawnInErrorPosition(){
    assertFalse(logics.hasPawn(0, 0));
  }

  @Test
  void hasKnightInErrorPosition(){
    assertFalse(logics.hasKnight(2, 1));
  }

  @Test
  void checkIfKnightCanMoveToAWrongNegativePosition(){
    assertThrows(IndexOutOfBoundsException.class, () -> logics.hit(-1, -1));
  }

  @Test
  void checkIfKnightCanMoveToAWrongPosition(){
    assertFalse(logics.hit(1, 1));
  }

  @Test
  void checkIfKnightCanMoveToTheSamePositionOfThePawn(){
    assertTrue(logics.hit(2, 1));
  }

  @Test
  void checkIfKnightCanMoveToRightPosition(){
    assertFalse(logics.hit(1, 2));
  }

  @Test
  void checkIfKnightCanMoveToTheSamePositionOfThePawnWithMoreMovements(){
    logics.hit(1, 2);
    logics.hit(2, 0);
    logics.hit(0, 1);
    logics.hit(2, 2);
    logics.hit(1, 0);
    logics.hit(0, 2);
    assertTrue(logics.hit(2, 1));
  }
}
