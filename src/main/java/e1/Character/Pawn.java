package e1.Character;

import e1.Utility.Position;

public class Pawn extends AbstractCharacter{
    
    public Pawn(final Position  position, final int size){
        super(position, size);
    }

    @Override
    public boolean hit(final Position positionToGo, final Character pawn) {
        throw new UnsupportedOperationException("Method not can be use by a pawn");
    }

    @Override
    public void setPosition(final Position position) {
        throw new UnsupportedOperationException("Can't be set the pawn position");
    }
}
