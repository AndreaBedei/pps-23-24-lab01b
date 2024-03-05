package e1;

import e1.Utility.Position;

public interface Logics{

   /**
     * attempt to move Knight on position if possible
     * 
     * @param position The position
     * @return whether the pawn has been hit 
     */
    boolean hit(Position position);
    
    /**
     * @param position The position
     * @return whether position has the knight
     */
    boolean hasKnight(Position position);
    
    /**
     * @param position
     * @return whether position has the pawn
     */
    boolean hasPawn(Position position);
    
}
