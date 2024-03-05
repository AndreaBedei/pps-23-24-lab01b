package e1.Character;

import e1.Utility.Position;

public interface Character {

    /**
     * @param position the position of the element.
     * @return whether position row, col has the character.
     */
    boolean hasCharacter(Position position);

    /**
     * Attempt to move Knight on position row,col, if possible
     * @param positionToGo the position that Knight has to go.
     * @param pawn the element pawn.
     * @return whether the pawn has been hit 
     */
    boolean hit(final Position positionToGo, final Character pawn);

    /**
     * Get the position of the Character
     * @return the position.
     */
    Position getPosition();

    /**
     * Set the character position.
     * @param position the new position.
     */
    void setPosition(final Position position);
}
