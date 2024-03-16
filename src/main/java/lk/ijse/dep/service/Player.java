package lk.ijse.dep.service;

public class Player implements Board{
    protected Board board;
    public void movePiece(int col) {

    }

    public Player() {
        this. board = this.board;
    }

    @Override
    public BoardUI getBoardUI() {
        return null;
    }

    @Override
    public int findNextAvailableSpot(int col) {
        return 0;
    }

    @Override
    public boolean isLegalMove(int col) {
        return false;
    }

    @Override
    public boolean existLegalMove() {
        return false;
    }

    @Override
    public void updateMove(int col,Piece move) {

    }

    @Override
    public void updateMove(int col, int row, Piece move) {

    }


    @Override
    public Winner findWinner() {
        return null;
    }

}
