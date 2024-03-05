package e1.Character;

import e1.Utility.Position;

public abstract class AbstractCharacter implements Character {

    private Position position;
    private final int size; 
 
    public AbstractCharacter(final Position position, final int size){
        this.position = position;
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    @Override
	public boolean hasCharacter(Position position) {
		return this.position.equals(position);
	}

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(final Position position) {
        this.position = position;
    }
}
