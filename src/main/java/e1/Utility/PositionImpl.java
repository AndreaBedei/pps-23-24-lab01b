package e1.Utility;

public class PositionImpl implements Position {

    private int row;

    private int col;

    public PositionImpl(final int row, final int col){
        this.row = row;
        this.col = col;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public void setRow(final int row) {
        this.row = row;
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public void setCol(final int col) {
        this.col = col;
    }

    @Override
    public boolean equals(final Object obj) {
        final Position other = (PositionImpl) obj;
        if (this.row != other.getRow())
            return false;
        if (this.col != other.getCol())
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Position [row=" + this.row + ", col=" + this.col + "]";
    }
}

