package e1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import e1.Character.Character;
import e1.Character.Knight;
import e1.Character.Pawn;
import e1.Utility.Position;
import e1.Utility.PositionImpl;

public class CharacterTest {
    
    Character pawn;
    Character knight;
    final static int SIZE = 5;

    @BeforeEach
    void beforeEach(){
        this.pawn = new Pawn(new PositionImpl(0,0), SIZE);
        this.knight = new Knight(new PositionImpl(1, 2), SIZE);
    }

    @Test
    void checkTheKnightPosition(){
        assertTrue(this.knight.getPosition().equals(new PositionImpl(1, 2)));
    }

    @Test
    void checkThePawnPosition(){
        assertTrue(this.pawn.getPosition().equals(new PositionImpl(0, 0)));
    }

    @Test
    void checkThePawnHasCharacterPawn(){
        assertTrue(this.pawn.hasCharacter(new PositionImpl(0, 0)));
    }

    @Test
    void checkTheKnightHasCharacterPawn(){
        assertFalse(this.pawn.hasCharacter(this.knight.getPosition()));
    }

    @Test
    void checkTheKnightMovement(){
        final Position newPosition = new PositionImpl(3, 3);
        assertFalse(this.knight.hit(newPosition, this.pawn));
        assertTrue(this.knight.hasCharacter(newPosition));
    }

    @Test
    void checkFinalGame(){
        assertTrue(this.knight.hit(new PositionImpl(0, 0), this.pawn));
    }
}
