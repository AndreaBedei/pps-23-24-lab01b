package e1;

public interface Position {

    /**
     * Take the row.
     * @return the current row.
     */
    int getRow();

    /**
     * Set the row.
     * @param row the new row.
     */
    void setRow(int row);

    /**
     * Take the column.
     * @return the current column.
     */
    int getCol();

    /**
     * Set the column.
     * @param col the new column.
     */
    void setCol(int col);

}