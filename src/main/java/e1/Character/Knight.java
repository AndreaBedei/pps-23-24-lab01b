package e1.Character;

import e1.Utility.Position;

public class Knight extends AbstractCharacter{

    public Knight(final Position  position, final int size){
        super(position, size);
    }

    @Override
    public boolean hit(final Position positionToGo, final Character pawn) {
        checkPositionOutOfBound(positionToGo);
		// Below a compact way to express allowed moves for the knight
        final int row = positionToGo.getRow();
        final int col = positionToGo.getCol();
		int x = row-getPosition().getRow(); 
		int y = col-getPosition().getCol();
		if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
			setPosition(positionToGo);
			return pawn.getPosition().equals(this.getPosition());
		}
		return false;
    }

    private void checkPositionOutOfBound(final Position position){
        final int row = position.getRow();
        final int col = position.getCol();
        if (row<0 || col<0 || row >= getSize() || col >= getSize()) {
			throw new IndexOutOfBoundsException();
		}
    }
}
