package e1;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Character pawn;
	private Character knight;
	private final Random random = new Random();
	 
    public LogicsImpl(final int size){
        this.pawn = new Pawn(this.randomEmptyPosition(size), size);
		do{
			this.knight = new Knight(this.randomEmptyPosition(size), size);	
		}while(pawn.getPosition().equals(knight.getPosition()));
    }

	public LogicsImpl(final int size, final Position pawnPosition, final Position knightPosition){
        this.pawn = new Pawn(pawnPosition, size);
        this.knight = new Knight(knightPosition, size);	
    }
    
	private final Position randomEmptyPosition(final int size){
    	return new PositionImpl(this.random.nextInt(size), this.random.nextInt(size));
    }

	@Override
	public boolean hit(Position position) {
		return this.knight.hit(position, this.pawn);
	}

	@Override
	public boolean hasKnight(final Position position) {
		return this.knight.hasCharacter(position);
	}

	@Override
	public boolean hasPawn(final Position position) {
		return this.pawn.hasCharacter(position);
	}
}
